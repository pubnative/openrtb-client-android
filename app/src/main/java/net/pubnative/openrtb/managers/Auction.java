package net.pubnative.openrtb.managers;

import android.content.Context;
import android.text.TextUtils;

import net.pubnative.openrtb.OpenRTB;
import net.pubnative.openrtb.api.Macros;
import net.pubnative.openrtb.api.request.BannerBidRequestFactory;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.api.response.models.BidResponse;
import net.pubnative.openrtb.api.response.models.SeatBid;
import net.pubnative.openrtb.models.AuctionResponse;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;
import net.pubnative.openrtb.utils.HttpRequest;
import net.pubnative.openrtb.utils.Logger;
import net.pubnative.openrtb.utils.text.StringEscapeUtils;
import net.pubnative.openrtb.webservice.PNRTBService;
import net.pubnative.openrtb.webservice.ServiceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Auction {
    private static final String TAG = Auction.class.getSimpleName();

    public interface AuctionListener {
        void onSuccess(Bid bid, float auctionPrice);

        void onFailed(Throwable throwable);
    }

    private final AppInfoProvider mAppInfoProvider;
    private final DeviceInfoProvider mDeviceInfoProvider;
    private final UserInfoProvider mUserInfoProvider;

    private final AuctionListener mListener;
    private final Context mContext;

    public Auction(Context context, AuctionListener listener) {
        this(context,
                listener,
                OpenRTB.getAppInfoProvider(),
                OpenRTB.getDeviceInfoProvider(),
                OpenRTB.getUserInfoProvider());
    }

    public Auction(Context context, AuctionListener listener,
                   AppInfoProvider appInfoProvider,
                   DeviceInfoProvider deviceInfoProvider,
                   UserInfoProvider userInfoProvider) {
        this.mContext = context;
        this.mListener = listener;
        this.mAppInfoProvider = appInfoProvider;
        this.mDeviceInfoProvider = deviceInfoProvider;
        this.mUserInfoProvider = userInfoProvider;
    }

    private BidRequest createBidRequest(float bidFloor) {
        return new BannerBidRequestFactory().createBidRequest(
                mAppInfoProvider.getApp(),
                mDeviceInfoProvider.getDevice(),
                mUserInfoProvider.getUser(), bidFloor);
    }

    public void start(float bidFloor) {
        BidRequest bidRequest = createBidRequest(bidFloor);

        PNRTBService pnrtbService = ServiceProvider.getInstance().getPNRTBService();
        Single<BidResponse> bidSource1 = pnrtbService.getBid("dde3c298b47648459f8ada4a982fa92d", "2", bidRequest);
        Single<BidResponse> bidSource2 = pnrtbService.getBid("dde3c298b47648459f8ada4a982fa92d", "7", bidRequest);

        Single<AuctionResponse> auctionResponseSource = Single.zip(bidSource1, bidSource2, AuctionResponse::new);

        auctionResponseSource
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .timeout(5, TimeUnit.SECONDS)
                .subscribe(new SingleObserver<AuctionResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(AuctionResponse auctionResponse) {
                        doAuction(auctionResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mListener != null) {
                            mListener.onFailed(e);
                        }
                    }
                });
    }

    private void doAuction(AuctionResponse auctionResponse) {
        if (auctionResponse != null && !auctionResponse.getList().isEmpty()) {
            float winningBid = 0;
            Bid winner = null;
            List<Bid> losers = new ArrayList<>();

            for (BidResponse response : auctionResponse.getList()) {
                for (SeatBid seatBid : response.seatbid) {
                    for (Bid bid : seatBid.bid) {
                        if (bid.price > winningBid) {
                            winningBid = bid.price;

                            if (winner != null) {
                                losers.add(winner);
                            }

                            winner = bid;
                        } else {
                            losers.add(bid);
                        }
                    }
                }
            }

            if (winner != null) {
                final float auctionPrice = calculateAuctionPrice(winner);

                notifyWinner(winner, auctionPrice);
                notifyLosers(losers, auctionPrice);

                if (mListener != null) {
                    mListener.onSuccess(winner, auctionPrice);
                }
            } else {
                if (mListener != null) {
                    mListener.onFailed(new Exception("No bid"));
                }
            }
        }
    }

    private float calculateAuctionPrice(Bid bid) {
        // do some logic
        return bid.price;
    }

    private void notifyWinner(Bid winner, float auctionPrice) {
        if (TextUtils.isEmpty(winner.nurl)) {
            Logger.d(TAG, "Winning bid has no win notice URL. Dropping call");
        } else {
            String winUrl = winner.nurl.replace(Macros.AUCTION_PRICE, String.valueOf(auctionPrice));
            makeRequest(winUrl);
        }
    }

    private void notifyLosers(List<Bid> losers, float auctionPrice) {
        if (losers != null) {
            for (Bid loser : losers) {
                if (TextUtils.isEmpty(loser.lurl)) {
                    Logger.d(TAG, "Winning bid has no loss notice URL. Dropping call");
                } else {
                    String lossUrl = loser.lurl.replace(Macros.AUCTION_PRICE, String.valueOf(auctionPrice));
                    makeRequest(lossUrl);
                }
            }
        }
    }

    private void makeRequest(String url) {
        HttpRequest request = new HttpRequest();
        request.start(mContext, HttpRequest.Method.GET, StringEscapeUtils.unescapeJava(url), new HttpRequest.Listener() {
            @Override
            public void onPNHttpRequestFinish(HttpRequest request, String result) {

            }

            @Override
            public void onPNHttpRequestFail(HttpRequest request, Exception exception) {

            }
        });
    }
}

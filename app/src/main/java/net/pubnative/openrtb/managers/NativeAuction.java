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
import net.pubnative.openrtb.providers.BiddersProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;
import net.pubnative.openrtb.utils.HttpRequest;
import net.pubnative.openrtb.utils.Logger;
import net.pubnative.openrtb.utils.text.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NativeAuction extends AbstractAuction {
    private static final String TAG = NativeAuction.class.getSimpleName();

    public NativeAuction(Context context, AuctionListener listener) {
        super(context, listener);
    }

    @Override
    public void start(float bidFloor) {
        BidRequest bidRequest = createBidRequest(bidFloor);

        BiddersProvider biddersProvider = new BiddersProvider();

        Single<AuctionResponse> auctionResponseSource = biddersProvider.getAuctionResponseSource(bidRequest);

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

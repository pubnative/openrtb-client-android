package net.pubnative.openrtb.managers;

import net.pubnative.openrtb.api.request.BannerBidRequestFactory;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.api.response.models.BidResponse;
import net.pubnative.openrtb.api.response.models.SeatBid;
import net.pubnative.openrtb.models.AuctionResponse;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;
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
    public interface AuctionListener {
        void onSuccess(Bid bid);
        void onFailed(Throwable throwable);
    }

    private final AppInfoProvider mAppInfoProvider;
    private final DeviceInfoProvider mDeviceInfoProvider;
    private final UserInfoProvider mUserInfoProvider;

    private final AuctionListener mListener;

    private BidResponse mWinnerBid;
    private List<BidResponse> mLoserBids;

    public Auction(AuctionListener listener) {
        this(listener,
                new AppInfoProvider(),
                new DeviceInfoProvider(),
                new UserInfoProvider());
    }

    public Auction(AuctionListener listener,
                   AppInfoProvider appInfoProvider,
                   DeviceInfoProvider deviceInfoProvider,
                   UserInfoProvider userInfoProvider) {
        this.mListener = listener;
        this.mAppInfoProvider = appInfoProvider;
        this.mDeviceInfoProvider = deviceInfoProvider;
        this.mUserInfoProvider = userInfoProvider;
    }

    private BidRequest createBidRequest() {
        return new BannerBidRequestFactory().createBidRequest(
                mAppInfoProvider.getApp(),
                mDeviceInfoProvider.getDevice(),
                mUserInfoProvider.getUser());
    }

    public void start() {
        BidRequest bidRequest = createBidRequest();

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
                for (SeatBid seatBid: response.seatbid) {
                    for (Bid bid: seatBid.bid) {
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
                if (mListener != null) {
                    mListener.onSuccess(winner);
                }
            } else {
                if (mListener != null) {
                    mListener.onFailed(new Exception("No bid"));
                }
            }
        }
    }
}

package net.pubnative.openrtb.managers;

import android.content.Context;
import android.text.TextUtils;

import net.pubnative.openrtb.OpenRTB;
import net.pubnative.openrtb.api.Macros;
import net.pubnative.openrtb.api.request.BannerBidRequestFactory;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.models.AuctionResponse;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.BiddersProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;
import net.pubnative.openrtb.utils.HttpRequest;
import net.pubnative.openrtb.utils.Logger;
import net.pubnative.openrtb.utils.text.StringEscapeUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class AbstractAuction implements Bidder {

    protected final AppInfoProvider mAppInfoProvider;
    protected final DeviceInfoProvider mDeviceInfoProvider;
    protected final UserInfoProvider mUserInfoProvider;

    protected final AuctionListener mListener;
    protected final Context mContext;

    public AbstractAuction(Context context, AuctionListener listener) {
        this(context,
                listener,
                OpenRTB.getAppInfoProvider(),
                OpenRTB.getDeviceInfoProvider(),
                OpenRTB.getUserInfoProvider());
    }

    public AbstractAuction(Context context, AuctionListener listener,
                           AppInfoProvider appInfoProvider,
                           DeviceInfoProvider deviceInfoProvider,
                           UserInfoProvider userInfoProvider) {
        this.mContext = context;
        this.mListener = listener;
        this.mAppInfoProvider = appInfoProvider;
        this.mDeviceInfoProvider = deviceInfoProvider;
        this.mUserInfoProvider = userInfoProvider;
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

    protected abstract void doAuction(AuctionResponse response);

    protected BidRequest createBidRequest(float bidFloor) {
        return new BannerBidRequestFactory().createBidRequest(
                mAppInfoProvider.getApp(),
                mDeviceInfoProvider.getDevice(),
                mUserInfoProvider.getUser(), bidFloor);
    }

    protected void notifyWinner(Bid winner, float auctionPrice) {
        if (TextUtils.isEmpty(winner.nurl)) {
            Logger.d(getTag(), "Winning bid has no win notice URL. Dropping call");
        } else {
            String winUrl = winner.nurl.replace(Macros.AUCTION_PRICE, String.valueOf(auctionPrice));
            makeRequest(winUrl);
        }
    }

    protected void notifyLosers(List<Bid> losers, float auctionPrice) {
        if (losers != null) {
            for (Bid loser : losers) {
                if (TextUtils.isEmpty(loser.lurl)) {
                    Logger.d(getTag(), "Winning bid has no loss notice URL. Dropping call");
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

    protected void notifySuccess(Bid winner, List<Bid> losers, float auctionPrice) {
        notifyWinner(winner, auctionPrice);
        notifyLosers(losers, auctionPrice);

        if (mListener != null) {
            mListener.onSuccess(winner, auctionPrice);
        }
    }

    protected abstract String getTag();
}

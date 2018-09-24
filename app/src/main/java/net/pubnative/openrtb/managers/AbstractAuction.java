package net.pubnative.openrtb.managers;

import android.content.Context;

import net.pubnative.openrtb.OpenRTB;
import net.pubnative.openrtb.api.request.BannerBidRequestFactory;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;

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

    protected BidRequest createBidRequest(float bidFloor) {
        return new BannerBidRequestFactory().createBidRequest(
                mAppInfoProvider.getApp(),
                mDeviceInfoProvider.getDevice(),
                mUserInfoProvider.getUser(), bidFloor);
    }
}

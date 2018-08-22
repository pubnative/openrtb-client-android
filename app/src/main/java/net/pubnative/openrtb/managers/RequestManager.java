package net.pubnative.openrtb.managers;

import android.content.Context;

import net.pubnative.openrtb.api.request.BannerBidRequestFactory;
import net.pubnative.openrtb.api.request.BannerRequestClient;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;

public class RequestManager {
    private final AppInfoProvider mAppInfoProvider;
    private final DeviceInfoProvider mDeviceInfoProvider;
    private final UserInfoProvider mUserInfoProvider;

    public RequestManager(AppInfoProvider appInfoProvider,
                          DeviceInfoProvider deviceInfoProvider,
                          UserInfoProvider userInfoProvider) {
        this.mAppInfoProvider = appInfoProvider;
        this.mDeviceInfoProvider = deviceInfoProvider;
        this.mUserInfoProvider = userInfoProvider;
    }

    public void makeRequest(Context context, BannerRequestClient.Listener listener) {
        BidRequest bidRequest = createBidRequest();

        String requestUrl = "http://dsp.pubnative.net/bid/v1/request?apptoken=dde3c298b47648459f8ada4a982fa92d&zoneid=2";

        BannerRequestClient requestClient = new BannerRequestClient();
        requestClient.doRequest(context, requestUrl, bidRequest, listener);
    }

    private BidRequest createBidRequest() {
        return new BannerBidRequestFactory().createBidRequest(
                mAppInfoProvider.getApp(),
                mDeviceInfoProvider.getDevice(),
                mUserInfoProvider.getUser());
    }
}

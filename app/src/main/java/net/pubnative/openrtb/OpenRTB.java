package net.pubnative.openrtb;

import android.content.Context;

import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;

public class OpenRTB {
    private static AppInfoProvider sAppInfoProvider;
    private static DeviceInfoProvider sDeviceInfoProvider;
    private static UserInfoProvider sUserInfoProvider;

    public static void init(Context context) {
        init(
                new AppInfoProvider(context),
                new DeviceInfoProvider(context),
                new UserInfoProvider(context));
    }

    static void init(
            AppInfoProvider appInfoProvider,
            DeviceInfoProvider deviceInfoProvider,
            UserInfoProvider userInfoProvider) {
        sAppInfoProvider = appInfoProvider;
        sDeviceInfoProvider = deviceInfoProvider;
        sUserInfoProvider = userInfoProvider;
    }

    public static AppInfoProvider getAppInfoProvider() {
        return sAppInfoProvider;
    }

    public static DeviceInfoProvider getDeviceInfoProvider() {
        return sDeviceInfoProvider;
    }

    public static UserInfoProvider getUserInfoProvider() {
        return sUserInfoProvider;
    }
}

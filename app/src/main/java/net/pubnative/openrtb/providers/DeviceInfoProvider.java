package net.pubnative.openrtb.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import net.pubnative.openrtb.api.attributes.ConnectionType;
import net.pubnative.openrtb.api.attributes.DeviceType;
import net.pubnative.openrtb.api.request.models.Device;
import net.pubnative.openrtb.utils.PNAdvertisingIdClient;

public class DeviceInfoProvider {
    private final GeoProvider mGeoProvider;

    private String userAgent;
    private String ip;
    private String carrier;
    private String language;
    private String model;
    private String os;
    private String osVersion;
    private int connectionType;
    private int deviceType;
    private String ifa;

    private boolean mLimitTracking = false;

    public DeviceInfoProvider(Context context) {
        this(context, new GeoProvider(context));
    }

    public DeviceInfoProvider(Context context, GeoProvider geoProvider) {
        this.mGeoProvider = geoProvider;

        this.userAgent = "Dalvik/2.1.0 (Linux; U; Android 6.0; MotoG3 Build/MPI24.65-25)";
        this.ip = "107.219.186.28";
        this.carrier = "att internet services";
        this.language = context.getResources().getConfiguration().locale.getLanguage();
        this.model = Build.MODEL;
        this.os = "Android";
        this.osVersion = Build.VERSION.RELEASE;
        this.connectionType = ConnectionType.WIFI;
        this.deviceType = DeviceType.MOBILE_TABLET;
        this.ifa = "";

        fetchAdvertisingId(context);
    }

    public Device getDevice() {
        Device device = new Device();
        device.ua = getUserAgent();
        device.ip = getIp();
        device.geo = mGeoProvider.getGeo();
        device.carrier = getCarrier();
        device.language = getLanguage();
        device.model = getModel();
        device.os = getOS();
        device.osv = getOSVersion();
        device.connectiontype = getConnectionType();
        device.devicetype = getDeviceType();
        device.ifa = getIFA();
        return device;
    }

    private String getUserAgent() {
        return userAgent;
    }

    private String getIp() {
        return userAgent;
    }

    private String getCarrier() {
        return carrier;
    }

    private String getLanguage() {
        return language;
    }

    private String getModel() {
        return model;
    }

    private String getOS() {
        return os;
    }

    private String getOSVersion() {
        return osVersion;
    }

    private int getConnectionType() {
        return connectionType;
    }

    private int getDeviceType() {
        return deviceType;
    }

    private String getIFA() {
        return ifa;
    }

    public boolean limitTracking() {
        return mLimitTracking;
    }

    /**
     * Attempt to use the play services advertising ID, but fall back on the old style Android ID.
     * https://developer.android.com/training/articles/user-data-ids.html
     * https://support.google.com/googleplay/android-developer/answer/6048248?hl=en
     * https://play.google.com/about/monetization-ads/ads/ad-id/
     */
    @SuppressLint("HardwareIds")
    private void fetchAdvertisingId(Context context) {
        PNAdvertisingIdClient client = new PNAdvertisingIdClient();
        client.request(context, new PNAdvertisingIdClient.Listener() {
            @Override
            public void onPNAdvertisingIdFinish(String advertisingId, Boolean limitTracking) {
                mLimitTracking = limitTracking;
                if (TextUtils.isEmpty(advertisingId)) {
                    ifa = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                } else {
                    ifa = advertisingId;
                }
            }
        });
    }
}

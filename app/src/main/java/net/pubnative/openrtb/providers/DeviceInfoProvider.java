package net.pubnative.openrtb.providers;

import net.pubnative.openrtb.api.attributes.ConnectionType;
import net.pubnative.openrtb.api.attributes.DeviceType;
import net.pubnative.openrtb.api.request.models.Device;

public class DeviceInfoProvider {
    private final GeoProvider mGeoProvider;

    public DeviceInfoProvider() {
        this(new GeoProvider());
    }

    public DeviceInfoProvider(GeoProvider geoProvider) {
        this.mGeoProvider = geoProvider;
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
        return device;
    }

    private String getUserAgent() {
        return "Dalvik/2.1.0 (Linux; U; Android 6.0; MotoG3 Build/MPI24.65-25)";
    }

    private String getIp() {
        return "107.219.186.28";
    }

    private String getCarrier() {
        return "att internet services";
    }

    private String getLanguage() {
        return "en";
    }

    private String getModel() {
        return "Moto G3";
    }

    private String getOS() {
        return "Android";
    }

    private String getOSVersion() {
        return "6.0";
    }

    private int getConnectionType() {
        return ConnectionType.WIFI;
    }

    private int getDeviceType() {
        return DeviceType.MOBILE_TABLET;
    }

    private String getIFA() {
        return "03F9F0E4-937D-4F85-9275-F530E0107B2F";
    }
}

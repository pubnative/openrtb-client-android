package net.pubnative.openrtb.providers;

import net.pubnative.openrtb.api.attributes.LocationType;
import net.pubnative.openrtb.api.request.models.Geo;

public class GeoProvider {
    public Geo getGeo() {
        Geo geo = new Geo();
        geo.lat = getLatitude();
        geo.lon = getLongitude();
        geo.country = getCountry();
        geo.region = getRegion();
        geo.city = getCity();
        geo.zip = getZipCode();
        geo.type = getLocationType();
        return geo;
    }

    private float getLatitude() {
        return 33.9775f;
    }

    private float getLongitude() {
        return -118.2133f;
    }

    private String getCountry() {
        return "USA";
    }

    private String getRegion() {
        return "CA";
    }

    private String getCity() {
        return "los angeles";
    }

    private String getZipCode() {
        return "90001";
    }

    private int getLocationType() {
        return LocationType.GPS;
    }
}

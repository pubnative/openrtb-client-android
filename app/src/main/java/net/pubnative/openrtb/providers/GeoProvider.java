package net.pubnative.openrtb.providers;

import android.content.Context;

import net.pubnative.openrtb.api.attributes.LocationType;
import net.pubnative.openrtb.api.request.models.Geo;

public class GeoProvider {

    private float latitude;
    private float longitude;
    private String country;
    private String region;
    private String city;
    private String zipCode;
    private int locationType;

    public GeoProvider(Context context) {
        this.latitude = 33.9775f;
        this.longitude = -118.2133f;
        this.country = "USA";
        this.region = "CA";
        this.city = "los angeles";
        this.zipCode = "90001";
        this.locationType = LocationType.GPS;
    }

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
        return latitude;
    }

    private float getLongitude() {
        return longitude;
    }

    private String getCountry() {
        return country;
    }

    private String getRegion() {
        return region;
    }

    private String getCity() {
        return city;
    }

    private String getZipCode() {
        return zipCode;
    }

    private int getLocationType() {
        return locationType;
    }
}

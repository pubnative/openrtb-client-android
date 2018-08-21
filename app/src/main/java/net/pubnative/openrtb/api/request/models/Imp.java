package net.pubnative.openrtb.api.request.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Imp {
    public String id;
    public List<Metric> metric;
    public Banner banner;
    public Video video;
    public Audio audio;
    @SerializedName("native")
    public Native aNative;
    public Pmp pmp;
    public String displaymanager;
    public String displaymanagerver;
    public int instl = 0;
    public String tagid;
    public float bidfloor = 0;
    public String bidfloorcur = "USD";
    public int clickbrowser;
    public int secure;
    public List<String> iframebuster;
    public int exp;
    //public Object ext;

    public Imp() {
    }
}

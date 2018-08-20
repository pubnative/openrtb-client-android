package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Imp {
    private String id;
    private List<Metric> metric;
    private Banner banner;
    private Video video;
    private Audio audio;
    private Native aNative;
    private Pmp pmp;
    private String displaymanager;
    private String displaymanagerver;
    private int instl = 0;
    private String tagid;
    private float bidfloor = 0;
    private String bidfloorcur = "USD";
    private int clickbrowser;
    private int secure;
    private List<String> iframebuster;
    private int exp;
    private Object ext;
}

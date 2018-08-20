package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Banner {
    private List<Format> format;
    private int w;
    private int h;
    @Deprecated
    private int wmax;
    @Deprecated
    private int hmax;
    @Deprecated
    private int wmin;
    @Deprecated
    private int hmin;
    private List<Integer> btype;
    private List<Integer> battr;
    private int pos;
    private List<String> mimes;
    private int topframe;
    private List<Integer> expdir;
    private List<Integer> api;
    private String id;
    private int vcm;
    private Object ext;
}

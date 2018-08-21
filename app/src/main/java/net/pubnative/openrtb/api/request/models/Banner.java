package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Banner {
    public List<Format> format;
    public int w;
    public int h;
    @Deprecated
    public int wmax;
    @Deprecated
    public int hmax;
    @Deprecated
    public int wmin;
    @Deprecated
    public int hmin;
    public List<Integer> btype;
    public List<Integer> battr;
    public int pos;
    public List<String> mimes;
    public int topframe;
    public List<Integer> expdir;
    public List<Integer> api;
    public String id;
    public int vcm;
    //public Object ext;
}

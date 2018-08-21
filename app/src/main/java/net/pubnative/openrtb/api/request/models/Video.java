package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Video {
    public List<String> mimes;
    public int minduration;
    public int maxduration;
    public List<Integer> protocols;
    @Deprecated
    public int protocol;
    public int w;
    public int h;
    public int startdelay;
    public int placement;
    public int linearity;
    public int skip;
    public int skipmin = 0;
    public int skipafter = 0;
    public int sequence;
    public List<Integer> battr;
    public int maxextended;
    public int minbitrate;
    public int maxbitrate;
    public int boxingallowed = 1;
    public List<Integer> playbackmethod;
    public int playbackend;
    public List<Integer> delivery;
    public int pos;
    public List<Banner> companionad;
    public List<Integer> api;
    public List<Integer> companiontype;
    //public Object ext;
}

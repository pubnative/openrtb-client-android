package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Video {
    private List<String> mimes;
    private int minduration;
    private int maxduration;
    private List<Integer> protocols;
    @Deprecated
    private int protocol;
    private int w;
    private int h;
    private int startdelay;
    private int placement;
    private int linearity;
    private int skip;
    private int skipmin = 0;
    private int skipafter = 0;
    private int sequence;
    private List<Integer> battr;
    private int maxextended;
    private int minbitrate;
    private int maxbitrate;
    private int boxingallowed = 1;
    private List<Integer> playbackmethod;
    private int playbackend;
    private List<Integer> delivery;
    private int pos;
    private List<Banner> companionad;
    private List<Integer> api;
    private List<Integer> companiontype;
    private Object ext;
}

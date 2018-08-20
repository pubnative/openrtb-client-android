package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class BidRequest {
    private String id;
    private List<Imp> imp;
    private Site site;
    private App app;
    private Device device;
    private User user;
    private int test = 0;
    private int at = 2;
    private int tmax;
    private List<String> wseat;
    private List<String> bseat;
    private int allimps = 0;
    private List<String> cur;
    private List<String> wlang;
    private List<String> bcat;
    private List<String> badv;
    private List<String> bapp;
    private Source source;
    private Regs regs;
    private Object ext;
}

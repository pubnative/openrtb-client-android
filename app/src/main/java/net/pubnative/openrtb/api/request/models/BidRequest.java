package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class BidRequest {
    public String id;
    public List<Imp> imp;
    public Site site;
    public App app;
    public Device device;
    public User user;
    public int test = 0;
    public int at = 2;
    public int tmax;
    public List<String> wseat;
    public List<String> bseat;
    public int allimps = 0;
    public List<String> cur;
    public List<String> wlang;
    public List<String> bcat;
    public List<String> badv;
    public List<String> bapp;
    public Source source;
    public Regs regs;
    //public Object ext;

    public BidRequest() {
    }
}

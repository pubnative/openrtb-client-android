package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Deal {
    public String id;
    public float bidfloor = 0;
    public String bidfloorcur = "USD";
    public int at;
    public List<String> wseat;
    public List<String> wadomain;
    //public Object ext;
}

package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Deal {
    private String id;
    private float bidfloor = 0;
    private String bidfloorcur = "USD";
    private int at;
    private List<String> wseat;
    private List<String> wadomain;
    private Object ext;
}

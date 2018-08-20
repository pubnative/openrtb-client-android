package net.pubnative.openrtb.api.response.models;

import java.util.List;

public class BidResponse {
    private String id;
    private List<SeatBid> seatbid;
    private String bidid;
    private String cur = "USD";
    private String customdata;
    private int nbr;
    private Object ext;
}

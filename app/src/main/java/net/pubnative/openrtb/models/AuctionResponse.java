package net.pubnative.openrtb.models;

import net.pubnative.openrtb.api.response.models.BidResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuctionResponse {
    private final List<BidResponse> mList;
    public AuctionResponse(BidResponse... responses) {
        this.mList = new ArrayList<>(responses.length);

        Collections.addAll(mList, responses);
    }
}

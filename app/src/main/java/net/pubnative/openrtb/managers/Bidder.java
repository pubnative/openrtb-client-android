package net.pubnative.openrtb.managers;

import android.content.Context;

import net.pubnative.openrtb.api.response.models.Bid;

public interface Bidder {
    public interface AuctionListener {
        void onSuccess(Bid bid, float auctionPrice);

        void onFailed(Throwable throwable);
    }

    void start(float bidFloor);
}

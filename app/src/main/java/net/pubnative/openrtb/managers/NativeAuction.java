package net.pubnative.openrtb.managers;

import android.content.Context;

import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.api.response.models.BidResponse;
import net.pubnative.openrtb.api.response.models.SeatBid;
import net.pubnative.openrtb.models.AuctionResponse;

import java.util.ArrayList;
import java.util.List;

public class NativeAuction extends AbstractAuction {
    private static final String TAG = NativeAuction.class.getSimpleName();

    public NativeAuction(Context context, AuctionListener listener) {
        super(context, listener);
    }

    @Override
    protected void doAuction(AuctionResponse auctionResponse) {
        if (auctionResponse != null && !auctionResponse.getList().isEmpty()) {
            float winningBid = 0;
            Bid winner = null;
            List<Bid> losers = new ArrayList<>();

            for (BidResponse response : auctionResponse.getList()) {
                for (SeatBid seatBid : response.seatbid) {
                    for (Bid bid : seatBid.bid) {
                        if (bid.price > winningBid) {
                            winningBid = bid.price;

                            if (winner != null) {
                                losers.add(winner);
                            }

                            winner = bid;
                        } else {
                            losers.add(bid);
                        }
                    }
                }
            }

            if (winner != null) {
                final float auctionPrice = calculateAuctionPrice(winner);

                notifySuccess(winner, losers, auctionPrice);
            } else {
                if (mListener != null) {
                    mListener.onFailed(new Exception("No bid"));
                }
            }
        } else {
            if (mListener != null) {
                mListener.onFailed(new Exception("No bid"));
            }
        }
    }

    private float calculateAuctionPrice(Bid bid) {
        // do some logic
        return bid.price;
    }

    @Override
    protected String getTag() {
        return TAG;
    }
}

package net.pubnative.openrtb.webinterface;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.api.response.models.BidResponse;
import net.pubnative.openrtb.utils.StringUtils;

import java.util.List;

public class WebAuctionInterface {
    public interface Listener {
        void onSuccess(Bid bid, float auctionPrice);
        void onFailure(Throwable error);
    }

    private final Listener mListener;
    private final String mResponsesJson;

    public WebAuctionInterface(List<BidResponse> responses, Listener listener) {
        this.mListener = listener;
        this.mResponsesJson = StringUtils.convertObjectsToJson(responses);
    }

    @JavascriptInterface
    public void notifySuccess(String winningBid, String losers, float auctionPrice) {
        if (!TextUtils.isEmpty(winningBid)) {
            Bid bid = StringUtils.convertStringToObject(winningBid, Bid.class);
            if (bid != null && mListener != null) {
                mListener.onSuccess(bid, auctionPrice);
            }
        } else {
            notifyFailure("No winning bid was received");
        }
    }

    @JavascriptInterface
    public void notifyFailure(String error) {
        String message = "Error performing web auction";

        if (!TextUtils.isEmpty(error)) {
            message = error;
        }

        if (mListener != null) {
            mListener.onFailure(new Exception(message));
        }
    }

    @JavascriptInterface
    public String getResponses() {
        return mResponsesJson;
    }
}

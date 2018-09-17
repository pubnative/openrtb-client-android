package net.pubnative.openrtb.webinterface;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.utils.StringUtils;

public class WebAuctionInterface {
    public interface Listener {
        void onSuccess(Bid bid);
        void onFailure(Throwable error);
    }

    private final Context mContext;
    private final Listener mListener;
    private final String mRequestJson;

    public WebAuctionInterface(Context context, String requestJson, Listener listener) {
        mContext = context;
        this.mListener = listener;
        this.mRequestJson = requestJson;
    }

    @JavascriptInterface
    public void notifySuccess(String winningBid) {
        if (!TextUtils.isEmpty(winningBid)) {
            Bid bid = StringUtils.convertStringToObject(winningBid, Bid.class);
            if (bid != null && mListener != null) {
                mListener.onSuccess(bid);
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
    public String getBidRequestJson() {
        return mRequestJson;
    }
}

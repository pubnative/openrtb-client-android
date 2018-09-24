package net.pubnative.openrtb.managers;

import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.pubnative.openrtb.OpenRTB;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;
import net.pubnative.openrtb.utils.StringUtils;
import net.pubnative.openrtb.webinterface.WebAuctionInterface;

public class WebAuction extends AbstractAuction implements WebAuctionInterface.Listener {
    private static final String TAG = NativeAuction.class.getSimpleName();

    private final WebView mAuctionContainer;

    public WebAuction(Context context, AuctionListener listener) {
        this(context,
                listener,
                OpenRTB.getAppInfoProvider(),
                OpenRTB.getDeviceInfoProvider(),
                OpenRTB.getUserInfoProvider());
    }

    public WebAuction(Context context, AuctionListener listener,
                         AppInfoProvider appInfoProvider,
                         DeviceInfoProvider deviceInfoProvider,
                         UserInfoProvider userInfoProvider) {
        super(context, listener, appInfoProvider, deviceInfoProvider, userInfoProvider);
        this.mAuctionContainer = new WebView(context);
    }

    @Override
    public void start(float bidFloor) {
        BidRequest bidRequest = createBidRequest(bidFloor);
        String requestJson = StringUtils.convertObjectToJson(bidRequest);

        mAuctionContainer.getSettings().setJavaScriptEnabled(true);
        mAuctionContainer.addJavascriptInterface(new WebAuctionInterface(requestJson, this), "OpenRTBBridge");
        mAuctionContainer.setWebChromeClient(chromeClient);
        mAuctionContainer.setWebViewClient(webViewClient);

        mAuctionContainer.loadUrl("file:///android_asset/auction.html");
    }

    @Override
    public void onSuccess(Bid bid, float auctionPrice) {
        if (mListener != null) {
            if (bid != null) {
                mListener.onSuccess(bid, auctionPrice);
            } else {
                mListener.onFailed(new Exception("Invalid bid returned"));
            }
        }
    }

    @Override
    public void onFailure(Throwable error) {
        if (mListener != null) {
            mListener.onFailed(error);
        }
    }

    private final WebChromeClient chromeClient = new WebChromeClient() {
        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }
    };

    private final WebViewClient webViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    };
}

package net.pubnative.openrtb.managers;

import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import net.pubnative.openrtb.OpenRTB;
import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.models.AuctionResponse;
import net.pubnative.openrtb.providers.AppInfoProvider;
import net.pubnative.openrtb.providers.DeviceInfoProvider;
import net.pubnative.openrtb.providers.UserInfoProvider;
import net.pubnative.openrtb.webinterface.WebAuctionInterface;

import java.util.ArrayList;
import java.util.List;

public class WebAuction extends AbstractAuction implements WebAuctionInterface.Listener {
    private static final String TAG = WebAuction.class.getSimpleName();

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
    protected void doAuction(AuctionResponse response) {
        if (response != null && !response.getList().isEmpty()) {
            mAuctionContainer.getSettings().setJavaScriptEnabled(true);
            mAuctionContainer.addJavascriptInterface(new WebAuctionInterface(response.getList(), this), "OpenRTBBridge");
            mAuctionContainer.setWebChromeClient(chromeClient);
            mAuctionContainer.setWebViewClient(webViewClient);

            mAuctionContainer.loadUrl("file:///android_asset/auction.html");
        } else {
            if (mListener != null) {
                mListener.onFailed(new Exception("No bid"));
            }
        }
    }

    @Override
    public void onSuccess(Bid bid, List<Bid> losers, float auctionPrice) {
        if (bid != null) {
            notifySuccess(bid, losers, auctionPrice);
        } else {
            if (mListener != null) {
                mListener.onFailed(new Exception("No bid"));
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

    @Override
    protected String getTag() {
        return TAG;
    }
}

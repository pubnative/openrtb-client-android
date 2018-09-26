package net.pubnative.openrtb.ui.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import net.pubnative.openrtb.R;
import net.pubnative.openrtb.api.Macros;
import net.pubnative.openrtb.api.response.models.Bid;
import net.pubnative.openrtb.managers.Bidder;
import net.pubnative.openrtb.managers.NativeAuction;
import net.pubnative.openrtb.managers.WebAuction;
import net.pubnative.openrtb.mraid.MRAIDBanner;
import net.pubnative.openrtb.mraid.MRAIDNativeFeature;
import net.pubnative.openrtb.mraid.MRAIDNativeFeatureListener;
import net.pubnative.openrtb.mraid.MRAIDView;
import net.pubnative.openrtb.mraid.MRAIDViewListener;
import net.pubnative.openrtb.utils.Logger;
import net.pubnative.openrtb.utils.UrlHandler;
import net.pubnative.openrtb.utils.text.StringEscapeUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements Bidder.AuctionListener, MRAIDViewListener, MRAIDNativeFeatureListener {
    private static final String TAG = MainFragment.class.getSimpleName();

    private FrameLayout mAdContainer;
    private UrlHandler mUrlHandler;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_request_native).setOnClickListener(v -> doNativeRequest());

        view.findViewById(R.id.button_request_web).setOnClickListener(v -> doWebRequest());

        mAdContainer = view.findViewById(R.id.ad_container);

        mUrlHandler = new UrlHandler(getActivity());
    }

    private void doNativeRequest() {
        getNativeAuction().start(0.01f);
    }

    private void doWebRequest() {
        getWebAuction().start(0.01f);
    }

    private Bidder getNativeAuction() {
        return new NativeAuction(getActivity(), this);
    }

    private Bidder getWebAuction() {
        return new WebAuction(getActivity(), this);
    }


    // Auction callback
    @Override
    public void onSuccess(Bid bid, float auctioPrice) {
        Logger.d(TAG, "onSuccess");
        getActivity().runOnUiThread(() -> renderAd(bid));
    }

    @Override
    public void onFailed(Throwable throwable) {
        Logger.e(TAG, "onFailed: ", throwable);
        Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void renderAd(Bid bid) {
        mAdContainer.removeAllViews();
        if (TextUtils.isEmpty(bid.adm)) {
            Toast.makeText(getActivity(), "The received bid contains no ad creative", Toast.LENGTH_SHORT).show();
        } else {
            String escapedAd = bid.adm.replace(Macros.AUCTION_PRICE, String.valueOf(bid.price));
            escapedAd = StringEscapeUtils.unescapeJava(escapedAd);
            String[] supportedFeatures = new String[]{
                    MRAIDNativeFeature.CALENDAR,
                    MRAIDNativeFeature.INLINE_VIDEO,
                    MRAIDNativeFeature.SMS,
                    MRAIDNativeFeature.STORE_PICTURE,
                    MRAIDNativeFeature.TEL
            };

            MRAIDBanner banner = new MRAIDBanner(getActivity(), "", escapedAd, supportedFeatures, this, this);
            mAdContainer.addView(banner);
        }
    }

    @Override
    public void mraidViewLoaded(MRAIDView mraidView) {

    }

    @Override
    public boolean mraidViewResize(MRAIDView mraidView, int width, int height, int offsetX, int offsetY) {
        return true;
    }

    @Override
    public void mraidViewExpand(MRAIDView mraidView) {

    }

    @Override
    public void mraidViewClose(MRAIDView mraidView) {

    }

    @Override
    public void mraidNativeFeatureCallTel(String url) {

    }

    @Override
    public void mraidNativeFeatureCreateCalendarEvent(String eventJSON) {

    }

    @Override
    public void mraidNativeFeatureOpenBrowser(String url) {
        mUrlHandler.handleUrl(url);
    }

    @Override
    public void mraidNativeFeaturePlayVideo(String url) {

    }

    @Override
    public void mraidNativeFeatureSendSms(String url) {

    }

    @Override
    public void mraidNativeFeatureStorePicture(String url) {

    }
}

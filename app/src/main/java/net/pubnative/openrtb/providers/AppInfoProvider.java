package net.pubnative.openrtb.providers;

import android.content.Context;

import net.pubnative.openrtb.api.attributes.ContentCategories;
import net.pubnative.openrtb.api.request.models.App;

import java.util.ArrayList;
import java.util.List;

public class AppInfoProvider {
    private static final int PRIVACY_POLICY_YES = 1;
    private static final int PRIVACY_POLICY_NO = 0;

    private static final String STORE_URL_PREFFIX = "https://play.google.com/store/apps/details?id=";

    private String exchangeAppId;
    private String appName;
    private String appBundle;
    private List<String> categories;
    private String storeUrl;
    private String keywords;
    private int privacyPolicy;

    private final PublisherInfoProvider mPublisherInfoProvider;

    public AppInfoProvider(Context context) {
        this(context, new PublisherInfoProvider(context));
    }

    public AppInfoProvider(Context context, PublisherInfoProvider publisherInfoProvider) {
        this.mPublisherInfoProvider = publisherInfoProvider;

        this.exchangeAppId = "100110011";
        this.appName = "Test_Android";
        this.appBundle = context.getApplicationContext().getPackageName();
        this.categories = new ArrayList<>();
        this.categories.add(ContentCategories.Automotive.AUTO_PARTS);
        this.categories.add(ContentCategories.Automotive.AUTO_REPAIR);
        this.categories.add("IAB2-2");
        this.storeUrl = STORE_URL_PREFFIX + appBundle;
        this.keywords = "test, android";
        this.privacyPolicy = PRIVACY_POLICY_YES;
    }

    public App getApp() {
        App app = new App();
        app.id = getExchangeAppId();
        app.name = getAppName();
        app.bundle = getAppBundle();
        app.cat = getCategories();
        app.storeurl = getStoreUrl();
        app.keywords = getKeywords();
        app.privacypolicy = getPrivacyPolicy();
        app.publisher = mPublisherInfoProvider.getPublisher();
        return app;
    }

    private String getExchangeAppId() {
        return exchangeAppId;
    }

    private String getAppName() {
        return appName;
    }

    private String getAppBundle() {
        return appBundle;
    }

    private List<String> getCategories() {
        return categories;
    }

    private String getStoreUrl() {
        return storeUrl;
    }

    private String getKeywords() {
        return keywords;
    }

    private int getPrivacyPolicy() {
        return privacyPolicy;
    }
}

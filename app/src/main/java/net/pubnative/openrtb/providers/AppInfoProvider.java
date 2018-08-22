package net.pubnative.openrtb.providers;

import net.pubnative.openrtb.api.attributes.ContentCategories;
import net.pubnative.openrtb.api.request.models.App;

import java.util.ArrayList;
import java.util.List;

public class AppInfoProvider {
    private static final int PRIVACY_POLICY_YES = 1;
    private static final int PRIVACY_POLICY_NO = 0;

    private final PublisherInfoProvider mPublisherInfoProvider;

    public AppInfoProvider() {
        this(new PublisherInfoProvider());
    }

    public AppInfoProvider(PublisherInfoProvider publisherInfoProvider) {
        this.mPublisherInfoProvider = publisherInfoProvider;
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
        return "100110011";
    }

    private String getAppName() {
        return "Test_Android";
    }

    private String getAppBundle() {
        return "com.android.test";
    }

    private List<String> getCategories() {
        List<String> list = new ArrayList<>();
        list.add(ContentCategories.Automotive.AUTO_PARTS);
        list.add(ContentCategories.Automotive.AUTO_REPAIR);
        list.add("IAB2-2");
        return list;
    }

    private String getStoreUrl() {
        return "https://play.google.com/store/apps/details?id=com.android.test";
    }

    private String getKeywords() {
        return "test, android";
    }

    private int getPrivacyPolicy() {
        return PRIVACY_POLICY_YES;
    }
}

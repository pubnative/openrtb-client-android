package net.pubnative.openrtb.providers;

import android.content.Context;

import net.pubnative.openrtb.api.request.models.Publisher;

public class PublisherInfoProvider {

    private String exchangePublisherId;
    private String name;

    public PublisherInfoProvider(Context context) {
        this.exchangePublisherId = "839929398393092";
        this.name = "TestPublisher";
    }

    public Publisher getPublisher() {
        Publisher publisher = new Publisher();
        publisher.id = getExchangePublisherId();
        publisher.name = getName();
        return publisher;
    }

    private String getExchangePublisherId() {
        return exchangePublisherId;
    }

    private String getName() {
        return name;
    }
}

package net.pubnative.openrtb.providers;

import net.pubnative.openrtb.api.request.models.Publisher;

public class PublisherInfoProvider {
    public Publisher getPublisher() {
        Publisher publisher = new Publisher();
        publisher.id = getExchangePublisherId();
        publisher.name = getName();
        return publisher;
    }

    private String getExchangePublisherId() {
        return "839929398393092";
    }

    private String getName() {
        return "TestPublisher";
    }
}

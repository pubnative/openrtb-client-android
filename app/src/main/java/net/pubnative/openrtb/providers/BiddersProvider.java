package net.pubnative.openrtb.providers;

import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.BidResponse;
import net.pubnative.openrtb.models.AuctionResponse;
import net.pubnative.openrtb.webservice.PNRTBService;
import net.pubnative.openrtb.webservice.ServiceProvider;

import io.reactivex.Single;

public class BiddersProvider {
    private final PNRTBService pnrtbService;

    public BiddersProvider() {
        this.pnrtbService = ServiceProvider.getInstance().getPNRTBService();
    }

    public Single<AuctionResponse> getAuctionResponseSource(BidRequest bidRequest) {
        Single<BidResponse> bidSource1 = pnrtbService.getBid("dde3c298b47648459f8ada4a982fa92d", "2", bidRequest);
        Single<BidResponse> bidSource2 = pnrtbService.getBid("dde3c298b47648459f8ada4a982fa92d", "7", bidRequest);

        return Single.zip(bidSource1, bidSource2, AuctionResponse::new);
    }
}

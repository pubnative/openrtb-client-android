package net.pubnative.openrtb.api.request;

import net.pubnative.openrtb.api.request.models.App;
import net.pubnative.openrtb.api.request.models.Banner;
import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.request.models.Device;
import net.pubnative.openrtb.api.request.models.Imp;
import net.pubnative.openrtb.api.request.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BannerBidRequestFactory {

    public BidRequest createBidRequest(App app, Device device, User user, float bidFloor) {
        BidRequest bidRequest = new BidRequest();

        bidRequest.id = UUID.randomUUID().toString();

        Imp imp = new Imp();
        imp.id = UUID.randomUUID().toString();
        Banner banner = new Banner();
        banner.w = 300;
        banner.h = 250;
        imp.banner = banner;
        imp.tagid = "1";
        imp.bidfloor = bidFloor;
        imp.bidfloorcur = "USD";
        imp.secure = 1;
        bidRequest.imp = new ArrayList<>(1);
        bidRequest.imp.add(imp);

        bidRequest.app = app;
        bidRequest.device = device;
        bidRequest.user = user;

        bidRequest.at = 2;
        bidRequest.tmax = 4500;
        bidRequest.allimps = 0;

        List<String> cur = new ArrayList<>(1);
        cur.add("USD");
        bidRequest.cur = cur;

        List<String> bcat = new ArrayList<>(3);
        bcat.add("IAB24");
        bcat.add("IAB25");
        bcat.add("IAB26");
        bidRequest.bcat = bcat;

        return bidRequest;
    }
}

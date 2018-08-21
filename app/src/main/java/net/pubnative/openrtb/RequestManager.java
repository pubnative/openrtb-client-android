package net.pubnative.openrtb;

import android.content.Context;

import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.utils.HttpRequest;
import net.pubnative.openrtb.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RequestManager {

    public void makeRequest(Context context) {
        HttpRequest request = new HttpRequest();

        BidRequest bidRequest = new BidRequest();

        Map<String, String> headers = new HashMap<>();
        headers.put("x-openrtb-version", "2.3");
        headers.put("Content-Type", "application/json");
        headers.put("Accept-Charset", "utf-8");
        request.setHeaders(headers);

        String post = StringUtils.convertObjectToJson(bidRequest);
        request.setPOSTString(post);

        String requestUrl = "http://dsp.pubnative.net/bid/v1/request?apptoken=<APP-TOKEN>&zoneid=<YOUR-ZONE-ID>";
        request.start(context, HttpRequest.Method.POST, requestUrl, new HttpRequest.Listener() {
            @Override
            public void onPNHttpRequestFinish(HttpRequest request, String result) {

            }

            @Override
            public void onPNHttpRequestFail(HttpRequest request, Exception exception) {

            }
        });
    }
}

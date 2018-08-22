package net.pubnative.openrtb.api.request;

import android.content.Context;
import android.text.TextUtils;

import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.BidResponse;
import net.pubnative.openrtb.utils.HttpRequest;
import net.pubnative.openrtb.utils.Logger;
import net.pubnative.openrtb.utils.StringUtils;


import java.util.HashMap;
import java.util.Map;

public class BannerRequestClient {
    private static final String TAG = BannerRequestClient.class.getSimpleName();

    public interface Listener {
        void onSuccess(BidResponse model);

        void onFailure(Throwable error);
    }

    public void doRequest(Context context, String url, BidRequest requestModel, final Listener listener) {
        try {
            HttpRequest httpRequest = new HttpRequest();

            Map<String, String> headers = new HashMap<>();
            headers.put("x-openrtb-version", "2.3");
            headers.put("Content-Type", "application/json");
            headers.put("Accept-Charset", "utf-8");
            httpRequest.setHeaders(headers);

            String post = StringUtils.convertObjectToJson(requestModel);
            httpRequest.setPOSTString(post);

            httpRequest.start(context, HttpRequest.Method.POST, url, new HttpRequest.Listener() {
                @Override
                public void onPNHttpRequestFinish(HttpRequest request, String result) {
                    if (listener != null) {
                        handleResponse(result, listener);
                    }
                }

                @Override
                public void onPNHttpRequestFail(HttpRequest request, Exception exception) {
                    if (listener != null) {
                        listener.onFailure(exception);
                    }
                }
            });
        } catch (Exception exception) {
            Logger.e(TAG, exception.getMessage());
            listener.onFailure(exception);
        }
    }

    private void handleResponse(String result, Listener listener) {
        if (TextUtils.isEmpty(result)) {
            Exception exception = new Exception("Empty response received from server");
            Logger.e(TAG, exception.getMessage());
            listener.onFailure(exception);
        } else {
            try {
                BidResponse model = StringUtils.convertStringToObject(result, BidResponse.class);
                listener.onSuccess(model);
            } catch (Exception exception) {
                Logger.e(TAG, exception.getMessage());
                listener.onFailure(exception);
            }
        }
    }
}

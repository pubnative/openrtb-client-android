package net.pubnative.openrtb.webservice;

import net.pubnative.openrtb.api.request.models.BidRequest;
import net.pubnative.openrtb.api.response.models.BidResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PNRTBService {
    @POST("request")
    Single<BidResponse> getBid(@Query("apptoken") String appToken,
                               @Query("zoneid") String zoneid,
                               @Body BidRequest bidRequest);
}

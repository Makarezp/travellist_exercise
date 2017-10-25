package com.believeapps.travelinfo.api;

import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TravelRepublicApi {


    @POST("hotels/deals/search")
    Observable<Object> getHotelsByChildeDestination(@Query("fields") String fields, @Body HotelsByChildDestinationQuery jsonQuery);
}

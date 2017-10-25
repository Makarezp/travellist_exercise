package com.believeapps.travelinfo.api;


import com.believeapps.travelinfo.api.model.Hotels;
import com.believeapps.travelinfo.api.model.HotelsByChildDestination;
import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TravelRepublicApi {


    @POST("hotels/deals/search")
    Single<HotelsByChildDestination> getHotelsByChildeDestination(@Query("fields") String fields, @Body HotelsByChildDestinationQuery jsonQuery);
}

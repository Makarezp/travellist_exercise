package com.believeapps.travelinfo.api;

import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import io.reactivex.Single;

public interface Repository {

     Single<Object> getHotelsByChildDestination(HotelsByChildDestinationQuery query);

}

package com.believeapps.travelinfo.api;


import com.believeapps.travelinfo.api.model.Hotels;
import com.believeapps.travelinfo.api.model.HotelsByChildDestination;
import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import java.util.List;

import io.reactivex.Single;

public interface Repository {

     Single<List<Hotels>> getHotelsByChildDestination(HotelsByChildDestinationQuery query);

}

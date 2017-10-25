package com.believeapps.travelinfo.repository;


import com.believeapps.travelinfo.model.DestinationHotels;
import com.believeapps.travelinfo.api.queryobjects.HotelsByChildDestinationQuery;

import java.util.List;

import io.reactivex.Single;

public interface Repository {

     Single<List<DestinationHotels>> getHotelsByChildDestination(HotelsByChildDestinationQuery query);

}

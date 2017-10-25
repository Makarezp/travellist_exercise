package com.believeapps.travelinfo.api;

import com.believeapps.travelinfo.api.model.Aggregates;
import com.believeapps.travelinfo.api.model.AggregatesContainter;
import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import io.reactivex.Single;

public interface Repository {

     Single<AggregatesContainter> getHotelsByChildDestination(HotelsByChildDestinationQuery query);

}

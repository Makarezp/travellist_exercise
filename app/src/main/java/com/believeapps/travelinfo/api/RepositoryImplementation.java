package com.believeapps.travelinfo.api;

import com.believeapps.travelinfo.api.model.Aggregates;
import com.believeapps.travelinfo.api.model.AggregatesContainter;
import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import javax.inject.Inject;

import io.reactivex.Single;

public class RepositoryImplementation implements Repository {

    private TravelRepublicApi mApi;


    public RepositoryImplementation(TravelRepublicApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public Single<AggregatesContainter> getHotelsByChildDestination(HotelsByChildDestinationQuery query) {
        return mApi.getHotelsByChildeDestination("Aggregates.HotelsByChildDestination", query);
    }
}

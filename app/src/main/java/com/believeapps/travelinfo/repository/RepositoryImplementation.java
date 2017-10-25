package com.believeapps.travelinfo.repository;


import com.believeapps.travelinfo.api.TravelRepublicApi;
import com.believeapps.travelinfo.api.wrappers.HotelsByChildDestination;
import com.believeapps.travelinfo.model.DestinationHotels;
import com.believeapps.travelinfo.api.queryobjects.HotelsByChildDestinationQuery;


import java.util.List;

import io.reactivex.Single;

public class RepositoryImplementation implements Repository {

    private TravelRepublicApi mApi;


    public RepositoryImplementation(TravelRepublicApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public Single<List<DestinationHotels>> getHotelsByChildDestination(HotelsByChildDestinationQuery query) {
        return mApi.getHotelsByChildeDestination("Aggregates.HotelsByChildDestination", query)
                .map(HotelsByChildDestination::getDestinationHotelsList);
    }
}

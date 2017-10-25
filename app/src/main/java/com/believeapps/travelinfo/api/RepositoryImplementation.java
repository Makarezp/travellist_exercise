package com.believeapps.travelinfo.api;


import com.believeapps.travelinfo.api.model.Hotels;
import com.believeapps.travelinfo.api.model.HotelsByChildDestination;
import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;


import java.util.List;

import io.reactivex.Single;

public class RepositoryImplementation implements Repository {

    private TravelRepublicApi mApi;


    public RepositoryImplementation(TravelRepublicApi mApi) {
        this.mApi = mApi;
    }

    @Override
    public Single<List<Hotels>> getHotelsByChildDestination(HotelsByChildDestinationQuery query) {
        return mApi.getHotelsByChildeDestination("Aggregates.HotelsByChildDestination", query)
                .map(HotelsByChildDestination::getHotelsList);
    }
}

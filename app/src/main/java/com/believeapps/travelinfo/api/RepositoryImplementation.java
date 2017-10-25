package com.believeapps.travelinfo.api;

import javax.inject.Inject;

public class RepositoryImplementation implements Repository {

    private TravelRepublicApi mApi;


    public RepositoryImplementation(TravelRepublicApi mApi) {
        this.mApi = mApi;
    }
}

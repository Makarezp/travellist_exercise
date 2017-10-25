package com.believeapps.travelinfo.repository;


import com.believeapps.travelinfo.api.TravelRepublicApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    Repository provideRepository(TravelRepublicApi api) {
        return new RepositoryImplementation(api);
    }
}

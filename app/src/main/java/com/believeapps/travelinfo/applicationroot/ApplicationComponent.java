package com.believeapps.travelinfo.applicationroot;

import com.believeapps.travelinfo.api.ApiModule;
import com.believeapps.travelinfo.repository.RepositoryModule;
import com.believeapps.travelinfo.screens.travellist.TravelListComponent;
import com.believeapps.travelinfo.screens.travellist.TravelListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class,
                RepositoryModule.class
        }
)
public interface ApplicationComponent {

        TravelListComponent getTravelListComponent(TravelListModule module);

}

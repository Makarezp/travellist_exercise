package com.believeapps.travelinfo.dependencyinjection.application;

import com.believeapps.travelinfo.BaseApplication;
import com.believeapps.travelinfo.api.ApiModule;
import com.believeapps.travelinfo.screens.travellist.TravelListComponent;
import com.believeapps.travelinfo.screens.travellist.TravelListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class
        }
)
public interface ApplicationComponent {

        TravelListComponent getTravelListComponent(TravelListModule module);

}

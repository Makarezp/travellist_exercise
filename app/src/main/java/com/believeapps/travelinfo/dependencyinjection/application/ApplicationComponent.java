package com.believeapps.travelinfo.dependencyinjection.application;

import com.believeapps.travelinfo.BaseApplication;
import com.believeapps.travelinfo.api.ApiModule;

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

}

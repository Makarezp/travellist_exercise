package com.believeapps.travelinfo.dependencyinjection.application;

import com.believeapps.travelinfo.BaseApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {

}

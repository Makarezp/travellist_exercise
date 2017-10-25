package com.believeapps.travelinfo.dependencyinjection.application;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;

import com.believeapps.travelinfo.viewmodelfactory.ViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application application(){
        return mApplication;
    }

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory factory) {
        return factory;
    }


}

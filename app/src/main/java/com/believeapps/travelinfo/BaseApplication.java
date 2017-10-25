package com.believeapps.travelinfo;

import android.app.Application;

import com.believeapps.travelinfo.dependencyinjection.application.ApplicationComponent;
import com.believeapps.travelinfo.dependencyinjection.application.ApplicationModule;
import com.believeapps.travelinfo.dependencyinjection.application.DaggerApplicationComponent;

public class BaseApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}

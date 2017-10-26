package com.believeapps.travelinfo.screens.travellist;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.believeapps.travelinfo.applicationroot.viewmodelfactory.ViewModelFactory;
import com.believeapps.travelinfo.model.DestinationHotels;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class TravelListModule {

    private final Fragment mFragment;

    public TravelListModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @TravelListScope
    ViewModelProvider.Factory provideViewModelFactory(ViewModelFactory factory) {
        return factory;
    }

    @Named("destinationHotelsLiveData")
    @TravelListScope
    @Provides
    MutableLiveData<List<DestinationHotels>> provideMLDDestinationHotels(){
        return new MutableLiveData<>();
    }


    @Named("errorLiveData")
    @TravelListScope
    @Provides
    MutableLiveData<Boolean> provideMTDError(){
        return new MutableLiveData<>();
    }


    @Named("loadingLiveData")
    @TravelListScope
    @Provides
    MutableLiveData<Boolean> provideMTDLoadingStates() {
        return new MutableLiveData<>();
    }

    @TravelListScope
    @Provides
    FragmentActivity providesActivity() {
        return mFragment.getActivity();
    }
}

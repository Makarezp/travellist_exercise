package com.believeapps.travelinfo.applicationroot.viewmodelfactory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.believeapps.travelinfo.screens.travellist.TravelListViewModel;

import javax.inject.Inject;

public class ViewModelFactory implements ViewModelProvider.Factory {


    private TravelListViewModel travelListViewModel;

    @Inject
    public ViewModelFactory(TravelListViewModel mTravelListModel) {
        this.travelListViewModel = mTravelListModel;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TravelListViewModel.class)) {
            return (T) travelListViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}

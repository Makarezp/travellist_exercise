package com.believeapps.travelinfo.screens.travellist;

import android.arch.lifecycle.ViewModel;

import com.believeapps.travelinfo.api.Repository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class TravelListViewModel extends ViewModel {


    private CompositeDisposable compositeDisposable;
    private Repository repository;


    @Inject
    public TravelListViewModel(Repository repository) {
        this.repository = repository;
        compositeDisposable = new CompositeDisposable();
    }
}

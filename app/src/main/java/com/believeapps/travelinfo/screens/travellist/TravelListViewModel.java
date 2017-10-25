package com.believeapps.travelinfo.screens.travellist;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.believeapps.travelinfo.api.Repository;
import com.believeapps.travelinfo.api.model.HotelsByChildDestinationQuery;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class TravelListViewModel extends ViewModel {


    private CompositeDisposable compositeDisposable;
    private Repository repository;


    @Inject
    public TravelListViewModel(Repository repository) {
        this.repository = repository;
        compositeDisposable = new CompositeDisposable();
    }

    public void getHotels() {
        HotelsByChildDestinationQuery query = new HotelsByChildDestinationQuery.Builder()
                .flexibility(3)
                .duration(7)
                .adults(2)
                .domainId(1)
                .cultureCode("en-gb")
                .currencyCode("GBP")
                .fieldFlags(8143571)
                .includeAggregates(true)
                .build();

        repository.getHotelsByChildDestination(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        object -> Log.d(this.getClass().getSimpleName(), "getHotels: " + object),
                        err -> Log.d(this.getClass().getSimpleName(), "getHotels: " + err)
                );
    }
}

package com.believeapps.travelinfo.screens.travellist;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.believeapps.travelinfo.repository.Repository;
import com.believeapps.travelinfo.api.queryobjects.DatesAndDuration;
import com.believeapps.travelinfo.api.queryobjects.HotelsByChildDestinationQuery;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

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


        repository.getHotelsByChildDestination(buildQuery())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        object -> Log.d(this.getClass().getSimpleName(), "getHotels: " + object.toString()),
                        err -> Log.d(this.getClass().getSimpleName(), "getHotels: " + err)
                );
    }

    private Date getDateForQuery() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND,0);
        c.set(Calendar.MILLISECOND,0);
        c.add(Calendar.MONTH, 5);
        return c.getTime();
    }

    private HotelsByChildDestinationQuery buildQuery() {
        String[] originAirport = {"LHR", "LCY", "LGW", "LTN", "STN", "SEN"};

        return new HotelsByChildDestinationQuery.Builder()
                .flexibility(3)
                .duration(7)
                .adults(2)
                .domainId(1)
                .cultureCode("en-gb")
                .currencyCode("GBP")
                .fieldFlags(8143571)
                .includeAggregates(true)
                .originAirports(Arrays.asList(originAirport))
                .datesAndDurations(Collections.singletonList(new DatesAndDuration(getDateForQuery(), 7)))
                .build();
    }
}

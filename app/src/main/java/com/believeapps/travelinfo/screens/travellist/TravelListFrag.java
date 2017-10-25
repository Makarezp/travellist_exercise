package com.believeapps.travelinfo.screens.travellist;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.believeapps.travelinfo.BaseApplication;
import com.believeapps.travelinfo.R;

import javax.inject.Inject;


public class TravelListFrag extends Fragment {


    private TravelListViewModel mTravelListViewModel;

    @Inject
    ViewModelProvider.Factory mFactory;

    public TravelListFrag() {
        // Required empty public constructor
    }


    public static TravelListFrag newInstance() {
        TravelListFrag fragment = new TravelListFrag();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_travel_list, container, false);
        // Inflate the layout for this fragment

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getApplicationComponent()
                .getTravelListComponent(new TravelListModule())
                .inject(this);
        mTravelListViewModel = ViewModelProviders.of(this, mFactory).get(TravelListViewModel.class);
        mTravelListViewModel.getHotels();

    }
}

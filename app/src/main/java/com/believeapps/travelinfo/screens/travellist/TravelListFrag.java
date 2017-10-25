package com.believeapps.travelinfo.screens.travellist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.believeapps.travelinfo.R;


public class TravelListFrag extends Fragment {


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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_travel_list, container, false);
    }

}

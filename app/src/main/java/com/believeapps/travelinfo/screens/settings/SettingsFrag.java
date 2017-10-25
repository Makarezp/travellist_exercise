package com.believeapps.travelinfo.screens.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.believeapps.travelinfo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFrag extends Fragment {


    public SettingsFrag() {
        // Required empty public constructor
    }

    public static SettingsFrag newInstance() {
        return new SettingsFrag();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }




}

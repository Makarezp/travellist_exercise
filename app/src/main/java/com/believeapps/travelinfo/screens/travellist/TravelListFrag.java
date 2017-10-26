package com.believeapps.travelinfo.screens.travellist;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.believeapps.travelinfo.applicationroot.BaseApplication;
import com.believeapps.travelinfo.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TravelListFrag extends Fragment {


    private TravelListViewModel mTravelListViewModel;

    @Inject
    ViewModelProvider.Factory mFactory;

    @Inject
    FragmentActivity mFragmentActivity;

    @BindView(R.id.loading_status)
    ProgressBar loadingStatusView;

    private Unbinder butterUnbinder;

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
        butterUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BaseApplication) getActivity().getApplication())
                .getApplicationComponent()
                .getTravelListComponent(new TravelListModule(this))
                .inject(this);
        mTravelListViewModel = ViewModelProviders.of(this, mFactory).get(TravelListViewModel.class);
        mTravelListViewModel.getHotels();
        mTravelListViewModel.loadingStatus.observe(this, this::showLoading);
        mTravelListViewModel.errorStatus.observe(this, this::showError);
    }

    private void showError(Boolean isErrorVisible) {

    }

    private void showLoading(Boolean showLoading) {
        if (showLoading) {
            loadingStatusView.setVisibility(View.VISIBLE);
            mFragmentActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        } else {
            loadingStatusView.setVisibility(View.GONE);
            mFragmentActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterUnbinder.unbind();
    }
}

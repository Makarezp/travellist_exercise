package com.believeapps.travelinfo.screens.travellist;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.believeapps.travelinfo.applicationroot.BaseApplication;
import com.believeapps.travelinfo.R;
import com.believeapps.travelinfo.model.DestinationHotels;

import java.util.List;

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

    @BindView(R.id.constraint_layout)
    ConstraintLayout constraintLayout;

    @BindView(R.id.travel_list_recycler)
    RecyclerView recycler;

    private DestinationHotelsAdapter mAdpter;

    Snackbar errorSnackbar;

    private Unbinder butterUnbinder;

    public TravelListFrag() {
        // Required empty public constructor
    }


    public static TravelListFrag newInstance() {
        TravelListFrag fragment = new TravelListFrag();
        return fragment;
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
        initRecycler();
        mTravelListViewModel = ViewModelProviders.of(this, mFactory).get(TravelListViewModel.class);
        mTravelListViewModel.getHotels();
        mTravelListViewModel.loadingStatus.observe(this, this::showLoading);
        mTravelListViewModel.errorStatus.observe(this, this::showError);
        mTravelListViewModel.destinationHotelsList.observe(this, this::showData);
        errorSnackbar = Snackbar.make(constraintLayout, "Error while retrieving data", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", v -> mTravelListViewModel.getHotels());

    }

    public void initRecycler() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(mFragmentActivity, 2);
        recycler.setLayoutManager(layoutManager);
        mAdpter = new DestinationHotelsAdapter();
        recycler.setAdapter(mAdpter);
    }

    private void showData(List<DestinationHotels> destinationHotelsList) {
        if (mAdpter != null) {
            mAdpter.swap(destinationHotelsList);
        }
    }

    private void showError(Boolean isErrorVisible) {
        if (isErrorVisible) {
            errorSnackbar.show();
        } else {
            errorSnackbar.dismiss();
        }
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

package com.believeapps.travelinfo.screens.travellist;

import dagger.Component;
import dagger.Subcomponent;


@Subcomponent(
        modules = {
                TravelListModule.class
        }
)
public interface TravelListComponent {

    void inject(TravelListFrag frag);
}

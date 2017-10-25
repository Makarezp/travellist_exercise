package com.believeapps.travelinfo.api.model;

import java.util.List;

public class HotelsByChildDestination {


    private List<Hotels> hotelsList;


    public HotelsByChildDestination(List<Hotels> hotelsList) {
        this.hotelsList = hotelsList;
    }

    public List<Hotels> getHotelsList() {
        return hotelsList;
    }

    public void setHotelsList(List<Hotels> hotelsList) {
        this.hotelsList = hotelsList;
    }

    @Override
    public String toString() {
        return "HotelsByChildDestination{" +
                "hotelsList=" + hotelsList +
                '}';
    }
}

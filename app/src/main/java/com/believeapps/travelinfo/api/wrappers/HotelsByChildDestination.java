package com.believeapps.travelinfo.api.wrappers;

import com.believeapps.travelinfo.model.DestinationHotels;

import java.util.List;

public class HotelsByChildDestination {


    private List<DestinationHotels> destinationHotelsList;


    public HotelsByChildDestination(List<DestinationHotels> hotelsList) {
        this.destinationHotelsList = hotelsList;
    }

    public List<DestinationHotels> getDestinationHotelsList() {
        return destinationHotelsList;
    }

    public void setDestinationHotelsList(List<DestinationHotels> destinationHotelsList) {
        this.destinationHotelsList = destinationHotelsList;
    }

    @Override
    public String toString() {
        return "HotelsByChildDestination{" +
                "destinationHotelsList=" + destinationHotelsList +
                '}';
    }
}

package com.believeapps.travelinfo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatesAndDuration {

    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Duration")
    @Expose
    private Integer duration;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}




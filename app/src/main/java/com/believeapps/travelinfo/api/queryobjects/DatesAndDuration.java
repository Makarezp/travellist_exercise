package com.believeapps.travelinfo.api.queryobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DatesAndDuration {

    @SerializedName("Date")
    @Expose
    private Date date;
    @SerializedName("Duration")
    @Expose
    private Integer duration;

    public DatesAndDuration(Date date, Integer duration) {
        this.date = date;
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

}




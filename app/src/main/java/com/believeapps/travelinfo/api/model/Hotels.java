package com.believeapps.travelinfo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hotels {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("MinPrice")
    @Expose
    private Integer minPrice;
    @SerializedName("Position")
    @Expose
    private Integer position;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", minPrice=" + minPrice +
                ", position=" + position +
                '}';
    }
}

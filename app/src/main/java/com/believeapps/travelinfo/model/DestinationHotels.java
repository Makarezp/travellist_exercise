package com.believeapps.travelinfo.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationHotels implements Comparable<DestinationHotels> {

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

    private String imageId;
    private String imageType;

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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public int compareTo(@NonNull DestinationHotels o) {
        return Integer.compare(getPosition(), o.getPosition());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DestinationHotels that = (DestinationHotels) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (minPrice != null ? !minPrice.equals(that.minPrice) : that.minPrice != null)
            return false;
        if (position != null ? !position.equals(that.position) : that.position != null)
            return false;
        if (imageId != null ? !imageId.equals(that.imageId) : that.imageId != null) return false;
        return imageType != null ? imageType.equals(that.imageType) : that.imageType == null;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (minPrice != null ? minPrice.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
        result = 31 * result + (imageType != null ? imageType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DestinationHotels{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", minPrice=" + minPrice +
                ", position=" + position +
                ", imageId=" + imageId +
                ", imageType=" + imageType +
                '}';
    }
}

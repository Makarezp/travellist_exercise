package com.believeapps.travelinfo.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HotelsByChildDestinationQuery {



    @SerializedName("DatesAndDurations")
    @Expose
    private List<DatesAndDuration> datesAndDurations = null;
    @SerializedName("Flexibility")
    @Expose
    private Integer flexibility;
    @SerializedName("Duration")
    @Expose
    private Integer duration;
    @SerializedName("Adults")
    @Expose
    private Integer adults;
    @SerializedName("DomainId")
    @Expose
    private Integer domainId;
    @SerializedName("CultureCode")
    @Expose
    private String cultureCode;
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;
    @SerializedName("OriginAirports")
    @Expose
    private List<String> originAirports = null;
    @SerializedName("FieldFlags")
    @Expose
    private Integer fieldFlags;
    @SerializedName("IncludeAggregates")
    @Expose
    private Boolean includeAggregates;

    private HotelsByChildDestinationQuery(Builder builder) {
        setDatesAndDurations(builder.datesAndDurations);
        setFlexibility(builder.flexibility);
        setDuration(builder.duration);
        setAdults(builder.adults);
        setDomainId(builder.domainId);
        setCultureCode(builder.cultureCode);
        setCurrencyCode(builder.currencyCode);
        setOriginAirports(builder.originAirports);
        setFieldFlags(builder.fieldFlags);
        setIncludeAggregates(builder.includeAggregates);
    }


    public List<DatesAndDuration> getDatesAndDurations() {
        return datesAndDurations;
    }

    public void setDatesAndDurations(List<DatesAndDuration> datesAndDurations) {
        this.datesAndDurations = datesAndDurations;
    }

    public Integer getFlexibility() {
        return flexibility;
    }

    public void setFlexibility(Integer flexibility) {
        this.flexibility = flexibility;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getCultureCode() {
        return cultureCode;
    }

    public void setCultureCode(String cultureCode) {
        this.cultureCode = cultureCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<String> getOriginAirports() {
        return originAirports;
    }

    public void setOriginAirports(List<String> originAirports) {
        this.originAirports = originAirports;
    }

    public Integer getFieldFlags() {
        return fieldFlags;
    }

    public void setFieldFlags(Integer fieldFlags) {
        this.fieldFlags = fieldFlags;
    }

    public Boolean getIncludeAggregates() {
        return includeAggregates;
    }

    public void setIncludeAggregates(Boolean includeAggregates) {
        this.includeAggregates = includeAggregates;
    }

    public static final class Builder {
        private List<DatesAndDuration> datesAndDurations;
        private Integer flexibility;
        private Integer duration;
        private Integer adults;
        private Integer domainId;
        private String cultureCode;
        private String currencyCode;
        private List<String> originAirports;
        private Integer fieldFlags;
        private Boolean includeAggregates;

        public Builder() {
        }

        public Builder datesAndDurations(List<DatesAndDuration> val) {
            datesAndDurations = val;
            return this;
        }

        public Builder flexibility(Integer val) {
            flexibility = val;
            return this;
        }

        public Builder duration(Integer val) {
            duration = val;
            return this;
        }

        public Builder adults(Integer val) {
            adults = val;
            return this;
        }

        public Builder domainId(Integer val) {
            domainId = val;
            return this;
        }

        public Builder cultureCode(String val) {
            cultureCode = val;
            return this;
        }

        public Builder currencyCode(String val) {
            currencyCode = val;
            return this;
        }

        public Builder originAirports(List<String> val) {
            originAirports = val;
            return this;
        }

        public Builder fieldFlags(Integer val) {
            fieldFlags = val;
            return this;
        }

        public Builder includeAggregates(Boolean val) {
            includeAggregates = val;
            return this;
        }

        public HotelsByChildDestinationQuery build() {
            return new HotelsByChildDestinationQuery(this);
        }
    }
}

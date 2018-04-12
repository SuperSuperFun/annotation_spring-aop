package com.wangli.util.entity;

import java.math.BigDecimal;

public class LongitudeAndLatitude {
    private Double lng;
    private Double lat;

    public LongitudeAndLatitude() {

    }

    public LongitudeAndLatitude(Double lng, Double lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "LongitudeAndLatitude{" +
                "lng=" + lng +
                ", lat=" + lat +
                '}';
    }
}

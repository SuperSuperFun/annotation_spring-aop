package com.wangli.util.entity;

import java.math.BigDecimal;

public class LongitudeAndLatitude {
    private BigDecimal lng;
    private BigDecimal lat;

    public LongitudeAndLatitude() {

    }

    public LongitudeAndLatitude(BigDecimal lng, BigDecimal lat) {
        this.lng = lng;
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
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

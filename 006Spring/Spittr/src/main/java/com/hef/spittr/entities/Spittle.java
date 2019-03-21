package com.hef.spittr.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * 用户发布的简短状态更新
 */
public class Spittle {
    private Long id;
    private String message;
    private Date time;
    // 维度
    private Double latitude;
    // 经度
    private Double longitude;

    public Spittle() {
    }

    public Spittle(Long id, String message, Date time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(Long id, String message, Date time) {
        this(id,message,time,null,null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id= null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(String message, Date time) {
        this(message,time, null, null);
    }


    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    /**
     * 这里使用了 Apache Common Lang3 包
     * @param that
     * @return
     */
    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}

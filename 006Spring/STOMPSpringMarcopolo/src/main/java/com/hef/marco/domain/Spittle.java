package com.hef.marco.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户发布的简短状态更新
 */
@Entity
@Table(name = "spittle")
@Proxy(lazy = false)
public class Spittle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "spitter")
    private Long spitter;
    @Column(name = "message")
    private String message;
    @Column(name = "postedtime")
    private Date time;
    // 维度
    @Column(name = "latitude")
    private Double latitude;
    // 经度
    @Column(name = "longitude")
    private Double longitude;

    public Spittle() {
    }

    public Spittle(long spitter, String message, Date time, Double latitude, Double longitude) {
        this.spitter = spitter;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getSpitter() {
        return spitter;
    }

    public void setSpitter(Long spitter) {
        this.spitter = spitter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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

    @Override
    public String toString() {
        return "Spittle{" +
                "id=" + id +
                ", spitter=" + spitter +
                ", message='" + message + '\'' +
                ", time=" + time +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

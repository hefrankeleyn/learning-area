package com.hef.design10.dynamicproxy;

/**
 * @Date 2019-06-12
 * @Author lifei
 */
public class PersonBeanImpl implements PersonBean{

    private String name;
    private String gender;
    private String interests;
    int rating;
    int ratingCount  = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String getInterests() {
        return interests;
    }

    @Override
    public void setInterests(String interests) {
        this.interests = interests;
    }

    @Override
    public int getHotOrNotRating() {
        if(ratingCount == 0) {
            return 0;
        }else {
            return (rating/ratingCount);
        }
    }

    @Override
    public void setHotOrNotRating(int rating) {
        this.rating += rating;
        ratingCount ++;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }
}

package com.english.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {

    private String description;
    private boolean nativeSpeaker;
    private boolean groupLessons;
    private BigDecimal hourlyRate;
    private List<String> tags = new ArrayList<>();

    public Teacher() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNativeSpeaker() {
        return nativeSpeaker;
    }

    public void setNativeSpeaker(boolean nativeSpeaker) {
        this.nativeSpeaker = nativeSpeaker;
    }

    public boolean isGroupLessons() {
        return groupLessons;
    }

    public void setGroupLessons(boolean groupLessons) {
        this.groupLessons = groupLessons;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class earlier_info {
    @SerializedName("Date")
    private String Date;
    @SerializedName("Temperature")
    private Temperature_type Temperature;
    @SerializedName("Day")
    private Day_info Day;
    @SerializedName("Night")
    private Night_info Night;

    public String getDate() {
        return Date;
    }

    public Temperature_type getTemperature() {
        return Temperature;
    }
    public Day_info getDay() {
        return Day;
    }

    public Night_info getNight() {
        return Night;
    }
}

class Day_info{
    @SerializedName("IconPhrase")
    private String IconPhrase;

    public String getIconPhrase() {
        return IconPhrase;
    }
}

class Night_info{
    @SerializedName("IconPhrase")
    private String IconPhrase;

    public String getIconPhrase() {
        return IconPhrase;
    }
}
package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Forecasts {
    @SerializedName("DailyForecasts")
    private ArrayList<earlier_info> dailyForecasts;

    public ArrayList<earlier_info> getDailyForecasts() {
        return dailyForecasts;
    }
}


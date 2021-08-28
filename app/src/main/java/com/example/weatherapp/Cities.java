package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Cities {
    private String CityName;
    @SerializedName("WeatherText")
    private String CurrentCondition;
    @SerializedName("Temperature")
    private Temperature Temperature;

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getCurrentCondition() {
        return CurrentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        CurrentCondition = currentCondition;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temperature temperature) {
        Temperature = temperature;
    }
}

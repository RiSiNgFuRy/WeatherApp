package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("Metric")
    private TempUnits metric;
    @SerializedName("Imperial")
    private TempUnits imperial;

    public TempUnits getMetric() {
        return metric;
    }

    public TempUnits getImperial() {
        return imperial;
    }
}

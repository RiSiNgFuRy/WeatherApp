package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Temperature_type {
    @SerializedName("Minimum")
    private Temperature_units min;
    @SerializedName("Maximum")
    private Temperature_units max;

    public Temperature_units getMin() {
        return min;
    }

    public Temperature_units getMax() {
        return max;
    }
}

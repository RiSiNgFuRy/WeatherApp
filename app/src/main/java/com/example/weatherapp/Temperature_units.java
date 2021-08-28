package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Temperature_units {
    @SerializedName("Value")
    private String value;
    @SerializedName("Unit")
    private String unit;

    public String getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }
}

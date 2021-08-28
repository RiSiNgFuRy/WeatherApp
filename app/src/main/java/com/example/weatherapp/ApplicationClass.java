package com.example.weatherapp;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Cities> city;

    @Override
    public void onCreate() {
        super.onCreate();
        city = new ArrayList<Cities>();
        //city.add(new Cities())
    }
}

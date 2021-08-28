package com.example.weatherapp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholder {
    @GET("206679?apikey=HKcp9NneDYmCHv6yBTAFZbzX4TflmiiT")
    Call<ArrayList<Cities>> getPost();

    @GET("206679?apikey=HKcp9NneDYmCHv6yBTAFZbzX4TflmiiT")
    Call<Forecasts> getData();
}

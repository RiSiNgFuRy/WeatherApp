package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Previous_Casts extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous__casts);


        recyclerView = findViewById(R.id.prev_list_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com/forecasts/v1/daily/5day/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholder placeholder = retrofit.create(JsonPlaceholder.class);
        Call<Forecasts> call = placeholder.getData();
        call.enqueue(new Callback<Forecasts>() {
            @Override
            public void onResponse(Call<Forecasts> call, Response<Forecasts> response) {
                ArrayList<earlier_info> info = new ArrayList(response.body().getDailyForecasts());
                Earlier_Forecasts_Adapter earlier_forecasts_adapter = new Earlier_Forecasts_Adapter(getApplicationContext(), info);
                recyclerView.setAdapter(earlier_forecasts_adapter);
            }

            @Override
            public void onFailure(Call<Forecasts> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
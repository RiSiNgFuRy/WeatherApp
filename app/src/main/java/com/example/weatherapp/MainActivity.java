package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements Cities_Adapter.ItemSelected {
    RecyclerView recyclerView;
   // Button fetch_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  fetch_btn = findViewById(R.id.fetch_btn);

        recyclerView = findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dataservice.accuweather.com/currentconditions/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholder placeholder = retrofit.create(JsonPlaceholder.class);
        Call<ArrayList<Cities>> call = placeholder.getPost();
        call.enqueue(new Callback<ArrayList<Cities>>() {
            @Override
            public void onResponse(Call<ArrayList<Cities>> call, Response<ArrayList<Cities>> response) {
                ArrayList<Cities> city = new ArrayList<Cities>();
                city = response.body();
                Cities_Adapter cities_adapter = new Cities_Adapter(MainActivity.this, city);
                recyclerView.setAdapter(cities_adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Cities>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }


    @Override
    public void onItemClicked(int index) {
        Intent intent = new Intent(this, Previous_Casts.class);
        startActivity(intent);
    }
}
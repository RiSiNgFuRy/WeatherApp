package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cities_Adapter extends RecyclerView.Adapter<Cities_Adapter.ViewHolder> {
    private ArrayList<Cities> city;
    ItemSelected activity;

    interface ItemSelected
    {
        void onItemClicked(int index);
    }
    public Cities_Adapter (Context context, ArrayList<Cities> list){
        city = list;
        activity =(ItemSelected) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView current_cond, city_name, celcius_value, fahren_value;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            current_cond = itemView.findViewById(R.id.current_cond);
           // city_name = itemView.findViewById(R.id.city_name);
            celcius_value = itemView.findViewById(R.id.celcius_value);
            fahren_value = itemView.findViewById(R.id.fahren_value);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(city.indexOf((Cities) v.getTag()));
                }
            });
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemView.setTag(city.get(position));
        //holder.city_name.setText(city.get(position).getCityName());
        holder.current_cond.setText(city.get(position).getCurrentCondition());
        holder.celcius_value.setText(city.get(position).getTemperature().getMetric().getValue()+"\u00B0"+city.get(position).getTemperature().getMetric().getUnit());
        holder.fahren_value.setText(city.get(position).getTemperature().getImperial().getValue()+"\u00B0"+city.get(position).getTemperature().getImperial().getUnit());
    }

    @Override
    public int getItemCount() {
        return city.size();
    }


}

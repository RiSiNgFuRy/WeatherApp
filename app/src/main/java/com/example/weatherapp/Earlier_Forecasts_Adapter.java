package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Earlier_Forecasts_Adapter extends RecyclerView.Adapter<Earlier_Forecasts_Adapter.viewHolder>{
    private ArrayList<earlier_info> infos;
    Context c;

    public Earlier_Forecasts_Adapter (Context context, ArrayList<earlier_info> list){
        infos = list;
        c = context;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView days_ago, day_cond, night_cond, min_value, max_value;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            day_cond = itemView.findViewById(R.id.day_cond);
            night_cond = itemView.findViewById(R.id.night_cond);
            days_ago = itemView.findViewById(R.id.days_ago);
            min_value = itemView.findViewById(R.id.min_value);
            max_value = itemView.findViewById(R.id.max_value);
        }
    }
    @NonNull
    @Override
    public Earlier_Forecasts_Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.prev_casts_list_layout, parent, false);
        return new Earlier_Forecasts_Adapter.viewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Earlier_Forecasts_Adapter.viewHolder holder, int position) {
        holder.itemView.setTag(infos.get(position));
        holder.days_ago.setText(daysAgo(infos.get(position).getDate()));
        holder.day_cond.setText(infos.get(position).getDay().getIconPhrase());
        holder.night_cond.setText(infos.get(position).getNight().getIconPhrase());
        holder.min_value.setText(infos.get(position).getTemperature().getMin().getValue()+"\u00B0"+infos.get(position).getTemperature().getMin().getUnit());
        holder.max_value.setText(infos.get(position).getTemperature().getMax().getValue()+"\u00B0"+infos.get(position).getTemperature().getMax().getUnit());
    }

    @Override
    public int getItemCount() {
        return infos.size();
    }

    private String daysAgo(String str){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+05:30'");
        String data = str;
        try {
            Date date = format.parse(str);
            String dateStr = (String) DateUtils.getRelativeTimeSpanString(date.getTime(), Calendar.getInstance().getTimeInMillis(), DateUtils.MINUTE_IN_MILLIS);
            return  dateStr;
        } catch (ParseException e) {
            return "12";
        }
    }

}

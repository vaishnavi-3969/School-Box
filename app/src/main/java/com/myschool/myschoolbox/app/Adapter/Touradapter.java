package com.myschool.myschoolbox.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myschool.myschoolbox.app.Model.Tourmodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;


public class Touradapter extends RecyclerView.Adapter<Touradapter.ViewHolder> {
    private Context context;
    private List<Tourmodel> tourmodelList;

    public Touradapter(Context context, List<Tourmodel> tourmodelList) {
        this.context = context;
        this.tourmodelList = tourmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tour,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(tourmodelList.get(position).getUrl()).into(holder.tourimg);
        holder.place.setText(tourmodelList.get(position).getPlace());
        holder.placedate.setText(tourmodelList.get(position).getPlacedate());
    }

    @Override
    public int getItemCount() {
        return tourmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView place,placedate;
               ImageView tourimg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            place=itemView.findViewById(R.id.palace);
            placedate=itemView.findViewById(R.id.tourdate);
            tourimg=itemView.findViewById(R.id.tourimg);

        }
    }
}

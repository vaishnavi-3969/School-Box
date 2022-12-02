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
import com.myschool.myschoolbox.app.Model.Activitymodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;
public class Activityadapter extends RecyclerView.Adapter<Activityadapter.ViewHolder> {
    private Context context;
    private List<Activitymodel> activitymodelList;

    public Activityadapter(Context context, List<Activitymodel> activitymodelList) {
        this.context = context;
        this.activitymodelList = activitymodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(activitymodelList.get(position).getUrl()).into(holder.image);
        holder.date.setText(activitymodelList.get(position).getDate());
        holder.heading.setText(activitymodelList.get(position).getActivity());

    }

    @Override
    public int getItemCount() {
        return activitymodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView date,heading;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.date);
            heading=itemView.findViewById(R.id.wrireactivity);
            image=itemView.findViewById(R.id.imageactivity);
        }
    }
}

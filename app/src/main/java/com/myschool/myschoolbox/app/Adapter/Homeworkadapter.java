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
import com.myschool.myschoolbox.app.Model.Usermodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;

public class Homeworkadapter extends RecyclerView.Adapter<Homeworkadapter.ViewHolder> {
    private Context context;
    private List<Usermodel.Homeworkmodel> homeworkmodelList;

    public Homeworkadapter(Context context, List<Usermodel.Homeworkmodel> homeworkmodelList) {
        this.context = context;
        this.homeworkmodelList = homeworkmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.homework,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(homeworkmodelList.get(position).getUrl()).into(holder.imageView);
        holder.subject.setText(homeworkmodelList.get(position).getSubject());
        holder.date.setText(homeworkmodelList.get(position).getDate());
        holder.heading.setText(homeworkmodelList.get(position).getHeading());
        holder.note.setText(homeworkmodelList.get(position).getNote());

    }

    @Override
    public int getItemCount() {
        return homeworkmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,date,heading,note;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.homesubject);
            date=itemView.findViewById(R.id.homedate);
            heading=itemView.findViewById(R.id.homewrite);
            note=itemView.findViewById(R.id.note);
            imageView=itemView.findViewById(R.id.homeworkimage);
        }
    }
}

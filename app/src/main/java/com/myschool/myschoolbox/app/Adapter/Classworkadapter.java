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
import com.myschool.myschoolbox.app.Model.Classworkmodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;

public class Classworkadapter extends RecyclerView.Adapter<Classworkadapter.ViewHolder>{
    private Context context;
    private List<Classworkmodel> classworkmodelList;

    public Classworkadapter(Context context, List<Classworkmodel> classworkmodelList) {
        this.context = context;
        this.classworkmodelList = classworkmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.classwork,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(classworkmodelList.get(position).getUrl()).into(holder.imageView);
        holder.subject.setText(classworkmodelList.get(position).getSubject());
        holder.date.setText(classworkmodelList.get(position).getDate());
        holder.heading.setText(classworkmodelList.get(position).getHeading());
        holder.note.setText(classworkmodelList.get(position).getNote());

    }

    @Override
    public int getItemCount() {
        return classworkmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,date,heading,note;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.classworksubject);
            date=itemView.findViewById(R.id.classdate);
            heading=itemView.findViewById(R.id.classwrite);
            note=itemView.findViewById(R.id.classnote);
            imageView=itemView.findViewById(R.id.classworkimage);
        }
    }
}

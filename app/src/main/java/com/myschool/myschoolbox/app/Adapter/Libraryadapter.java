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
import com.myschool.myschoolbox.app.Model.Librarymodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;


public class Libraryadapter extends RecyclerView.Adapter<Libraryadapter.ViewHolder> {
    private Context context;
    private List<Librarymodel> librarymodelList;

    public Libraryadapter(Context context, List<Librarymodel> librarymodelList) {
        this.context = context;
        this.librarymodelList = librarymodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.timetabledata,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(librarymodelList.get(position).getUrl()).into(holder.routing);
        holder.month.setText(librarymodelList.get(position).getMont());
    }

    @Override
    public int getItemCount() {
        return librarymodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView month;
        ImageView routing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            month=itemView.findViewById(R.id.month);
            routing=itemView.findViewById(R.id.routiimg);
        }
    }
}

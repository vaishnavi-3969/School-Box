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
import com.myschool.myschoolbox.app.Model.Noticemodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;


public class Noticeadapter extends RecyclerView.Adapter<Noticeadapter.ViewHolder>{
    private Context context;
    private List<Noticemodel> noticemodelList;

    public Noticeadapter(Context context, List<Noticemodel> noticemodelList) {
        this.context = context;
        this.noticemodelList = noticemodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.noticeboard,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(noticemodelList.get(position).getUrl()).into(holder.url);
        holder.month.setText(noticemodelList.get(position).getNoticemonth());
    }

    @Override
    public int getItemCount() {
        return noticemodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView month;
        ImageView url;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            month=itemView.findViewById(R.id.noticemonth);
            url=itemView.findViewById(R.id.noticeimg);
        }
    }
}

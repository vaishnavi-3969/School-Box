package com.myschool.myschoolbox.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myschool.myschoolbox.app.Model.Transportmodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;

public class Onlineclassadapter extends RecyclerView.Adapter<Onlineclassadapter.ViewHolder> {
    private Context context;
    private List<Transportmodel.Onlineclassmodel> onlineclassmodelList;

    public Onlineclassadapter(Context context, List<Transportmodel.Onlineclassmodel> onlineclassmodelList) {
        this.context = context;
        this.onlineclassmodelList = onlineclassmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.onlineclass,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(onlineclassmodelList.get(position).getName());
        holder.link.setText(onlineclassmodelList.get(position).getLink());
    }

    @Override
    public int getItemCount() {
        return onlineclassmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.platformname);
            link=itemView.findViewById(R.id.link);

        }
    }
}

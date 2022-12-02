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
import com.myschool.myschoolbox.app.Model.TeacherprofileModel;
import com.myschool.myschoolbox.app.R;

import java.util.List;


public class Teacherprofileadapter extends RecyclerView.Adapter<Teacherprofileadapter.ViewHolder> {
    private Context context;
    private List<TeacherprofileModel> teacherprofileModelList;

    public Teacherprofileadapter(Context context, List<TeacherprofileModel> teacherprofileModelList) {
        this.context = context;
        this.teacherprofileModelList = teacherprofileModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.teacherprofile,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(teacherprofileModelList.get(position).getUrl()).into(holder.profile);
        holder.teachername.setText(teacherprofileModelList.get(position).getTeachername());
        holder.ocupation.setText(teacherprofileModelList.get(position).getOcupation());

    }

    @Override
    public int getItemCount() {
        return teacherprofileModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView teachername,ocupation;
        ImageView profile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teachername=itemView.findViewById(R.id.techername);
            ocupation=itemView.findViewById(R.id.accupation);
            profile=itemView.findViewById(R.id.profileimage);
        }
    }
}

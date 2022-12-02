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
import com.myschool.myschoolbox.app.Model.Assignmentmodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;


public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder>{
    private Context context;
    private List<Assignmentmodel> assignmentmodelList;

    public AssignmentAdapter(Context context, List<Assignmentmodel> assignmentmodelList) {
        this.context = context;
        this.assignmentmodelList = assignmentmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(assignmentmodelList.get(position).getUrl()).into(holder.imageView);
        holder.subject.setText(assignmentmodelList.get(position).getSubject());
        holder.date.setText(assignmentmodelList.get(position).getDate());
        holder.heading.setText(assignmentmodelList.get(position).getHeading());
        holder.note.setText(assignmentmodelList.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return assignmentmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView subject,date,heading,note;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subject=itemView.findViewById(R.id.assignmentsubject);
            date=itemView.findViewById(R.id.assignmentdate);
            heading=itemView.findViewById(R.id.assignmentwrite);
            note=itemView.findViewById(R.id.assignmentnote);
            imageView=itemView.findViewById(R.id.assignmentimage);
        }
    }
}

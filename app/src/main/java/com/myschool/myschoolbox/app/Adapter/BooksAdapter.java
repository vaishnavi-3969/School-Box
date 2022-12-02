package com.myschool.myschoolbox.app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.myschool.myschoolbox.app.Model.Booksmodel;
import com.myschool.myschoolbox.app.R;

import java.util.List;


public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>{
    private Context context;
    private List<Booksmodel> booksmodelList;

    public BooksAdapter(Context context, List<Booksmodel> booksmodelList) {
        this.context = context;
        this.booksmodelList = booksmodelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.books,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(booksmodelList.get(position).getUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return booksmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.bookname);
        }
    }
}

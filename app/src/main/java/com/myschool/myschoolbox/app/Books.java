package com.myschool.myschoolbox.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myschool.myschoolbox.app.Adapter.BooksAdapter;
import com.myschool.myschoolbox.app.Model.Booksmodel;

import java.util.ArrayList;
import java.util.List;

public class Books extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Booksmodel> booksmodelList;
    BooksAdapter booksadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.bookrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        booksmodelList = new ArrayList<>();
        booksadapter= new BooksAdapter(getApplicationContext(),booksmodelList);
        recyclerView.setAdapter(booksadapter);
        firestore.collection("Books")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Booksmodel booksmodel = document.toObject(Booksmodel.class);
                                booksmodelList.add(booksmodel);
                                booksadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
    }
}
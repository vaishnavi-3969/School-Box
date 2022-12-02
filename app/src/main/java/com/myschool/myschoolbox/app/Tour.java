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
import com.myschool.myschoolbox.app.Adapter.Touradapter;
import com.myschool.myschoolbox.app.Model.Tourmodel;

import java.util.ArrayList;
import java.util.List;



public class Tour extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Tourmodel> tourmodelList;
    Touradapter touradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.tourrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        tourmodelList = new ArrayList<>();
        touradapter = new Touradapter(getApplicationContext(),tourmodelList);
        recyclerView.setAdapter(touradapter);
        firestore.collection("Tour")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Tourmodel tourmodel = document.toObject(Tourmodel.class);
                                tourmodelList.add(tourmodel);
                                touradapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

    }
}
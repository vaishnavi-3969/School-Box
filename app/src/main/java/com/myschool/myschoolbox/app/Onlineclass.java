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
import com.myschool.myschoolbox.app.Adapter.Onlineclassadapter;
import com.myschool.myschoolbox.app.Model.Transportmodel;

import java.util.ArrayList;
import java.util.List;


public class Onlineclass extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Transportmodel.Onlineclassmodel> onlineclassmodelList;
    Onlineclassadapter onlineclassadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlineclass);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.onlineclassrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        onlineclassmodelList = new ArrayList<>();
        onlineclassadapter= new Onlineclassadapter(getApplicationContext(),onlineclassmodelList);
        recyclerView.setAdapter(onlineclassadapter);
        firestore.collection("Onlineclass")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Transportmodel.Onlineclassmodel onlineclassmodel = document.toObject(Transportmodel.Onlineclassmodel.class);
                                onlineclassmodelList.add(onlineclassmodel);
                                onlineclassadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
    }
}
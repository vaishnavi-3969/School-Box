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
import com.myschool.myschoolbox.app.Adapter.Activityadapter;
import com.myschool.myschoolbox.app.Model.Activitymodel;

import java.util.ArrayList;
import java.util.List;
public class Activity extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Activitymodel> activitymodelList;
    Activityadapter activityadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.activityrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        activitymodelList = new ArrayList<>();
        activityadapter= new Activityadapter(getApplicationContext(),activitymodelList);
        recyclerView.setAdapter(activityadapter);
        firestore.collection("Activity")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Activitymodel activitymodel = document.toObject(Activitymodel.class);
                                activitymodelList.add(activitymodel);
                                activityadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
    }
}
package com.myschool.myschoolbox.app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myschool.myschoolbox.app.Adapter.AssignmentAdapter;
import com.myschool.myschoolbox.app.Model.Assignmentmodel;

import java.util.ArrayList;
import java.util.List;


public class Assignment extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Assignmentmodel> assignmentmodelList;
    AssignmentAdapter assignmentadapter;
    private SharedPreferences getShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.assignmentrec);


        getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
        String className = getShared.getString("classname","");
        Toast.makeText(this, className, Toast.LENGTH_SHORT).show();


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        assignmentmodelList = new ArrayList<>();
        assignmentadapter= new AssignmentAdapter(getApplicationContext(),assignmentmodelList);
        recyclerView.setAdapter(assignmentadapter);
        firestore.collection("Assignment")
                .whereEqualTo("classname", className)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Assignmentmodel assignmentmodel = document.toObject(Assignmentmodel.class);
                                assignmentmodelList.add(assignmentmodel);
                                assignmentadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

    }
}
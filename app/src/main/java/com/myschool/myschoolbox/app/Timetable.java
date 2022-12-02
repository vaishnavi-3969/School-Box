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
import com.myschool.myschoolbox.app.Adapter.Libraryadapter;
import com.myschool.myschoolbox.app.Model.Librarymodel;

import java.util.ArrayList;
import java.util.List;


public class Timetable extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Librarymodel>librarymodelList;
    Libraryadapter libraryadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
      firestore=FirebaseFirestore.getInstance();
      recyclerView=findViewById(R.id.librec);
      recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
      librarymodelList = new ArrayList<>();
      libraryadapter = new Libraryadapter(getApplicationContext(),librarymodelList);
      recyclerView.setAdapter(libraryadapter);
        firestore.collection("Timetable")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                               Librarymodel librarymodel = document.toObject(Librarymodel.class);
                               librarymodelList.add(librarymodel);
                               libraryadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });

    }
}
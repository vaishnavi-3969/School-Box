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
import com.myschool.myschoolbox.app.Adapter.Noticeadapter;
import com.myschool.myschoolbox.app.Model.Noticemodel;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoard extends AppCompatActivity {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<Noticemodel> noticemodelList;
    Noticeadapter noticeadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_board);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=findViewById(R.id.noticerec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        noticemodelList = new ArrayList<>();
        noticeadapter= new Noticeadapter(getApplicationContext(),noticemodelList);
        recyclerView.setAdapter(noticeadapter);
        firestore.collection("NoticeBoard")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Noticemodel noticemodel = document.toObject(Noticemodel.class);
                                noticemodelList.add(noticemodel);
                                noticeadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
    }
}
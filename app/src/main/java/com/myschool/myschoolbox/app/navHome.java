package com.myschool.myschoolbox.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.myschool.myschoolbox.app.Adapter.Teacherprofileadapter;
import com.myschool.myschoolbox.app.Model.TeacherprofileModel;

import java.util.ArrayList;
import java.util.List;


public class navHome extends Fragment {
    FirebaseFirestore firestore;
    RecyclerView recyclerView;
    List<TeacherprofileModel> teacherprofileModelList;
    Teacherprofileadapter teacherprofileadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_nav_home, container, false);
        firestore=FirebaseFirestore.getInstance();
        recyclerView=rootView.findViewById(R.id.teacherprofilerec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        teacherprofileModelList = new ArrayList<>();
        teacherprofileadapter = new Teacherprofileadapter(getContext(),teacherprofileModelList);
        recyclerView.setAdapter(teacherprofileadapter);
        firestore.collection("TeacherProfile")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                TeacherprofileModel teacherprofileModel = document.toObject(TeacherprofileModel.class);
                                teacherprofileModelList.add(teacherprofileModel);
                                teacherprofileadapter.notifyDataSetChanged();
                            }
                        } else {

                        }
                    }
                });
        return rootView;
    }
}
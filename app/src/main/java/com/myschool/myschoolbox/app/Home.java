package com.myschool.myschoolbox.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import org.checkerframework.checker.nullness.qual.NonNull;


public class Home extends  Fragment {
    CardView classwork,attendance,timetable,holiday,assignment, noticeboard,books,activity,result,transport,navigation,onlineclass,tour;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        classwork=root.findViewById(R.id.classwork);
        attendance=root.findViewById(R.id.attendance);
        timetable=root.findViewById(R.id.timetable);
        holiday=root.findViewById(R.id.holiday);
        assignment=root.findViewById(R.id.assignment);
        noticeboard =root.findViewById(R.id.noticboard);
        books=root.findViewById(R.id.books);
        activity=root.findViewById(R.id.activity);
        result=root.findViewById(R.id.result);
        transport=root.findViewById(R.id.transport);
        navigation=root.findViewById(R.id.navigation);
        onlineclass=root.findViewById(R.id.onlineclass);
        tour=root.findViewById(R.id.tour);
        tour.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Tour.class);
            startActivity(intent);
        });
        onlineclass.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Onlineclass.class);
            startActivity(intent);
        });
        navigation.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Navigation.class);
            startActivity(intent);
        });
        transport.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Transport.class);
            startActivity(intent);
        });
        result.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Result.class);
            startActivity(intent);
        });
        activity.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Activity.class);
            startActivity(intent);
        });
        books.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Books.class);
            startActivity(intent);
        });
        noticeboard.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NoticeBoard.class);
            startActivity(intent);
        });
        holiday.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Holiday.class);
            startActivity(intent);
        });
        timetable.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Timetable.class);
            startActivity(intent);
        });
        attendance.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Attendance.class);
            startActivity(intent);
        });
        classwork.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Classwork.class);
            startActivity(intent);
        });

        return root;
    }



}
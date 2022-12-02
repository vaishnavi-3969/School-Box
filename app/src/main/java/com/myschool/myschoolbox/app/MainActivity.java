package com.myschool.myschoolbox.app;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton student,teacher,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student = findViewById(R.id.studentBTN);
        teacher = findViewById(R.id.teacherBTN);
        admin = findViewById(R.id.adminBTN);
        student.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StudentSignUp.class);
            startActivity(intent);
        });

        teacher.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this,Login.class);
            startActivity(intent2);
        });
        admin.setOnClickListener(v -> {
            Intent intent3 = new Intent(MainActivity.this,ThirdActivity.class);
            startActivity(intent3);
        });
    }
}
package com.myschool.myschoolbox.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myschool.myschoolbox.app.databinding.ActivityStudentLoginBinding;

import java.util.Objects;

public class StudentLogin extends AppCompatActivity {
    ActivityStudentLoginBinding binding;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    ImageButton loginbutton;
    private SharedPreferences getShared;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        loginbutton = findViewById(R.id.loginBTN);
        Objects.requireNonNull(binding.loginBTN).setOnClickListener(view -> {
//            String email = binding.Gmail.getText().toString().trim();
//            String password = binding.Password.getText().toString();
            String email = findViewById(R.id.Gmail).toString();
            String password = findViewById(R.id.Password).toString();
            progressDialog.setTitle("Logged In Successfully... \nSwitching to Dashboard... \n Welcome Back :)");
            progressDialog.show();
            startActivity(new Intent(StudentLogin.this,SecondActivity.class));
//            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
//                    .addOnSuccessListener(authResult -> {
//                        progressDialog.cancel();
//                        Toast.makeText(StudentLogin.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(StudentLogin.this,SecondActivity.class));
//                    }).addOnFailureListener(e -> {
//                        progressDialog.cancel();
//                        Toast.makeText(StudentLogin.this, "Error" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    });
            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                        firebaseDatabase.getReference().child("Admin").child(firebaseAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
                                editor = getShared.edit();
                                if (getShared.contains("classname")){
                                    editor.clear();
                                }
                            }

                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        Toast.makeText(StudentLogin.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(StudentLogin.this,SecondActivity.class));
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(StudentLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            });
        });

        binding.forgotpswd.setOnClickListener(view -> {
            String email = binding.Gmail.getText().toString();
            progressDialog.setTitle("Sending Mail...");
            progressDialog.show();
            firebaseAuth.sendPasswordResetEmail(email)
                    .addOnSuccessListener(unused -> {
                        progressDialog.cancel();
                        Toast.makeText(StudentLogin.this, "Email Sent :)", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(e -> {
                        progressDialog.cancel();
                        Toast.makeText(StudentLogin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
        });

        binding.goToSignUpBtn.setOnClickListener(view -> {
            startActivity(new Intent(StudentLogin.this, StudentSignUp.class));
        });
//        Objects.requireNonNull(binding.goToSignUpBtn).setOnClickListener(view -> startActivity(new Intent(StudentLogin.this,MainActivity.class)));
    }
}


//========================================================

//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.ImageButton;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//public class StudentLogin extends AppCompatActivity {
//
//    EditText email,password;
//    ImageButton login, goToSignUp, ForgotPswd;
//    FirebaseDatabase firebaseDatabase;
//    FirebaseAuth auth;
//    private SharedPreferences getShared;
//    private SharedPreferences.Editor editor;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
//        editor = getShared.edit();
//        if (getShared.contains("classname")){
//            editor.clear();
//        }
//
//        firebaseDatabase=FirebaseDatabase.getInstance();
//        auth=FirebaseAuth.getInstance();
//        email=findViewById(R.id.Gmail);
//        password=findViewById(R.id.Password);
//        login=findViewById(R.id.loginBTN);
////        login.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                startActivity(new Intent(Login.this,Register.class));
////            }
////        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                loginUser();
//            }
//        });
//    }
//
//    private void loginUser() {
//        String useremail =email.getText().toString();
//        String userpass = password.getText().toString();
//        if (TextUtils.isEmpty(useremail))
//        {
//            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
//        }
//        if (TextUtils.isEmpty(userpass))
//        {
//            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
//        }
//        auth.signInWithEmailAndPassword(useremail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    firebaseDatabase.getReference().child("Admin").child(auth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot snapshot) {
//                            if (snapshot.exists()){
//                                Usermodel user = snapshot.getValue(Usermodel.class);
//                                editor.putString("classname",user.getClassname());
//                                editor.apply();
//                            }
//                        }
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError error) {
//
//                        }
//                    });
//                    Toast.makeText(StudentLogin.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(StudentLogin.this,SecondActivity.class));
//                    finish();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(StudentLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

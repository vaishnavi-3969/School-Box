package com.myschool.myschoolbox.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.myschool.myschoolbox.app.databinding.ActivityStudentSignUpBinding;

import java.util.Objects;


public class StudentSignUp extends AppCompatActivity {
    ActivityStudentSignUpBinding binding;
    ProgressDialog progressDialog;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    //    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentSignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_student_sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);

        binding.SignUpBTN.setOnClickListener(view -> {
            String name = binding.Name.getText().toString();
            String number = binding.PhoneNumber.getText().toString();
            String email = binding.Email.getText().toString().trim();
            String password = binding.Password.getText().toString();
            progressDialog.setTitle("Creating Account....");
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(email,password)
                    .addOnSuccessListener(authResult -> {
                        startActivity(new Intent(StudentSignUp.this, SecondActivity.class));
                        progressDialog.cancel();
                        Toast.makeText(StudentSignUp.this, "Account created successfully.... :)", Toast.LENGTH_SHORT).show();
                        firebaseFirestore.collection("User")
                                .document(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))
                                .set(new UserModel(name,email,number,password));
                    }).addOnFailureListener(e -> {
                        Toast.makeText(StudentSignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                    });
        });


        binding.goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentSignUp.this, StudentLogin.class));
            }
        });

    }

    public class UserModel {
        String name, email, number, password;
        public UserModel() {
        }
        public UserModel(String name, String email, String number, String password) {
            this.name = name;
            this.number = number;
            this.password = password;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getNumber() {
            return number;
        }

        public String getPassword() {
            return password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setPassword(String password) {
            this.password = password;
        }



    }
}


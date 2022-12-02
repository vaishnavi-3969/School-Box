package com.myschool.myschoolbox.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
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

public class Login extends AppCompatActivity {

    EditText email,password;
    ImageButton login, goToSignUp, ForgotPswd;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth auth;
    private SharedPreferences getShared;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getShared = getSharedPreferences("classname",AppCompatActivity.MODE_PRIVATE);
        editor = getShared.edit();
        if (getShared.contains("classname")){
            editor.clear();
        }

        firebaseDatabase=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.Gmail);
        password=findViewById(R.id.Password);
        login=findViewById(R.id.loginBTN);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Admission.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String useremail =email.getText().toString();
        String userpass = password.getText().toString();
        if (TextUtils.isEmpty(useremail))
        {
            Toast.makeText(this, "Email is empty", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(userpass))
        {
            Toast.makeText(this, "Password is empty", Toast.LENGTH_SHORT).show();
        }
        auth.signInWithEmailAndPassword(useremail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseDatabase.getReference().child("Admin").child(auth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.exists()){
                                Usermodel user = snapshot.getValue(Usermodel.class);
                                editor.putString("classname",user.getClassname());
                                editor.apply();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    Toast.makeText(Login.this, "Login Sucessfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,Register.class));
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
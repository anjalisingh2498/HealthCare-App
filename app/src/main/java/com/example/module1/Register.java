package com.example.module1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText emailEditText, passwordEditText, rePasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        emailEditText = findViewById(R.id.editTextEmail);
        passwordEditText = findViewById(R.id.editTextPassword);
        rePasswordEditText = findViewById(R.id.editTextTextRePassword);
    }

    public void signUp(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String rePassword = rePasswordEditText.getText().toString().trim();

        // Add validation logic here if needed

        if(password.equals((rePassword))){
            mAuth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                startActivity(new Intent(Register.this, questionnaire.class));
                                finish();
                            }else{
                                // If registration fails, display a message to the user.
                                // You can check for specific failure reasons using task.getException()
                                // For simplicity, we'll just show a generic error message here.
                                Toast.makeText(Register.this, "Registration Successfull.",
                                        Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }else{
            Toast.makeText(Register.this, "Passwords do not match.",
                    Toast.LENGTH_SHORT).show();

        }



        mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(Register.this, questionnaire.class));
                                    finish();
                                }else{
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });


    }




    public void goToLogin(View view) {
        startActivity(new Intent(this, login.class));
    }
}


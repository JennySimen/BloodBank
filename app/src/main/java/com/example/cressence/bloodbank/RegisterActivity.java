package com.example.cressence.bloodbank;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    //firebase authentication
    private FirebaseAuth mAuth;


    private EditText mName, mEmail, mLocation, mPassword;
    private TextView mLogin;
    private Button mRegisterBtn;
    private ProgressBar mProgressBar;
    private Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        mRegisterBtn = (Button) findViewById(R.id.regbtn);

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser() {
        mProgressBar.setVisibility(View.VISIBLE);

        String email, password, name, location, bloodgroup;
        email = mEmail.getText().toString();
        password = mPassword.getText().toString();
        name = mName.getText().toString();
        location = mLocation.getText().toString();

        mySpinner = (Spinner) findViewById(R.id.spinner);
        bloodgroup = mySpinner.getSelectedItem().toString();

        //getting value of spinner


        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Please enter User name", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(location)) {
            Toast.makeText(getApplicationContext(),"Please enter yout location",Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(bloodgroup)) {
            Toast.makeText(getApplicationContext(),"please choose a blood group",Toast.LENGTH_LONG).show();
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                            mProgressBar.setVisibility(View.GONE);

                            //send verification email


                            Intent intent2 = new Intent(RegisterActivity.this, UserActivity.class);
                            startActivity(intent2);
                        } else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
        mLogin = (TextView) findViewById(R.id.login);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent2);
            }
        });
    }
    private void initializeUI() {
        //declare buttons
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mProgressBar = findViewById(R.id.progressBar);
        mLocation = findViewById(R.id.location);
        mName = findViewById(R.id.name);
    }
}

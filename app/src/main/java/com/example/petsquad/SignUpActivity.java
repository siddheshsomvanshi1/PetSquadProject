package com.example.petsquad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailSignUp, usernameSignUp, passwordSignUp;
    private Button signUpButton;
    private DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.siguppassword);

        signUpButton = findViewById(R.id.signupbutton);
        myDB = new DatabaseHelper(this);
        insertUser();
    }

    private void insertUser() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isAllFieldsChecked = false;
                isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(i);
                }

                boolean var = myDB.registerUser(usernameSignUp.getText().toString(), emailSignUp.getText().toString(), passwordSignUp.getText().toString());
                if (var) {
                    Toast.makeText(SignUpActivity.this, "User Registered Successfully !!", Toast.LENGTH_SHORT).show();
                    // startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                } else
                    Toast.makeText(SignUpActivity.this, "Registration Error !!", Toast.LENGTH_SHORT).show();


            }
        });


    }

    private boolean CheckAllFields() {
        String email = emailSignUp.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern) == false ) {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (emailSignUp.length() < 1)
        {
            Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }


        if (usernameSignUp.length() < 5 || usernameSignUp.length() < 1 ) {
            Toast.makeText(getApplicationContext(), "Sorry, you need to enter at least 5 characters in username", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (passwordSignUp.length() < 5 || passwordSignUp.length() < 1 ) {
            Toast.makeText(getApplicationContext(), "Sorry, you need to enter at least 5 characters in password", Toast.LENGTH_SHORT).show();
            return false;
         }
        return true;

    }
}
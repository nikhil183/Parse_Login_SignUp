package com.example.parseloginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            this.finish();
        }

        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);

    }


    public void loginClicked(View view) {
        String user = username.getText().toString();
        String pw = password.getText().toString();

        ParseUser.logInInBackground(user,pw, new LogInCallback() {
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    LoginActivity.this.finish();
                    Toast.makeText(LoginActivity.this,"Login Sucessfull!",Toast.LENGTH_LONG).show();
                    // Hooray! The user is logged in.
                } else {
                    Toast.makeText(LoginActivity.this,"Invalid Credentials. Login Failed!",Toast.LENGTH_SHORT).show();
                    // Signup failed. Look at the ParseException to see what happened.
                }
            }
        });
    }


    public void signupClicked(View view) {
        Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
        this.finish();
    }

}

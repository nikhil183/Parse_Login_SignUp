package com.example.parseloginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.usernameEditText);
        password = findViewById(R.id.passwordEditText);
    }

    public void signupClicked(View view) {

        String user = username.getText().toString();
        String pw = password.getText().toString();

        ParseUser parseUser = new ParseUser();
        parseUser.setUsername(user);
        parseUser.setPassword(pw);

        if(user.equals("") || pw.equals("")) {
            Toast.makeText(SignUpActivity.this,"Fill both fields(Username and Password)",Toast.LENGTH_SHORT).show();
        }
        else {
            parseUser.signUpInBackground(new SignUpCallback() {
                public void done(ParseException e) {
                    if (e == null) {
                        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                        startActivity(intent);
                        SignUpActivity.this.finish();
                        Toast.makeText(SignUpActivity.this, "Signup Successfull!", Toast.LENGTH_LONG).show();
                        // Hooray! Let them use the app now.
                    } else {
                        e.printStackTrace();

                        Log.i("Exception", e.toString());
                        Toast.makeText(SignUpActivity.this, "Signup failed! " + e.getMessage(), Toast.LENGTH_LONG).show();
                        // Sign up didn't succeed. Look at the ParseException
                        // to figure out what went wrong
                    }
                }
            });
        }
    }

    public void loginClicked(View view) {
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}

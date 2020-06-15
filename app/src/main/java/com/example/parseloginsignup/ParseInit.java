package com.example.parseloginsignup;

import android.app.Application;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class ParseInit extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ecxJuQHNuOo7wfRdnYvkKLUeKHnMVwoO3qmE0YKI")
                // if defined
                .clientKey("gzikliQ0ZAEKlhtIVrfEYDOEg4GfBACmz0Rja4WF")
                .server("http://parse-login-signup.herokuapp.com/parse/")
                .build()
        );


        /*
        */
    }
}

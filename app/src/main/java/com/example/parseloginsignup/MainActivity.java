package com.example.parseloginsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.username);
        menuItem.setTitle(ParseUser.getCurrentUser().getUsername().toString());
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout : ParseUser.logOut();
                               Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                               startActivity(intent);
                               MainActivity.this.finish();
                               Toast.makeText(MainActivity.this,"Logout Sucessfull!",Toast.LENGTH_LONG).show();
                               return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

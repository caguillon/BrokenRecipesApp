package com.team.java.brokenrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // When you click the 'create' button, it launches PostActivity.java
    public void onClickBtnCreate() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, PostActivity.class);
        startActivity(i); // brings up the second activity
    }

    // When you click the 'browse' button, it launches Feed.java
    public void onClickBtnBrowse() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, Feed.class);
        startActivity(i); // brings up the second activity
    }
}

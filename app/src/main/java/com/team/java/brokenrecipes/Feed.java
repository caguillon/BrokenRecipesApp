
/*
frank will be working on the array adapter for our app

*/




package com.team.java.brokenrecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
    }

    // When done with Feed, it takes you back to MainActivity.java
    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

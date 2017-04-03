package com.team.java.brokenrecipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    // When done with PostActivity, it takes you back to MainActivity.java
    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

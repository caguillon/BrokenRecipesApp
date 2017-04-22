package com.team.java.brokenrecipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.team.java.brokenrecipes.Models.Post;

import java.util.ArrayList;

public class Feed extends AppCompatActivity {

    //adapter variables
    private ArrayList<Post> posts;
    private PostsArrayAdapter postAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        // Setting up the adapter:
        posts = new ArrayList<Post>(); // Construct the data source
        postAdapter = new PostsArrayAdapter(this, posts); // Create the adapter to convert the array to views
        listView = (ListView) findViewById(R.id.lvItems); // Attach the adapter to a ListView
        listView.setAdapter(postAdapter);
    }

    // When done with Feed, it takes you back to MainActivity.java
    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

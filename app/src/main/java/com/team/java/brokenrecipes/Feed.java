package com.team.java.brokenrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.team.java.brokenrecipes.Models.Post;

import java.util.ArrayList;

public class Feed extends AppCompatActivity {

    //adapter variables
    private ArrayList<Post> posts;
    private PostsArrayAdapter postAdapter;
    private ListView listViewItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        // Setting up the adapter:
        posts = new ArrayList<Post>(); // Construct the data source
        postAdapter = new PostsArrayAdapter(this, posts); // Create the adapter to convert the array to views
        listViewItems = (ListView) findViewById(R.id.lvItems); // Attach the adapter to a ListView
        listViewItems.setAdapter(postAdapter);

        // To view a single post
        setupViewListeners();
    }

    private void setupViewListeners() {
        listViewItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Feed.this, ViewPostActivity.class);
                //pass along the text and position of that item to the second activity using "extras"
                //i.putExtra("username", "foobar");//edit this
                startActivity(i);
            }
        });
    }
}

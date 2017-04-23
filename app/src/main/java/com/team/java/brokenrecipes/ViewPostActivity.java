package com.team.java.brokenrecipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.team.java.brokenrecipes.Models.Post;

public class ViewPostActivity extends AppCompatActivity {

    private Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        TextView tvRTitle = (TextView) findViewById(R.id.tvRTitle);
        TextView tvRTime = (TextView) findViewById(R.id.tvRTime);
        TextView tvRName = (TextView) findViewById(R.id.tvRName);
        TextView tvRRecipe = (TextView) findViewById(R.id.tvRRecipe);

        tvRTitle.setText(post.title);
        tvRTime.setText(post.time);
        tvRName.setText(post.name);
        tvRRecipe.setText(post.recipe);
    }
}

package com.team.java.brokenrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.team.java.brokenrecipes.Models.Post;

import java.util.ArrayList;

public class PostsArrayAdapter extends ArrayAdapter<Post> {

    public PostsArrayAdapter(Context context, ArrayList<Post> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Step 1: Get the post
        Post post = getItem(position);

        // Step 2: Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_post, parent, false);
        }

        // Step 3: Lookup view for data population
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
        TextView tvTime = (TextView) convertView.findViewById(R.id.tvTime);

        // Step 4: Populate the data into the template view using the data object
        tvTitle.setText(post.title);
        tvAuthor.setText(post.name);
        tvTime.setText(post.time);

        // Step 5: Return the completed view to render on screen
        return convertView;
    }
}

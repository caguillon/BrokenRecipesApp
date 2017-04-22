package com.team.java.brokenrecipes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.team.java.brokenrecipes.Models.Post;

import java.util.ArrayList;

/**
 * Created by user on 4/22/2017.
 */

public class PostsArrayAdapter extends ArrayAdapter<Post> {

    public PostsArrayAdapter(Context context, ArrayList<Post> posts) {
        super(context, 0, posts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Step 1: Get the post
        Post post = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        // FIXME: Figure out what item_post must be and where to create it!!
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.item_post, parent, false);
        }

        // Lookup view for data population
        TextView etTitle = (TextView) convertView.findViewById(android.R.id.);
        EditText etName = (EditText) convertView.findViewById(R.id.tvHome);
        EditText etTime;
        EditText etRecipe;

        // Populate the data into the template view using the data object
        tvName.setText(user.name);
        tvHome.setText(user.hometown);

        // Return the completed view to render on screen
        return convertView;
    }
}

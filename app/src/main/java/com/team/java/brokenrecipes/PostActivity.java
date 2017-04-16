package com.team.java.brokenrecipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.team.java.brokenrecipes.Models.Post;

import java.util.HashMap;
import java.util.Map;

public class PostActivity extends AppCompatActivity {

    //to store data
    private DatabaseReference mDatabase;

    //to store images
    private FirebaseStorage mStorage;
    private StorageReference storageRef;

    //user input variables
    private EditText etTitle;
    private EditText etName;
    private EditText etTime;
    private EditText etRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mStorage = FirebaseStorage.getInstance();
        storageRef = mStorage.getReferenceFromUrl("gs://broken-recipes-app.appspot.com/");

        etTitle = (EditText) findViewById(R.id.etTitle);
        etName = (EditText) findViewById(R.id.etName);
        etTime = (EditText) findViewById(R.id.etTime);
        etRecipe = (EditText) findViewById(R.id.etRecipe);
    }

    //this method works using firebase; info is uploaded to database!
    //FIXME: check if this works!!
    private void composeNewPost(String title, String name, String time, String recipe) {
        String key = mDatabase.child("posts").push().getKey();

        Post newPost = new Post(title, name, time, recipe);
        Map<String, Object> postValues = newPost.toMap();

        //check nodes && how data is being placed in firebase!
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }

    // When done with PostActivity, it takes you back to MainActivity.java
    public void onClickBtnSubmitPost(View v) {
        //sets variables in case they are empty
        if (etTitle.getText() == null || etTitle.getText().toString().equals("")) {
            etTitle.setText("");
        }
        if (etName.getText() == null || etName.getText().toString().equals("")) {
            etName.setText("");
        }
        if (etTime.getText() == null || etTime.getText().toString().equals("")) {
            etTime.setText("");
        }
        if (etRecipe.getText() == null || etRecipe.getText().toString().equals("")) {
            etRecipe.setText("");
        }
        final String title = etTitle.getText().toString();
        final String name = etTitle.getText().toString();
        final String time = etTitle.getText().toString();
        final String recipe = etTitle.getText().toString();

        //uploads info to database
        composeNewPost(title, name, time, recipe);

        // closes the activity and returns to first screen
        //this.finish();
        finish();
    }
}

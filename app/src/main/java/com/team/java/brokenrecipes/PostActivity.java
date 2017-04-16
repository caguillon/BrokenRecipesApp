//Daniela will be working on main
package com.team.java.brokenrecipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class PostActivity extends AppCompatActivity {

    //to store data
    private DatabaseReference mDatabase;

    //to store images
    private FirebaseStorage mStorage;
    private StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mStorage = FirebaseStorage.getInstance();
        storageRef = mStorage.getReferenceFromUrl("gs://broken-recipes-app.appspot.com/");
    }

    // When done with PostActivity, it takes you back to MainActivity.java
    public void onClickBtnSubmitPost(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }
}

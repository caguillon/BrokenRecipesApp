//Daniela will be working on main
package com.team.java.brokenrecipes;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class MainActivity extends AppCompatActivity {

    ViewGroup recipesLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//******displays a video file as background(transparent button)
        Button buttonPlayVideo2 = (Button)findViewById(R.id.buttonVideo);
        getWindow().setFormat(PixelFormat.UNKNOWN);


        VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView);

        String uriPath2 = "android.resource://com.team.java.brokenrecipes/" + R.raw.background;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();

        buttonPlayVideo2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                VideoView mVideoView2 = (VideoView) findViewById(R.id.videoView);
                //VideoView mVideoView = new VideoView(this);
                String uriPath = "android.resource://com.team.java.brokenrecipes/" + R.raw.background;
                Uri uri2 = Uri.parse(uriPath);
                mVideoView2.setVideoURI(uri2);
                mVideoView2.requestFocus();
                mVideoView2.start();
            }
        });

//******moves buttons when screen is touched
        recipesLayout = (ViewGroup) findViewById(R.id.recipesLayout);

        recipesLayout.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View v, MotionEvent event){
                        moveButton1();  //moves create button to center
                        moveButton2();  //moves browse button to center
                        return false;
                    }
                }
        );

    }
    //CREATE
    public void moveButton1(){
        View btnCreate = findViewById(R.id.btnCreate);
        /*
        <uses-sdk android:minSdkVersion="14"
        android:targetSdkVersion="20"
        android:maxSdkVersion="21" />
        */
        TransitionManager.beginDelayedTransition(recipesLayout);

        //change position of button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
        btnCreate.setLayoutParams(positionRules);

        //change size of button
        ViewGroup.LayoutParams sizeRules = btnCreate.getLayoutParams();
        sizeRules.width = 180;
        sizeRules.height = 100;
        btnCreate.setLayoutParams(sizeRules);
    }


    //BROWSE
    public void moveButton2(){
        View btnBrowse = findViewById(R.id.btnBrowse);
        /*
        <uses-sdk android:minSdkVersion="14"
        android:targetSdkVersion="20"
        android:maxSdkVersion="21" />
        */
        TransitionManager.beginDelayedTransition(recipesLayout);

        //change position of button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_END, RelativeLayout.TRUE);
        btnBrowse.setLayoutParams(positionRules);

        //change size of button
        ViewGroup.LayoutParams sizeRules = btnBrowse.getLayoutParams();
        sizeRules.width = 180;
        sizeRules.height = 100;
        btnBrowse.setLayoutParams(sizeRules);
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
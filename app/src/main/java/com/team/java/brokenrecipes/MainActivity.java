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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPlayVideo2 = (Button)findViewById(R.id.buttonVideo);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        //displays a video file
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

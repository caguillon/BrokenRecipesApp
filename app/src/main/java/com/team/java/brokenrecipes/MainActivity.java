package com.team.java.brokenrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    ViewGroup recipesLayout;

    private GoogleApiClient googleApiClient;
    private TextView tvGName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGName = (TextView) findViewById(R.id.tvGname);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        //******displays a video file as background(transparent button)
        /*Button buttonPlayVideo2 = (Button)findViewById(R.id.buttonVideo);
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
        );*/
    }

    // When you click the 'create' button, it launches PostActivity.java
    public void onClickBtnCreate(View view) {
        // first parameter is the context, second is the class of the activity to launch
        //check if this now works; if so, update onClickBtnBrowse!
        Intent i = new Intent(this, PostActivity.class);//new Intent(MainActivity.this, PostActivity.class);
        startActivity(i); // brings up the second activity
    }

    // When you click the 'browse' button, it launches Feed.java
    public void onClickBtnBrowse(View view) {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(MainActivity.this, Feed.class);
        startActivity(i); // brings up the second activity
    }

    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        }
        else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            // Their account info
            GoogleSignInAccount account = result.getSignInAccount();
            // How to get the info
            tvGName.setText(account.getDisplayName());
        }
        else{
            goLogInScreen();
        }
    }

    private void goLogInScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void onClickBtnLogout(View view){
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if(status.isSuccess()){
                    goLogInScreen();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Could not log out", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onBackPressed() {
        
    }

    //CREATE
    /*public void moveButton1(){
        View btnCreate = findViewById(R.id.btnCreate);
        /************************************************************
        <uses-sdk android:minSdkVersion="14"
        android:targetSdkVersion="20"
        android:maxSdkVersion="21" />
        *************************************************************
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(recipesLayout);
        }

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
        ************************************************
        <uses-sdk android:minSdkVersion="14"
        android:targetSdkVersion="20"
        android:maxSdkVersion="21" />
        ************************************************
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            TransitionManager.beginDelayedTransition(recipesLayout);
        }

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
    }*/
}
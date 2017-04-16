package com.team.java.brokenrecipes.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/*import org.parceler.Parcel;

@Parcel*/
public class Post extends Object{
    //since our variables are public, we dont' need setters and getters!
    //public String uid;
    public String title;
    public String name;
    public String time;
    public String recipe;
    //do I need this? public String key;

    //if we want to add photos to the post!
    /*public String fileName; //from firebase??
    public String photoUrl;*/

    //default constructor
    public Post() {
        //uid = "";
        title = "";
        name = "";
        time = "";
        recipe = "";
    }

    //constructor with data
    public Post(String t, String n, String ti, String r){
        title = t;
        name = n;
        time = ti;
        recipe = r;
    }

    //firsebase stuff- need to double check with actual firebase guidlines as they may have changed
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("name", name);
        result.put("time", time);
        result.put("recipe", recipe);
        return result;
    }
}

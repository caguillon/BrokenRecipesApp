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
    public String recipe;
    public String date;
    //do I need this? public String key;

    //if we want to add photos to the post!
    /*public String fileName; //from firebase??
    public String photoUrl;*/

    //default constructor
    public Post() {
        //uid = "";
        title = "";
        name = "";
        recipe = "";
        date = "";
    }

    //constructor with data
    public Post(String t, String n, String r, String d){
        title = t;
        name = n;
        recipe = r;
        date = d;
    }

    //firsebase stuff- need to double check with actual firebase guidlines as they may have changed
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("name", name);
        result.put("recipe", recipe);
        result.put("date", date);
        return result;
    }
}

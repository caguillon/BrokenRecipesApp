package com.team.java.brokenrecipes.Models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/*import org.parceler.Parcel;

@Parcel*/
public class Post extends Object{
    //since our variables are public, we dont' need setters and getters!
    public String uid;
    public String title;
    public String name;
    public String time;
    public String recipe;

    //default constructor
    public Post() {
        uid = "";
        title = "";
        name = "";
        time = "";
        recipe = "";
    }

    //constructor with data
    public Post(String u, String t, String n, String ti, String r){
        uid = u;
        title = t;
        name = n;
        time = ti;
        recipe = r;
    }

    //firsebase stuff- need to double check with actual firebase guidlines as they may have changed
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("title", title);
        result.put("name", name);
        result.put("time", time);
        result.put("recipe", recipe);
        return result;
    }
}

package com.team.java.brokenrecipes.Models;

//add the import for firebase here!!!
import org.parceler.Parcel;

import java.util.HashMap;
import java.util.Map;

@Parcel
public class Post extends Object{
    //since our variables are public, we dont' need setters and getters!
    public String uid; //do I need this?
    public String title;
    public String ingredients;
    public String recipeSteps;
    public String date;
    //do I need this? public String key;

    //if we want to add photos to the post!
    /*public String fileName; //from firebase??
    public String photoUrl;*/

    //default constructor
    public Post() {
        uid = "";
        title = "";
        ingredients = "";
        recipeSteps = "";
        date = "";
    }

    //constructor with data
    public Post(String u, String t, String i, String r, String d){
        uid = u;
        title = t;
        ingredients = i;
        recipeSteps = r;
        date = d;
    }

    //firsebase stuff- need to double check with actual firebase guidlines as they may have changed
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("title", title);
        result.put("ingredients", ingredients);
        result.put("recipeSteps", recipeSteps);
        result.put("date", date);
        return result;
    }
}

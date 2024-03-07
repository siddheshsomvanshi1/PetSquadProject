package com.example.petsquad;

import android.graphics.Bitmap;

public class PostModal {

    private String postName;
    private String postDescription;
   private int id;

    public PostModal(String postName, String postDescription) {
        this.postName = postName;
        this.postDescription = postDescription;

    }


    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

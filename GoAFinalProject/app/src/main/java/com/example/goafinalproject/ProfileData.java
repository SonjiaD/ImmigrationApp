package com.example.goafinalproject;

import android.graphics.Bitmap;

public class ProfileData {


    private String type;
    private Bitmap icon;

    public ProfileData(String type, Bitmap icon) {
        this.type = type;
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

}

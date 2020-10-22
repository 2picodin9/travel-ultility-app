package com.example.travelutilityapp.entity;

import android.graphics.drawable.Drawable;
import android.renderscript.ScriptIntrinsicYuvToRGB;

public class CardItem {
    private Integer image;
    private String name;

    public CardItem(Integer image, String name) {
        this.image = image;
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

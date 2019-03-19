package com.example.ignite;

public class textAndImage {
    private int imageResourceId;
    private String contentName;

    public textAndImage(int imageResourceId, String contentName) {
        this.imageResourceId = imageResourceId;
        this.contentName = contentName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getContentName() {
        return contentName;
    }
}

package com.example.ignite;

public class imageAndText {

    private String text;
    private int imageID;


    public imageAndText(String text, int imageID) {
        this.text = text;
        this.imageID = imageID;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}

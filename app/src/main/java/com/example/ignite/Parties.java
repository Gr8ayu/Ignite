package com.example.ignite;

public class Parties {
    private int imageResourceId;
    private String partyName;

    public Parties(int imageResourceId, String partyName) {
        this.imageResourceId = imageResourceId;
        this.partyName = partyName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getPartyName() {
        return partyName;
    }
}

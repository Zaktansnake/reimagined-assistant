package com.example.david_chong.reimagined_assistant.speech;

public class SpeechDataObject {
    private String action;
    private String location;

    public SpeechDataObject(String action, String location) {
        this.action = action;
        this.location = location;
    }

    public String getAction() {
        return action;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        String readableString = String.format("action: %s, location: %s", action, location);
        return readableString;
    }
}

package com.example.david_chong.reimagined_assistant.speech;

public interface SpeechInterpretor {
    SpeechDataObject interpret(String text);
    void callbackInterpret(String text, SpeechCallback callback);
}

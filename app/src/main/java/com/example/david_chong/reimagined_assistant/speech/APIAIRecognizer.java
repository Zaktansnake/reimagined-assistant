package com.example.david_chong.reimagined_assistant.speech;

import android.content.Context;
import android.util.Log;

import com.example.david_chong.reimagined_assistant.R;

import java.util.concurrent.ExecutorService;

import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class APIAIRecognizer implements SpeechInterpretor {
    private static final String TAG = "AASI";

    private Context context;
    private ExecutorService executorService;
    private AIDataService aiDataService;

    public APIAIRecognizer(ExecutorService executorService, Context context){
        this.context = context;
        this.executorService = executorService;

        String accessToken = context.getString(R.string.api_ai_key);

        AIConfiguration aiConfiguration = new AIConfiguration(accessToken,
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        this.aiDataService = new AIDataService(context, aiConfiguration);
    }

    @Override
    public SpeechDataObject interpret(String text) {

        AIRequest aiRequest = new AIRequest(text);
        AIResponse aiResponse = null;
        try {
            aiResponse = aiDataService.request(aiRequest);
        } catch (AIServiceException e) {
            Log.e(TAG, "AIServiceException Caught: ", e);
            return null;
        }

        if(aiResponse == null){
            Log.e(TAG, "Null AI Response");
            throw new NullPointerException("Null AI Response");
        }

        Result result = aiResponse.getResult();
        String action = result.getAction();
        String location = result.getStringParameter("location", "");

        SpeechDataObject speechDataObject = new SpeechDataObject(action, location);
        Log.d(TAG, speechDataObject.toString());
        return speechDataObject;
    }

    @Override
    public void callbackInterpret(final String text, final SpeechCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                SpeechDataObject speechDataObject = interpret(text);

                if(callback != null){
                    callback.recieveCallback(speechDataObject);
                }
            }
        };

        this.executorService.submit(runnable);
    }
}

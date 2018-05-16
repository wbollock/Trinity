package com.example.wbollock.trinity;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


public class TrinityIntentService extends IntentService{ {

    private static final String TAG ="wbollock.com.trinity";

    public TrinityIntentService(String name) {
        super("TrinityIntentService");
    }


    protected void onHandleIntent(Intent intent) {
        //this is what the service will actually do
        Log.i(TAG, "The service has now started");
    }
}



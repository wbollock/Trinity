package com.example.wbollock.trinity;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
public class IntentServiceHandler extends Service {

    private static final String TAG ="wbollock.com.trinity";

    public IntentServiceHandler() {
    } // constructor

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand called");

        Runnable r = new Runnable() { // making a new thread, filled this in automatically
            @Override
            public void run() {
                for(int i=0; i<5; i++){
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime){
                        synchronized (this) {
                            try{
                                wait(futureTime-System.currentTimeMillis());
                                Log.i(TAG, "service is doing something"); // actual code would go HERE when running a service
                            }catch(Exception e){} // need to catch these
                        }
                    }
                }
            }
        };
        Thread trinityThread = new Thread(r); // "r" is the code we want to run inside the thread
        trinityThread.start();
        return Service.START_STICKY; // need to return something for the onStartCommand
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy called");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    } // bound service, not important right now. so return NULL
}

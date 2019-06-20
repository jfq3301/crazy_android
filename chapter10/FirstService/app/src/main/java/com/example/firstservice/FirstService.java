package com.example.firstservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FirstService extends Service {
    public FirstService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service is created.");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service is started.");
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service is destroyed.");

    }
}

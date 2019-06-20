package com.example.firstservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BindService extends Service {
    private int count;
    private boolean quit = false;
    private MyBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        public int getCount() {
            return count;
        }
    }

    public BindService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        System.out.println("[jfq]Service is binded.");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        quit = false;
        count = 0;
        System.out.println("[jfq]Service is created..");
        new Thread() {
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    count++;
                }
            }
        }.start();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("[jfq]Service is onUnbinded.");
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        System.out.println("[jfq]Service is Destoryed.");
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
        this.quit = true;
        System.out.println("[jfq]Service is rebind.");
    }
}

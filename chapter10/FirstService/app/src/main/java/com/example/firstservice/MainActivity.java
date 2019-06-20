package com.example.firstservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button btnStop;
    Button btnBind;
    Button btnUnbind;
    Button btnGetServiceStatus;
    BindService.MyBinder binder;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("[jfq] Service is connected.");
            binder = service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("[jfq] Service is disconnected.");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief first service.
         * @author fjiang2
         * @date 2019.6.19
         */
        setContentView(R.layout.activity_main);
        btnStart = findViewById(R.id.bnStart);
        btnStop = findViewById(R.id.bnStop);
        final Intent intent = new Intent(this, FirstService.class);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        btnBind = findViewById(R.id.btnBind);
        btnUnbind = findViewById(R.id.btnUnbind);
        btnGetServiceStatus = findViewById(R.id.btnGetServiceStatus);
        final Intent intentBind = new Intent(this, BindService.class);
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intentBind, conn, );
            }
        });
    }
}

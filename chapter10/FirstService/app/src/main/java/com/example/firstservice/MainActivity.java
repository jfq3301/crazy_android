package com.example.firstservice;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button btnStop;
    Button btnBind;
    Button btnUnbind;
    Button btnGetServiceStatus;
    Button btnStartBindService;
    BindService.MyBinder binder;
    Intent intentBind;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("[jfq] Service is connected.");
            binder = (BindService.MyBinder)service;
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
        final Intent intent = new Intent(this, MyIntentService.class);
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
        btnStartBindService = findViewById(R.id.btnStartBindService);
        intentBind = new Intent(this,
                BindService.class);
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intentBind, conn, Service.BIND_AUTO_CREATE);
            }
        });

        btnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(conn);
            }
        });

        btnGetServiceStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,
                        "service count: " + binder.getCount(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnStartBindService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intentBind);
            }
        });


        Button btnVibratorTest = findViewById(R.id.btnVibratorTest);
        btnVibratorTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator = (Vibrator)getSystemService(
                        Service.VIBRATOR_SERVICE
                );
                vibrator.vibrate(2000);
                Toast.makeText(MainActivity.this, "vibrator test",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button btnSendBroadcast = findViewById(R.id.btnSendBroadcast);
        btnSendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("org.crazyit.action.CRAZY_BROADCAST");
                intent.putExtra("msg", "简单的消息测试");
                sendBroadcast(intent);
            }
        });
    }
}

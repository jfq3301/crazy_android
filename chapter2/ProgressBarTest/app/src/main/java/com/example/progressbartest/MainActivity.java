package com.example.progressbartest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private int[] data = new int[100];
    int index = 0;
    int progress = 0;
    ProgressBar bar, bar2;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
            if (msg.what == 0x111) {
                bar.setProgress(progress);
                bar2.setProgress(progress);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief progress bar test.
         * @author fjiang2
         * @date 2019.5.26
         */
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.bar);
        bar2 = findViewById(R.id.bar2);
        new Thread() {
            @Override
            public void run() {
//                super.run();
                while (progress < 100) {
                    progress = doWork();
                    mHandler.sendEmptyMessage(0x111);
                }
            }
        }.start();
    }

    public int doWork() {
        data[index++] = 11;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  index;
    }
}

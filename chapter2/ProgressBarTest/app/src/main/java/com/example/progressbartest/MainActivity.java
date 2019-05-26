package com.example.progressbartest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

//    private int[] data = new int[100];
//    int index = 0;
//    int progress = 0;
//    ProgressBar bar, bar2;
//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
////            super.handleMessage(msg);
//            if (msg.what == 0x111) {
//                bar.setProgress(progress);
//                bar2.setProgress(progress);
//            }
//        }
//    };

//    Button bn, bn2;

    ImageView image;
    SeekBar seekBar;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief progress bar test.
         * @author fjiang2
         * @date 2019.5.26
         */
//        setContentView(R.layout.activity_main);
//        bar = findViewById(R.id.bar);
//        bar2 = findViewById(R.id.bar2);
//        new Thread() {
//            @Override
//            public void run() {
////                super.run();
//                while (progress < 100) {
//                    progress = doWork();
//                    mHandler.sendEmptyMessage(0x111);
//                }
//            }
//        }.start();

        /**
         * @brief title progress bar test. test failed, not support now.
         * @author fjiang2
         * @date 2019.5.26
         */
//        setContentView(R.layout.title_progress_bar);
//        requestWindowFeature(Window.FEATURE_PROGRESS);
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
//        setProgressBarIndeterminate(true);
//        setProgressBarVisibility(true);
//        setProgress(4500);

        /**
         * @brief seekBar/ ratingBar test.
         * @author fjiang2
         * @date 2019.5.26
         */
        setContentView(R.layout.seek_bar_test);
        image = findViewById(R.id.image);
        seekBar = findViewById(R.id.seekbar);
        ratingBar = findViewById(R.id.ratingbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                image.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                image.setImageAlpha((int)(rating * 255 / 5));
            }
        });


    }

//    public int doWork() {
//        data[index++] = 11;
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return  index;
//    }
}

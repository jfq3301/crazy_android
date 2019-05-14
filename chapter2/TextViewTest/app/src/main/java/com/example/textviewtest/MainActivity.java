/**
 * @brief textview/ editText test
 * @author jfq3301
 * @date 2019.5.8
 */

package com.example.textviewtest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

//    RadioGroup rg;
//    TextView tv;
    Chronometer ch;
    Button start;

    ToggleButton toggle;
    Switch switcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.edittext_test);
//        setContentView(R.layout.button_test);

        /**
         * @brief check button test
         * @date 2019.5.14
         */
//        setContentView(R.layout.check_button_test);
//        rg = findViewById(R.id.rg);
//        tv = findViewById(R.id.show);
//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                String tips;
//
//                if (checkedId == R.id.female){
//                    tips = "It's female.";
//                } else {
//                    tips = "It's male.";
//                }
//                tv.setText(tips);
//            }
//        });

        /**
         * @brief toggle button test
         * @date 2019.5.14
         */
//        setContentView(R.layout.toggle_button_test);
//        toggle = (ToggleButton)findViewById(R.id.toggle);
//        switcher = (Switch)findViewById(R.id.switcher);
//        final LinearLayout test = (LinearLayout)findViewById(R.id.test);
//
//        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    test.setOrientation(1);
//                    toggle.setChecked(true);
//                    switcher.setChecked(true);
//                } else {
//                    test.setOrientation(0);
//                    toggle.setChecked(false);
//                    switcher.setChecked(false);
//                }
//            }
//        };
//        toggle.setOnCheckedChangeListener(listener);
//        switcher.setOnCheckedChangeListener(listener);

        /**
         * @brief chronometer test
         * @date 2019.5.14
         */
        setContentView(R.layout.chronometer);
        ch = findViewById(R.id.chrn_test);
        start = findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                start.setEnabled(false);
            }
        });

        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime() - ch.getBase() > 5 *1000) {
                    ch.stop();
                    start.setEnabled(true);
                }
            }
        });
    }
}

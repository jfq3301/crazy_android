/**
 * @brief textview/ editText test
 * @author jfq3301
 * @date 2019.5.8
 */

package com.example.textviewtest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.QuickContactBadge;
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

    ImageView image1;
    ImageView image2;
    int[] images = new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi
    };
    int currentImg = 2;
    private int alpha = 255;

    QuickContactBadge badge;

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
//        setContentView(R.layout.chronometer);
//        ch = findViewById(R.id.chrn_test);
//        start = findViewById(R.id.start);
//
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ch.setBase(SystemClock.elapsedRealtime());
//                ch.start();
//                start.setEnabled(false);
//            }
//        });
//
//        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
//            @Override
//            public void onChronometerTick(Chronometer chronometer) {
//                if (SystemClock.elapsedRealtime() - ch.getBase() > 5 *1000) {
//                    ch.stop();
//                    start.setEnabled(true);
//                }
//            }
//        });

        /**
         * @brief imageView test
         * @date 2019.5.15
         */
//        setContentView(R.layout.image_view_test);
//        final Button increaseA = findViewById(R.id.increaseAlpha);
//        final Button decreaseA = findViewById(R.id.decreaseAlpha);
//        Button nextImage = findViewById(R.id.nextImage);
//        image1 = findViewById(R.id.image1);
//        image2 = findViewById(R.id.image2);
//        image1.setImageResource(images[currentImg]);
//
//        nextImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                image1.setImageResource(images[++currentImg % images.length]);
//            }
//        });
//
//        View.OnClickListener listener = new View.OnClickListener() {
//            public void onClick(View v) {
//                if (v == increaseA)
//                {
//                    alpha += 20;
//                } else if (v == decreaseA) {
//                    alpha -= 20;
//                }
//
//                if (alpha >= 255) {
//                    alpha = 255;
//                }
//
//                if (alpha <= 0) {
//                    alpha = 0;
//                }
//
//                image1.setImageAlpha(alpha);
//            }
//        };
//
//        increaseA.setOnClickListener(listener);
//        decreaseA.setOnClickListener(listener);
//
//        image1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) image1.getDrawable();
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                double scale = 1.0 * bitmap.getHeight() / image1.getHeight();
//                int x = (int)(event.getX() * scale);
//                int y = (int)(event.getY() * scale);
//
//                if (x + 120 > bitmap.getWidth()){
//                    x = bitmap.getWidth() -120;
//                }
//                if (y + 120 > bitmap.getHeight()){
//                    y = bitmap.getHeight() -120;
//                }
//                image2.setImageBitmap(Bitmap.createBitmap(bitmap, x, y, 120, 120));
//                image2.setImageAlpha(alpha);
//                return  false;
//            }
//        });

        /**
         * @brief imageButton test.
         * @author fjiang2
         * @date 2019.5.25
         */
//        setContentView(R.layout.image_button_test);

        /**
         * @brief quick contact badge test.
         *   test failed.
         * @author fjiang2
         * @date 2019.5.28
         */
//        setContentView(R.layout.quick_contact_badge_test);
//        badge = findViewById(R.id.badge);
//        badge.assignContactFromPhone("10086", false);

        /**
         * @brief auto complete text view test.
         * @author fjiang2
         * @date 2019.5.30
         */
        setContentView(R.layout.auto_complete_text_view_test);
        AutoCompleteTextView auto = findViewById(R.id.auto);
        MultiAutoCompleteTextView mauto = findViewById(R.id.mauto);
        String [] books = new String[]{
                "crazy java",
                "crazy ajax",
                "crazy android",
                "crazy xml"
        };

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                books);

        auto.setAdapter(aa);
        mauto.setAdapter(aa);
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}

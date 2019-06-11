/**
 * @biref toast test.
 * @author jfq3301
 * @date 2019.5.6
 */

package com.example.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

//    private int year;
//    private int month;
//    private int day;
//    private int hour;
//    private int minute;
//    private int second

//    private void showDate(int year, int month, int day,
//                          int hour, int minute) {
//        EditText et = findViewById(R.id.showEditText);
//        et.setText("day: " + year + "." + (month+1) + "." + day + " " + hour + ":" + minute + ":00" );
//    }

    private SearchView sv;
    private ListView lv;
    private final String[] mStrings = {
            "aaaaaaaa",
            "bbbbbbbb",
            "cccccccc"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        /**
         * @brief search view test
         * @author fjiang2
         * @date 2019.6.11
         */
        setContentView(R.layout.search_view_test);
        lv = findViewById(R.id.lv);
        sv = findViewById(R.id.sv);
        lv.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                mStrings));
        lv.setTextFilterEnabled(true);
        sv.setIconifiedByDefault(false);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("search some thing");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,
                        "your choose: " + query,
                        Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    lv.clearTextFilter();
                } else {
                    lv.setFilterText(newText);
                }
                return false;
            }
        });


        /**
         * @brief datePicker/ timePicker test
         * @author fjiang2
         * @date 2019.6.10
         */
//        setContentView(R.layout.data_time_picker);
//        DatePicker dataPicker = findViewById(R.id.dataPicker);
//        TimePicker timePicker = findViewById(R.id.timePicker);
//
//        Calendar c = Calendar.getInstance();
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH);
//        day = c.get(Calendar.DAY_OF_MONTH);
//        hour = c.get(Calendar.HOUR);
//        minute = c.get(Calendar.MINUTE);
//
//        dataPicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                MainActivity.this.year = year;
//                MainActivity.this.month = monthOfYear;
//                MainActivity.this.day = dayOfMonth;
//                showDate(year, month, day, hour, minute);
//            }
//        });
//
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                MainActivity.this.hour = hourOfDay;
//                MainActivity.this.minute = minute;
//                showDate(year, month, day, hour, minute);
//            }
//        });




        /**
         * @brief calendar test
         * @author fjiang2
         * @date 2019.6.10
         */
//        setContentView(R.layout.calendar_view);
//        CalendarView cv = findViewById(R.id.calendarView);
//        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                Toast.makeText(MainActivity.this,
//                        "your birthday: " + year +
//                        " year " + month + " month "
//                + dayOfMonth + " day", Toast.LENGTH_SHORT).show();
//            }
//        });

//        Button simple = (Button)findViewById(R.id.simple);
//        simple.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(MainActivity.this,
//                        "Simple test tips",
//                        Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });
//
//        Button complex = findViewById(R.id.complex);
//        complex.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = new Toast(MainActivity.this);
//                toast.setGravity(Gravity.CENTER, 0, 0);
//
//                ImageView image = new ImageView(MainActivity.this);
//                image.setImageResource(R.drawable.ic_launcher_background);
//
//                LinearLayout ll = new LinearLayout(MainActivity.this);
//                ll.addView(image);
//
//                TextView tv = new TextView(MainActivity.this);
//                tv.setText("toast with image");
//                tv.setTextSize(34);
//                ll.addView(tv);
//
//                toast.setView(ll);
//                toast.setDuration(Toast.LENGTH_LONG);
//                toast.show();
//            }
//        });

    }
}

package com.example.fragmentlifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_second);
        TextView tv = new TextView(this);
        tv.setText("对话框风格的activity");
        setContentView(tv);
    }

}

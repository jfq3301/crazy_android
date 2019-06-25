package com.example.fragmentlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStartActivity;
    Button btnAf;
    Button btnBackStack;
    Button btnReplaceFrag;
    Button btnQuit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * @brief fragment lifecycle test.
         * @author fjiang2
         * @date 2019.6.25
         */
        btnStartActivity = findViewById(R.id.btnStartActivity);
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
            }
        });

        btnAf = findViewById(R.id.btnAddFragment);
        btnAf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LifecycleFragment fragment = new LifecycleFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
            }
        });

        btnBackStack = findViewById(R.id.btnBackFragment);
        btnBackStack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment)
                        .addToBackStack("aa")
                        .commit();
            }
        });

        btnReplaceFrag = findViewById(R.id.btnReplaceFrag);
        btnReplaceFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment fragment = new SecondFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();
            }
        });

        btnQuit = findViewById(R.id.btnFinish);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
    }
}

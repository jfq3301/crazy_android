package com.example.standardtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        this.setContentView(ll);

        TextView tv = new TextView(this);
        tv.setText("Acitivity: " + this.toString() +
                "\nTask id: " + this.getTaskId());
        Button btn = new Button(this);
        btn.setText("启动MainActiviy");
        ll.addView(tv);
        ll.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

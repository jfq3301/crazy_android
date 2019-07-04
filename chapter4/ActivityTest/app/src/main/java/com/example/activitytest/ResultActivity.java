package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView name = findViewById(R.id.name);
        TextView passwd = findViewById(R.id.passwd);
        TextView gender = findViewById(R.id.gender);

        Intent intent = getIntent();
        Person p = (Person)intent.getSerializableExtra("person");
        name.setText("姓名：" + p.getName());
        passwd.setText("passwd: " + p.getPasswd());
        gender.setText("gender: " + p.getGender());
    }
}

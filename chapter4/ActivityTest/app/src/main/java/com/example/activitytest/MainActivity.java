package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnSignUp);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etName = (EditText)findViewById(R.id.name);
                EditText etPasswd = (EditText)findViewById(R.id.passwd);
                RadioButton male = (RadioButton)findViewById(R.id.male);
                String gender = male.isChecked()?"男":"女";
                Person p = new Person(etName.getText().toString(),
                        etPasswd.getText().toString(),
                        gender);
                Bundle data = new Bundle();
                data.putSerializable("person", (Serializable) p);
                Intent intent = new Intent(MainActivity.this,
                        ResultActivity.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });
    }
}

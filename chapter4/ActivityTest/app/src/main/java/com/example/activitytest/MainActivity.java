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

    Button btnSelect;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief start activity for result test.
         * @date 2019.7.4
         */
        setContentView(R.layout.activity_for_result);
        btnSelect = findViewById(R.id.btnSelect);
        city = findViewById(R.id.city);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SelectCityActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        /**
         * @brief bundle test.
         * @date 2019.7.4
         */
//        setContentView(R.layout.activity_main);
//        Button btn = findViewById(R.id.btnSignUp);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText etName = (EditText)findViewById(R.id.name);
//                EditText etPasswd = (EditText)findViewById(R.id.passwd);
//                RadioButton male = (RadioButton)findViewById(R.id.male);
//                String gender = male.isChecked()?"男":"女";
//                Person p = new Person(etName.getText().toString(),
//                        etPasswd.getText().toString(),
//                        gender);
//                Bundle data = new Bundle();
//                data.putSerializable("person", (Serializable) p);
//                Intent intent = new Intent(MainActivity.this,
//                        ResultActivity.class);
//                intent.putExtras(data);
//                startActivity(intent);
//            }
//        });


    }

     @Override
     public void onActivityResult(int requestCode,
                                  int resultCode,
                                  Intent intent) {
        if ((requestCode == 0) && (resultCode == 0)) {
            Bundle data = intent.getExtras();
            String cityStr = data.getString("city");
            city.setText(cityStr);
        }
     }

}

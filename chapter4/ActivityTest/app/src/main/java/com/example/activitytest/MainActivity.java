package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

//    Button btnSelect;
//    EditText city;
    final String TAG = "---jfq----";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief start activity for result test.
         * @date 2019.7.4
         */
        setContentView(R.layout.activity_main);

        Log.d(TAG, "------------onCreate------------");
        Button btnStart = findViewById(R.id.btnStart);
        Button btnQuit = findViewById(R.id.btnQuit);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivity(intent);
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("简单对话框")
//                        .setIcon(R.drawable.ic_launcher_foreground)
//                        .setMessage("hello world.");
//                builder.setPositiveButton("确定", null);
//                builder.setNegativeButton("取消", null);
//                builder.create().show();
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        /**
         * @brief start activity for result test.
         * @date 2019.7.4
         */
//        setContentView(R.layout.activity_for_result);
//        btnSelect = findViewById(R.id.btnSelect);
//        city = findViewById(R.id.city);
//        btnSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,
//                        SelectCityActivity.class);
//                startActivityForResult(intent, 0);
//            }
//        });


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

//     @Override
//     public void onActivityResult(int requestCode,
//                                  int resultCode,
//                                  Intent intent) {
//        if ((requestCode == 0) && (resultCode == 0)) {
//            Bundle data = intent.getExtras();
//            String cityStr = data.getString("city");
//            city.setText(cityStr);
//        }
//     }

     @Override
     public void onStart() {
        super.onStart();
        Log.d(TAG, "------------onStart------------");
     }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.d(TAG, "------------onRestart------------");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "------------onResume------------");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "------------onPause------------");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "------------onStop------------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "------------onDestroy------------");
    }

}

package com.example.otheractivity;

import android.app.ExpandableListActivity;
import android.app.LauncherActivity;
import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends LauncherActivity {

    String[] names = {"设置程序参数", "查看星际兵种"};
    Class<?>[] clazzs = {
            PreferenceActivityTest.class,
            //ExpandableListActivityTest.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        setListAdapter(adapter);
    }

    public Intent intentForPosition(int position) {
        return new Intent(this, clazzs[position]);
    }

}

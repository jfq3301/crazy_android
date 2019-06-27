package com.example.actionbar;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvActionItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvActionItem = findViewById(R.id.tvActionItem);
        registerForContextMenu(tvActionItem);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);
        /**
         * setNavigationMode 不能用了。
         * 2019.6.27
         */
//      actionBar.setNavigationMode();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("请选择背景色");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.red:
                tvActionItem.setBackgroundColor(Color.RED);
                break;
            case R.id.green:
                tvActionItem.setBackgroundColor(Color.GREEN);
                break;
            case R.id.blue:
                tvActionItem.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //if (item.isCheckable()) {
            item.setChecked(true);
        //}
        switch (item.getItemId()) {
            case R.id.font_10:
                tvActionItem.setTextSize(10*2);
                break;
            case R.id.font_12:
                tvActionItem.setTextSize(12*2);
                break;
            case R.id.font_14:
                tvActionItem.setTextSize(14*2);
                break;
            case R.id.font_16:
                tvActionItem.setTextSize(16*2);
                break;
        }
        return true;
    }
}

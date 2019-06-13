package com.example.dialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView show;
    String[] items = new String[] {
            "crazy java",
            "crazy xml",
            "crazy java ee",
            "crazy android"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief AlertDialog test
         * @author fjiang2
         * @date 2019.6.13
         */
        setContentView(R.layout.activity_main);
        show = findViewById(R.id.show);
    }

    public void simple(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("简单对话框");
        builder.setIcon(R.drawable.tools);
        builder.setMessage("对话框测试内容\n第二行内容");
        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    public void simpleList(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("简单列表对话框");
        builder.setIcon(R.drawable.tools);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("你选中了《" + items[which] + "》");
            }
        });

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    public void simpleChoice(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("单选列表项对话框");
        builder.setIcon(R.drawable.tools);
        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("你选中了《" + items[which] + "》");
            }
        });

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    public void multiChoice(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("单选列表项对话框");
        builder.setIcon(R.drawable.tools);
        builder.setMultiChoiceItems(items, new boolean[] {false, true, false, true}, null);

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    /**
     * test failed. 2019.6.13.
     *
     */
    public void customList(View v) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("自定义列表项对话框");
        builder.setIcon(R.drawable.tools);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.array_item,
                items);
        builder.setAdapter(adapter, null);

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

    public void customView(View v) {
        TableLayout loginForm = (TableLayout)getLayoutInflater()
            .inflate(R.layout.login, null);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("自定义试图对话框");
        builder.setIcon(R.drawable.tools);
        builder.setView(loginForm);

        builder.setPositiveButton("确定", null);
        builder.setNegativeButton("取消", null);
        builder.create().show();
    }

}

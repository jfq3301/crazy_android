package com.example.dialogtest;

//import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    TextView show;
//    String[] items = new String[] {
//            "crazy java",
//            "crazy xml",
//            "crazy java ee",
//            "crazy android"
//    };

    EditText etMenu;
    Button startActivityBn;
    Button bnPopup;
    PopupMenu popup = null;

    final int FONT_10 = 0X111;
    final int FONT_12 = 0X112;
    final int FONT_14 = 0X113;
    final int FONT_16 = 0X114;
    final int FONT_18 = 0X115;

    final int PLAIN_ITEM = 0x11b;

    final int FONT_RED = 0x116;
    final int FONT_BLUE = 0x117;
    final int FONT_GREEN = 0x118;


    private ActionBar actionBar;

    public void showActionBar(View v) {
        actionBar.show();
    }

    public void hideActionBar(View v) {
        actionBar.hide();
    }

    /**
     * @brief Menu test
     * @author fjiang2
     * @date 2019.6.18
     */
    public boolean onCreateOptionsMenu(Menu menu){
        SubMenu fontMenu = menu.addSubMenu("Font size");
        fontMenu.setIcon(R.drawable.tools);
        fontMenu.setHeaderIcon(R.drawable.tools);
        fontMenu.setHeaderTitle("选择字体大小");
        fontMenu.add(0, FONT_10, 0, "10号字体");
        fontMenu.add(0, FONT_12, 0, "12号字体");
        fontMenu.add(0, FONT_14, 0, "14号字体");
        fontMenu.add(0, FONT_16, 0, "16号字体");
        fontMenu.add(0, FONT_18, 0, "18号字体");

        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");

        SubMenu saMenu = menu.addSubMenu("启动程序");
        saMenu.setIcon(R.drawable.tools);
        saMenu.setHeaderTitle("选择要启动的程序");
        MenuItem item = saMenu.add("查看swift");
        item.setIntent(new Intent(MainActivity.this,
                OtherActivity.class));

        SubMenu colorMenu = menu.addSubMenu("字体颜色");
        colorMenu.setIcon(R.drawable.tools);
        colorMenu.setHeaderIcon(R.drawable.tools);
        colorMenu.setHeaderTitle("选择字体颜色111");
        colorMenu.add(0, FONT_RED, 0, "红色");
        colorMenu.add(0, FONT_BLUE, 0, "蓝色");
        colorMenu.add(0, FONT_GREEN, 0, "绿色");

        return  super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case FONT_10:
                etMenu.setTextSize(2*10);
                break;
            case FONT_12:
                etMenu.setTextSize(2*12);
                break;
            case FONT_14:
                etMenu.setTextSize(2*14);
                break;
            case FONT_16:
                etMenu.setTextSize(2*16);
                break;
            case FONT_18:
                etMenu.setTextSize(2*18);
                break;
            case FONT_RED:
                etMenu.setTextColor(Color.RED);
                break;
            case FONT_BLUE:
                etMenu.setTextColor(Color.BLUE);
                break;
            case FONT_GREEN:
                etMenu.setTextColor(Color.GREEN);
                break;
            case PLAIN_ITEM:
                Toast toast = Toast.makeText(MainActivity.this,
                        "hello world..", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }

    /**
     * @brief long press to trigger it
     * @date 2019.6.18
     * @param menu
     * @param source
     * @param menuInfo
     */
    public void onCreateContextMenu(ContextMenu menu,
                                    View source,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, FONT_RED, 0, "红色");
        menu.add(0, FONT_GREEN, 0, "绿色");
        menu.setGroupCheckable(0, true, true);
        menu.setHeaderIcon(R.drawable.tools);
        menu.setHeaderTitle("选择背景颜色");
    }

    public boolean onContextItemSelected(MenuItem mi) {
        switch (mi.getItemId()) {
            case FONT_RED:
                mi.setChecked(true);
                etMenu.setBackgroundColor(Color.RED);
                break;
            case FONT_GREEN:
                mi.setChecked(true);
                etMenu.setBackgroundColor(Color.GREEN);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * @brief ActionBar test
         * @author fjiang2
         * @date 2019.6.14
         */
        setContentView(R.layout.action_bar_test);
        actionBar = getSupportActionBar();
        etMenu = findViewById(R.id.etMenu);
        registerForContextMenu(etMenu);

        startActivityBn = findViewById(R.id.start_activity1);
        startActivityBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        OtherActivity.class);
                startActivity(intent);
            }
        });

        bnPopup = findViewById(R.id.bnPopupMenu);
        bnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup = new PopupMenu(MainActivity.this, v);
                getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.exit:
                                popup.dismiss();
                                break;
                                default:
                                    Toast.makeText(MainActivity.this,
                                            "your click " + item.getTitle(),
                                            Toast.LENGTH_SHORT).show();
                                    break;

                        }
                        return true;
                    }
                });
                popup.show();
            }
        });

        /**
         * @brief AlertDialog test
         * @author fjiang2
         * @date 2019.6.13
         */
//        setContentView(R.layout.activity_main);
//        show = findViewById(R.id.show);
    }
//
//    public void simple(View v) {
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(this);
//        builder.setTitle("简单对话框");
//        builder.setIcon(R.drawable.tools);
//        builder.setMessage("对话框测试内容\n第二行内容");
//        builder.setPositiveButton("确定", null);
//        builder.setNegativeButton("取消", null);
//        builder.create().show();
//    }
//
//    public void simpleList(View v) {
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(this);
//        builder.setTitle("简单列表对话框");
//        builder.setIcon(R.drawable.tools);
//        builder.setItems(items, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                show.setText("你选中了《" + items[which] + "》");
//            }
//        });
//
//        builder.setPositiveButton("确定", null);
//        builder.setNegativeButton("取消", null);
//        builder.create().show();
//    }
//
//    public void simpleChoice(View v) {
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(this);
//        builder.setTitle("单选列表项对话框");
//        builder.setIcon(R.drawable.tools);
//        builder.setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                show.setText("你选中了《" + items[which] + "》");
//            }
//        });
//
//        builder.setPositiveButton("确定", null);
//        builder.setNegativeButton("取消", null);
//        builder.create().show();
//    }
//
//    public void multiChoice(View v) {
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(this);
//        builder.setTitle("单选列表项对话框");
//        builder.setIcon(R.drawable.tools);
//        builder.setMultiChoiceItems(items, new boolean[] {false, true, false, true}, null);
//
//        builder.setPositiveButton("确定", null);
//        builder.setNegativeButton("取消", null);
//        builder.create().show();
//    }
//
//    /**
//     * test failed. 2019.6.13.
//     *
//     */
//    public void customList(View v) {
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(this);
//        builder.setTitle("自定义列表项对话框");
//        builder.setIcon(R.drawable.tools);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.array_item,
//                items);
//        builder.setAdapter(adapter, null);
//
//        builder.setPositiveButton("确定", null);
//        builder.setNegativeButton("取消", null);
//        builder.create().show();
//    }
//
//    public void customView(View v) {
//        TableLayout loginForm = (TableLayout)getLayoutInflater()
//            .inflate(R.layout.login, null);
//
//        AlertDialog.Builder builder =
//                new AlertDialog.Builder(this);
//        builder.setTitle("自定义试图对话框");
//        builder.setIcon(R.drawable.tools);
//        builder.setView(loginForm);
//
//        builder.setPositiveButton("确定", null);
//        builder.setNegativeButton("取消", null);
//        builder.create().show();
//    }

}

package com.example.adapterviewtest;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterViewFlipper;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

//    private String[] name = {"大头", "弄玉", "李清照", "李白"};
//    private String[] desp = {
//            "大头儿子小头爸爸",
//            "一个擅长音乐的女孩",
//            "一位杰出的女诗人",
//            "浪漫主义诗人"};
//    private int[] imageIds = {
//            R.drawable.tiger,
//            R.drawable.nongyu,
//            R.drawable.qingzhao,
//            R.drawable.libai};

//    private AdapterViewFlipper flipper;
//    int[] imagesIds = new int[] {
//            R.drawable.shuangzi,
//            R.drawable.shuangyu,
//            R.drawable.chunv,
//            R.drawable.tiancheng,
//            R.drawable.tianxie,
//            R.drawable.sheshou,
//            R.drawable.juxie,
//            R.drawable.shuiping,
//            R.drawable.shizi,
//            R.drawable.baiyang,
//            R.drawable.jinniu,
//            R.drawable.mojie
//    };

    public static final int NUMBER_PER_SCREEN = 12;
    public static class DataItem {
        public String dataName;
        public Drawable drawable;
    }

    private ArrayList<DataItem> items = new ArrayList<DataItem>();
    private int screenNo = -1;
    private int screenCount;
    ViewSwitcher switcher;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        /**
         * @brief array adapter test
         * @date 2019.5.12
         */
//        setContentView(R.layout.array_adapter_test);
//        ListView list1 = (ListView) findViewById(R.id.list1);
//        String[] arr1 = {"孙悟空", "猪八戒", "牛魔王"};
//        ArrayAdapter<String> arrayAdp = new ArrayAdapter<String>(this,
//                R.layout.array_item, arr1);
//        list1.setAdapter(arrayAdp);
//
//        ListView list2 = (ListView) findViewById(R.id.list2);
//        ArrayAdapter<String> arrayAdp2 = new ArrayAdapter<String>(this,
//                R.layout.checked_item, arr1);
//        list2.setAdapter(arrayAdp2);

        /**
         * @brief simple adapter test
         * @date 2019.5.12
         */
//        setContentView(R.layout.simple_adapter_test);
//        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < name.length; i++) {
//            Map<String, Object> listItem = new HashMap<String, Object>();
//            listItem.put("header", imageIds[i]);
//            listItem.put("name", name[i]);
//            listItem.put("description", desp[i]);
//            listItems.add(listItem);
//        }
//
//        // create simpleAdapter
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
//                listItems,
//                R.layout.simple_item,
//                new String[] {"header", "description", "name"},
//                new int[] {R.id.header, R.id.desc, R.id.name});
//        ListView myList = findViewById(R.id.my_list);
//        myList.setAdapter(simpleAdapter);
//        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println(name[position] + "被单击了");
//            }
//        });
//        myList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println(name[position] + "被选中了");
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
        /**
         * @brief baseadapter test
         * @date 2019.5.12
         */
//        setContentView(R.layout.simple_adapter_test);
//        ListView myList = findViewById(R.id.my_list);
//        BaseAdapter base = new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return 40;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return null;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return 0;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                LinearLayout line = new LinearLayout(MainActivity.this);
//                line.setOrientation(0);
//                ImageView image = new ImageView(MainActivity.this);
//                image.setImageResource(R.drawable.libai);
//                TextView tv = new TextView(MainActivity.this);
//                tv.setText("第" + (position+1) + "个列表项");
//                tv.setTextColor(Color.BLACK);
//                tv.setTextSize(20);
//                tv.setPadding(20, 0, 0, 0);
//                line.addView(image);
//                line.addView(tv);
//
//                return line;
//            }
//        };
//
//        myList.setAdapter(base);

        /**
         * @brief expandable list view test
         * @author fjiang2
         * @date 2019.5.30
         */
//        setContentView(R.layout.expand_list_view_test);
//        ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
//            int[] logos = new int[] {
//              R.drawable.libai,
//              R.drawable.qingzhao,
//              R.drawable.nongyu
//            };
//            private String[] armTypes = new String[] {
//                    "神族兵种",
//                    "虫族兵种",
//                    "人族兵种",
//            };
//            private String[][] arms = new String[][] {
//                    {"狂战士", "龙骑士", "黑暗圣堂", "电兵" },
//                    {"小狗", "刺蛇", "狂战士", "狂战士" },
//                    {"机枪兵", "护士", "幽灵"}
//            };
//
//            @Override
//            public int getGroupCount() {
//                return armTypes.length;
//            }
//
//            @Override
//            public int getChildrenCount(int groupPosition) {
//                return arms[groupPosition].length;
//            }
//
//            @Override
//            public Object getGroup(int groupPosition) {
//                return armTypes[groupPosition];
//            }
//
//            @Override
//            public Object getChild(int groupPosition, int childPosition) {
//                return arms[groupPosition][childPosition];
//            }
//
//            @Override
//            public long getGroupId(int groupPosition) {
//                return groupPosition;
//            }
//
//            @Override
//            public long getChildId(int groupPosition, int childPosition) {
//                return childPosition;
//            }
//
//            @Override
//            public boolean hasStableIds() {
//                return true;
//            }
//
//            @Override
//            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//                LinearLayout ll = new LinearLayout(MainActivity.this);
//                ll.setOrientation(0);
//                ImageView logo = new ImageView(MainActivity.this);
//                logo.setImageResource(logos[groupPosition]);
//                ll.addView(logo);
//
//                TextView textView = getTextView();
//                textView.setText(getGroup(groupPosition).toString());
//                ll.addView(textView);
//
//                return ll;
//            }
//
//            private TextView getTextView() {
//                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT, 64
//                );
//                TextView tv = new TextView(MainActivity.this);
//                tv.setLayoutParams(lp);
//                tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
//                tv.setPadding(36, 0, 0, 0);
//                tv.setTextSize(20);
//                return  tv;
//            }
//
//            @Override
//            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//                TextView tv = getTextView();
//                tv.setText(getChild(groupPosition, childPosition).toString());
//                return tv;
//            }
//
//            @Override
//            public boolean isChildSelectable(int groupPosition, int childPosition) {
//                return true;
//            }
//        };
//
//        ExpandableListView elv = findViewById(R.id.expandList);
//        elv.setAdapter(adapter);

        /**
         * @brief spinner test
         * @author fjiang2
         * @date 2019.5.31
         */
//        setContentView(R.layout.spinner_test);
//        Spinner spinner = findViewById(R.id.stSpinner);
//        String[] arr = {"孙悟空", "猪八戒", "唐山"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_multiple_choice,
//                arr);
//        spinner.setAdapter(adapter);

        /**
         * @brief adapter view flipper test
         * @author fjiang2
         * @date 2019.5.31
         */
//        setContentView(R.layout.adapter_view_flipper);
//        flipper = findViewById(R.id.flipper);
//        BaseAdapter adapter = new BaseAdapter() {
//            @Override
//            public int getCount() {
//                return imagesIds.length;
//            }
//
//            @Override
//            public Object getItem(int position) {
//                return position;
//            }
//
//            @Override
//            public long getItemId(int position) {
//                return position;
//            }
//
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                ImageView imageView = new ImageView(MainActivity.this);
//                imageView.setImageResource(imagesIds[position]);
//                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT));
//                return imageView;
//            }
//        };
//
//        flipper.setAdapter(adapter);
//
//    }
//
//    public void prev(View source) {
//        flipper.showPrevious();
//        flipper.stopFlipping();
//    }
//
//    public void next(View source) {
//        flipper.showNext();
//        flipper.stopFlipping();
//    }
//
//    public void auto(View source) {
//        flipper.startFlipping();
//    }

        /**
         * @brief view switcher test
         * @author fjiang2
         * @date 2019.5.31
         */
        setContentView(R.layout.view_switcher_test);
        inflater = LayoutInflater.from(this);
        for (int i = 0; i < 40; i++) {
            String label = "jfq" + i;
//            Drawable drawable = getResources().getDrawable(R.drawable.libai);
            Drawable drawable = ResourcesCompat.getDrawable(
                    getResources(),
                    R.drawable.libai,
                    null);
            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }

        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size() / NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN + 1;
        switcher = findViewById(R.id.viewSwitcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });

        // 加载第一屏
        next(null);
    }

    public void next(View v) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            switcher.setInAnimation(this, R.anim.slide_in_right);
            switcher.setOutAnimation(this, R.anim.slide_out_left);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }
    }

    public void prev(View v) {
        if (screenNo > 0) {
            screenNo--;
            switcher.setInAnimation(this, R.anim.slide_out_left);
            switcher.setOutAnimation(this, R.anim.slide_in_right);
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            int ret = NUMBER_PER_SCREEN;

            if (screenNo == screenCount - 1) {
                if (items.size() % NUMBER_PER_SCREEN != 0) {
                    ret = items.size() % NUMBER_PER_SCREEN;
                }
            }

            return ret;
        }

        @Override
        public DataItem getItem(int position) {
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                view = inflater.inflate(R.layout.labelicon, null);
            }
            ImageView imageView = view.findViewById(R.id.labelicon_imageview);
            TextView tv = view.findViewById(R.id.labelicon_textview);
            imageView.setImageDrawable(getItem(position).drawable);
            tv.setText(getItem(position).dataName);
            return view;

//            return null;
        }
    };

}

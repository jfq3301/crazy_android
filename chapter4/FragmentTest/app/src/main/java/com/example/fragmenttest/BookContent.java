package com.example.fragmenttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BookContent {
    public static class Book {
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        public String toString() {
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer, Book> ITEM_MAP
            = new HashMap<Integer, Book>();

    static {
        addItem(new Book(1, "疯狂java讲义",
            "一本java语言编程书籍。"));
        addItem(new Book(2, "疯狂android讲义",
                "一本android app开发指南书籍。"));
        addItem(new Book(3, "轻量级java ee企业应用实战",
                "介绍java ee开发的struts 2, spring, hibernate 4."));
    }

    public static void addItem(Book book) {
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }
}
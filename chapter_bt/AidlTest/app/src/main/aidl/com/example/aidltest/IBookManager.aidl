// IBookManager.aidl
package com.example.aidltest;

import com.example.aidltest.Book;
import com.example.aidltest.IOnNewBookArrivedListener;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getListBook();
    void addBook(in Book book);
    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}

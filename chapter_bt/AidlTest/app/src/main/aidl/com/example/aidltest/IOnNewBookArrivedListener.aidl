// IOnNewBookArrivedListener.aidl
package com.example.aidltest;


// Declare any non-default types here with import statements
import com.example.aidltest.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}

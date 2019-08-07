package com.example.aidltest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.content.ServiceConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "[jfq]: " + MainActivity.class.getSimpleName();
    private static final int MESSAGE_NEW_BOOK_ARRIVED = 1;

    TextView mTvBookList;
    private IBookManager mRemoteBookManager;
    private IOnNewBookArrivedListener mListener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            Log.d(TAG, "[jfq]new book arrived.");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvBookList = findViewById(R.id.main_tv_book_list);
        Log.d(TAG, "[jfq]onCreate.");
    }

    @Override protected void onDestroy() {
        if (mRemoteBookManager != null && mRemoteBookManager.asBinder().isBinderAlive()) {
            try {
                Log.e(TAG, "解除注册");
                mRemoteBookManager.unregisterListener(mListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        try {
            unbindService(mConnection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public void bindService1(View v) {
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    public void getBookList(View v) {

    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "[jfq]onServiceConnected.");
            IBookManager bookManager = IBookManager.Stub.asInterface(service);
            try {
                Log.e(TAG, "onServiceConnected");
                mRemoteBookManager = bookManager;
                Book newBook = new Book(3, "毛泽东传");
                bookManager.addBook(newBook);
                bookManager.registerListener(mListener);
                Log.e(TAG, "onServiceConnected finished.");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mRemoteBookManager = null;
            Log.e(TAG, "onServiceDisconnected");
        }
    };


}

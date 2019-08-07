package com.example.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class BookManagerService extends Service {

    private static final String TAG = "[jfq]: " + BookManagerService.class.getSimpleName();

    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();
    private RemoteCallbackList<IOnNewBookArrivedListener> mListenerList = new RemoteCallbackList<>();
    private AtomicBoolean mIsServerDestoryed = new AtomicBoolean(false);

    private Binder mBinder = new IBookManager.Stub() {
        @Override
        public List<Book> getListBook() throws RemoteException {
            Log.e(TAG, "getListBook before");
            SystemClock.sleep(5000);
            Log.e(TAG, "getListBook after");
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }

        @Override
        public void registerListener(IOnNewBookArrivedListener listener) throws RemoteException {
            mListenerList.register(listener);
            int num = mListenerList.beginBroadcast();
            mListenerList.finishBroadcast();
            Log.e(TAG, "registerListener, num: " + num);
        }

        @Override
        public void unregisterListener(IOnNewBookArrivedListener listener) throws RemoteException {
            mListenerList.unregister(listener);
            int num = mListenerList.beginBroadcast();
            mListenerList.finishBroadcast();
            Log.e(TAG, "unregisterListener, num: " + num);
        }
    };

    public BookManagerService() {
    }

    private int mNum=0;

    private class WorkerServer implements Runnable {

        @Override
        public void run() {
            while (!mIsServerDestoryed.get()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mNum++;
                if (mNum == 100) {
                    mIsServerDestoryed.set(true);
                }
                Message msg = new Message();
                mHandler.sendMessage(msg);

            }
        }
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            int bookId = 1 + mBookList.size();
            Book newBook = new Book(bookId, "新书#" + bookId);
            try {
                onNewBookArrived(newBook);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    private void onNewBookArrived(Book book) throws RemoteException {
        mBookList.add(book);
        Log.e(TAG, "new book arrived, " + book);
        Log.e(TAG, "book list size:  " + mBookList.size());

        int num = mListenerList.beginBroadcast();
        for (int i = 0; i < num; i++) {
            IOnNewBookArrivedListener listener = mListenerList.getBroadcastItem(i);
            Log.e(TAG, "send msg to " + listener.toString());
            listener.onNewBookArrived(book);
        }
        mListenerList.finishBroadcast();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "[jfq] service onCreate.");
        mBookList.add(new Book(1, "android"));
        mBookList.add(new Book(2, "ios"));
        new Thread(new WorkerServer()).start();
    }

    @Override
    public void onDestroy() {
        mIsServerDestoryed.set(true);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }


}

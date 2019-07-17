package com.example.btchat;


import android.app.ActionBar;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.logger.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class BluetoothChatFragment extends Fragment {

    private static final String TAG = "BluetoothChatFragment";

    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
    private static final int REQUEST_ENABLE_BT = 3;


    private ListView mConversationView;
    private EditText mOutEditText;
    private Button mSendButton;

    private String mConnectedDeviceName = null;
    private ArrayAdapter<String> mConversationArrayAdapter;
    // StringBuffer: thread safe
    // StringBuilder: thread unsafe.
    private StringBuffer mOutStringBuffer;

    private BluetoothAdapter mBluetoothAdapter = null;
    private BluetoothChatService mChatService = null;

    public BluetoothChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            FragmentActivity activity = getActivity();
            Toast.makeText(activity, "Bluetooth is not available", Toast.LENGTH_SHORT);
            activity.finish();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bluetooth_chat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mConversationView = view.findViewById(R.id.in);
        mOutEditText = view.findViewById(R.id.edit_text_out);
        mSendButton = view.findViewById(R.id.button_send);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (!mBluetoothAdapter.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, REQUEST_ENABLE_BT);
        } else if (mChatService == null) {
            setupChat();
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        if (mChatService != null) {
            if (mChatService.getState() == BluetoothChatService.STATE_NONE) {
                mChatService.start();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mChatService != null) {
            mChatService.stop();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case REQUEST_CONNECT_DEVICE_INSECURE:
                if (requestCode == Activity.RESULT_OK) {
                    connectDevice(data, false);
                }
                break;
            case REQUEST_CONNECT_DEVICE_SECURE:
                if (requestCode == Activity.RESULT_OK) {
                    connectDevice(data, true);
                }
                break;
            case REQUEST_ENABLE_BT:
                if (resultCode == Activity.RESULT_OK) {
                    setupChat();
                } else {
                    Log.d(TAG, "BT not enable.");
                    Toast.makeText(getActivity(), "bt not enabled leaving", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
                break;
        }
    }

    private void connectDevice(Intent intent, boolean secure) {
        String address = intent.getExtras()
                .getString(DeviceListActivity.EXTRA_DEVICE_ADDRESS);
        BluetoothDevice device = mBluetoothAdapter.getRemoteDevice(address);
        mChatService.connect(device, secure);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.bluetooth_chat, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean ret = false;

        switch (item.getItemId()) {
            case R.id.secure_connect_scan:
            {
                Intent intent = new Intent(getActivity(), DeviceListActivity.class);
                startActivityForResult(intent, REQUEST_CONNECT_DEVICE_SECURE);
                ret = true;
            }
            case R.id.insecure_connect_scan:
            {
                Intent intent = new Intent(getActivity(), DeviceListActivity.class);
                startActivityForResult(intent, REQUEST_CONNECT_DEVICE_INSECURE);
                ret = true;
            }
            case R.id.discoverable:
            {
                ensureDiscoverable();
                ret = true;
            }
        }

        return ret;
    }


    private void setupChat() {
        Log.d(TAG, "setupChat");

        mConversationArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.message);
        mConversationView.setAdapter(mConversationArrayAdapter);
        mOutEditText.setOnEditorActionListener(mWriteListener);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getView();
                if (null != view) {
                    TextView tv = (TextView) view.findViewById(R.id.edit_text_out);
                    String msg = tv.getText().toString();
                    sendMsg(msg);
                }
            }
        });
        mChatService = new BluetoothChatService(getActivity(), mHandler);
        mOutStringBuffer = new StringBuffer("");
    }

    private void sendMsg(String msg) {
        if (mChatService.getState() != BluetoothChatService.STATE_CONNECTED) {
            Toast.makeText(getActivity(), R.string.not_connected, Toast.LENGTH_SHORT).show();
            return;
        }

        if (msg.length() > 0) {
            byte[] send = msg.getBytes();
            mChatService.write(send);

            mOutStringBuffer.setLength(0);
            mOutEditText.setText(mOutStringBuffer);
        }
    }

    private TextView.OnEditorActionListener mWriteListener =
            new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_NULL && event.getAction() == KeyEvent.ACTION_UP) {
                        String msg = v.getText().toString();
                        sendMsg(msg);
                    }
                    return true;
                }
    };

    private void setStatus(int resId) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }

        final ActionBar actionBar = activity.getActionBar();
        if (null  == actionBar) {
            return;
        }

        actionBar.setSubtitle(resId);
    }

    private void setStatus(CharSequence subTitle) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }

        final ActionBar actionBar = activity.getActionBar();
        if (null  == actionBar) {
            return;
        }

        actionBar.setSubtitle(subTitle);
    }

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            FragmentActivity activity = getActivity();
            switch (msg.what) {
                case Constants.MESSAGE_STATE_CHANGE:
                    switch (msg.arg1) {
                        case BluetoothChatService.STATE_CONNECTED:
                            setStatus(R.string.title_connected_to);
                            mConversationArrayAdapter.clear();
                            break;
                        case BluetoothChatService.STATE_CONNECTING:
                            setStatus(R.string.title_connecting);
                            break;
                        case BluetoothChatService.STATE_LISTEN:
                        case BluetoothChatService.STATE_NONE:
                            setStatus(R.string.title_not_connected);
                            break;
                    }
                    break;
                case Constants.MESSAGE_READ: {
                    byte[] buf = (byte[]) msg.obj;
                    String msg1 = new String(buf);
                    mConversationArrayAdapter.add(mConnectedDeviceName + ": " + msg1);
                    break;
                }

                case Constants.MESSAGE_WRITE: {
                    byte[] buf = (byte[]) msg.obj;
                    String msg1 = new String(buf);
                    mConversationArrayAdapter.add("Me: " + msg1);
                    break;
                }
                case Constants.MESSAGE_DEVICE_NAME:
                    mConnectedDeviceName = msg.getData().getString(Constants.DEVICE_NAME);
                    if (activity != null) {
                        Toast.makeText(activity, "Connected to " +
                                mConnectedDeviceName, Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Constants.MESSAGE_TOAST:
                    if (activity != null) {
                        Toast.makeText(activity, msg.getData().getString(Constants.TOAST), Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };

    private void ensureDiscoverable() {
        if (mBluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE)
        {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(intent);
        }
    }
}



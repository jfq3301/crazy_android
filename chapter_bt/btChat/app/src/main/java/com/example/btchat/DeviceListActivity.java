package com.example.btchat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.common.logger.Log;

import java.util.Set;

public class DeviceListActivity extends Activity {
    private static final String TAG = "DeviceListActivity";
    public static String EXTRA_DEVICE_ADDRESS = "device_address";
    private BluetoothAdapter mBtAdapter;
    private ArrayAdapter<String> mNewDevicesArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_device_list);

        setResult(Activity.RESULT_CANCELED);
        Button scanButton = findViewById(R.id.button_scan);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doDiscovery();
                v.setVisibility(View.GONE);
            }
        });

        ArrayAdapter<String> pairedDeviceAdapter = new ArrayAdapter<String>(
                this, R.layout.device_name);
        mNewDevicesArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.device_name);

        ListView pairedLv = findViewById(R.id.paired_devices);
        pairedLv.setAdapter(pairedDeviceAdapter);
        pairedLv.setOnItemSelectedListener(mDeviceClickListner);

        ListView newLv = findViewById(R.id.new_devices);
        newLv.setAdapter(mNewDevicesArrayAdapter);
        newLv.setOnItemSelectedListener(mDeviceClickListner);

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        this.registerReceiver(mReciever, filter);

        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReciever, filter);

        mBtAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDev = mBtAdapter.getBondedDevices();

        if (pairedDev.size() > 0) {
            findViewById(R.id.title_paired_devices).setVisibility(View.VISIBLE);
            for (BluetoothDevice dev : pairedDev) {
                pairedDeviceAdapter.add(dev.getName() + "\n" + dev.getAddress());
            }
        } else {
            String noDev = getResources().getText(R.string.none_paired).toString();
            pairedDeviceAdapter.add(noDev);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBtAdapter != null) {
            mBtAdapter.cancelDiscovery();
        }
        this.unregisterReceiver(mReciever);
    }

    private void doDiscovery()
    {
        Log.d(TAG, "doDiscovery");

        setProgressBarIndeterminateVisibility(true);
        setTitle(R.string.scanning);

        findViewById(R.id.title_new_devices).setVisibility(View.VISIBLE);
        if (mBtAdapter.isDiscovering())
        {
            mBtAdapter.cancelDiscovery();
        }
        mBtAdapter.startDiscovery();
    }

    private AdapterView.OnItemSelectedListener mDeviceClickListner = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            mBtAdapter.cancelDiscovery();
            String info = ((TextView)view).getText().toString();
            String address = info.substring(info.length() - 17);

            Intent intent =  new Intent();
            intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
            setResult(Activity.RESULT_OK, intent);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private final BroadcastReceiver mReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                Log.d(TAG, "ACTION_FOUND");
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                    mNewDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                setProgressBarIndeterminateVisibility(false);
                Log.d(TAG, "ACTION_DISCOVERY_FINISHED");
                setTitle(R.string.select_device);
                if (mNewDevicesArrayAdapter.getCount() == 0) {
                    String noDev = getResources().getText(R.string.none_paired).toString();
                    mNewDevicesArrayAdapter.add(noDev);
                }
            }
        }
    };

}

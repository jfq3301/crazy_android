package com.example.minibrowser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    WebView show;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url = findViewById(R.id.url);
        show = findViewById(R.id.show);
        btnGo = findViewById(R.id.gogo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlStr = url.getText().toString();
                show.loadUrl(urlStr);
            }
        });

        show.setWebViewClient(new WebViewClient() {

//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_ENTER) {
//            String urlStr = url.getText().toString();
//            show.loadUrl(urlStr);
//            return true;
//        }
//
//        return false;
//    }
}

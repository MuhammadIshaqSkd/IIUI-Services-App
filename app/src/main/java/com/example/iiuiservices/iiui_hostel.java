package com.example.iiuiservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class iiui_hostel extends AppCompatActivity {
    private WebView webView;
    private ProgressBar spinner;

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iiui_hostel);

        getSupportActionBar().hide();

        //////////////////////check internet connection start-1//////////////////////////
        broadcastReceiver = new ConnectionReceiver();
        register();
        //////////////////////check internet connection end-1//////////////////////////


        webView = findViewById(R.id.webs);
        spinner = (ProgressBar) findViewById(R.id.progressBar1);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new callBack());

        webView.loadUrl("http://usis.iiu.edu.pk:64453/");
    }

    //////////////////////check internet connection start-2//////////////////////////

    public void register(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
    //////////////////////check internet connection end-2//////////////////////////

    public class callBack extends WebViewClient{
        @Override
        public void onPageStarted(WebView webview, String url, Bitmap favicon) {
            webview.setVisibility(webview.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {

            spinner.setVisibility(View.GONE);

            view.setVisibility(webView.VISIBLE);
            super.onPageFinished(view, url);

        }
//        public boolean shouldOverrideUrlLoading(WebView view, KeyEvent event) {
//            return false;
//    }
}
}
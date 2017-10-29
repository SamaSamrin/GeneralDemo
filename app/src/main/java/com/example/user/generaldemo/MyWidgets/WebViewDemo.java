package com.example.user.generaldemo.MyWidgets;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.user.generaldemo.R;

public class WebViewDemo extends Activity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);

        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        String url = "https://www.google.com.bd/";
        MyClient client = new MyClient();
        client.shouldOverrideUrlLoading(webView, url);
        webView.setWebViewClient(new MyClient());
        webView.loadUrl(url);
    }
}

class MyClient extends WebViewClient{

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
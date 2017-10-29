package com.example.user.generaldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.user.generaldemo.MyWidgets.WebViewDemo;

public class WidgetsClass extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets_class);
    }

    public void goToWebviewDemo(View v){
        Intent intent = new Intent(WidgetsClass.this, WebViewDemo.class);
        startActivity(intent);
    }
}

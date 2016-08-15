package com.xwray.fontbindingsample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xwray.fontbinding.FontCache;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FontCache.getInstance(this).addFont("alegreya", "Alegreya-Regular.ttf");

        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}

package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mydemo.reflect.InjectUtils;
import com.example.mydemo.reflect.onClick;


public class MainActivity extends AppCompatActivity {

    @onClick(R.id.tv_hello)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InjectUtils.inject(this);
        textView.setText("dog");

    }
}

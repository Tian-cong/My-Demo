package com.example.mydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        URI uri = URI.create("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584902974896&di=b57b7719e1bd7285f0096d0ceb23be3c&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F21%2F09%2F01200000026352136359091694357.jpg");

        ImageView imageView = findViewById(R.id.iv_qqq);
        Glide.with(this).load(uri).into(imageView);


    }





}

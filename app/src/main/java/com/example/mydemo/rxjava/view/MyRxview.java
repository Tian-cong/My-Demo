package com.example.mydemo.rxjava.view;

import android.view.View;

import io.reactivex.Observable;

public class MyRxview {

    private static final String TAG = "MyRxview";

    public static Observable click(View view) {
        return new ViewClickObservable(view);
    }


}

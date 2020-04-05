package com.example.mydemo.rxjava.view;

import android.os.Looper;
import android.view.View;

import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

class ViewClickObservable extends Observable {

    private final View view;
    public static final Object EVENT = new Object();

    public ViewClickObservable(View view) {
        this.view = view;
    }


    @Override
    protected void subscribeActual(Observer observer) {

        MyListener listener = new MyListener(view, observer);
        observer.onSubscribe(listener);
        view.setOnClickListener(listener);

    }

    private static final class MyListener implements Disposable, View.OnClickListener {

        private final View view;
        private final Observer observer;

        private final AtomicBoolean isDisposable = new AtomicBoolean();

        public MyListener(View view, Observer observer) {
            this.view = view;
            this.observer = observer;
        }

        @Override
        public void onClick(View v) {
            if (!isDisposed()) {
                observer.onNext(EVENT);
            }

        }

        @Override
        public void dispose() {
            if (isDisposable.compareAndSet(false, true)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    view.setOnClickListener(null);
                } else {
                    AndroidSchedulers.mainThread().scheduleDirect(() -> {
                        view.setOnClickListener(null);
                    });
                }
            }
        }

        @Override
        public boolean isDisposed() {
            return isDisposable.get();
        }
    }
}

package com.example.mydemo.rxjava;


import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Single<T> 只发射单个数据或错误事件。
 */

public class MySingle {


    public static void main(String[] args) {

        Single<String> single = Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(SingleEmitter<String> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onSuccess("success 666");
                }
            }
        });

        Single<String> single1 = Single.create(emitter -> {
            if (!emitter.isDisposed()) {
                emitter.onSuccess("success 666");
                emitter.onError(new Throwable());
            }
        });

        SingleObserver singleObserver = new SingleObserver() {
            @Override
            public void onSubscribe(Disposable d) {

                System.out.println(d.isDisposed());

            }

            @Override
            public void onSuccess(Object o) {
                System.out.println("onSuccess  "+o);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.toString());
            }
        };

        single1.subscribe(singleObserver);

        single.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("single" + s);
            }
        });


    }
}

package com.example.mydemo.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class MyColdRxjava {

    /**
     * subscribe 订阅
     * observable 可观察的
     * emitter 发射器
     */


    public static void main(String[] args) {
        Observable<Long> observable = Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                Observable.interval(10, TimeUnit.MILLISECONDS,
                        Schedulers.computation())
                        .take(Integer.MAX_VALUE)
                        .subscribe(emitter::onNext);
            }
        }).observeOn(Schedulers.newThread()).publish();

        //lambda
        Observable<Long> observable1 = Observable.create(emitter -> {
            Observable.interval(10, TimeUnit.MILLISECONDS,
                    Schedulers.computation())
                    .take(Integer.MAX_VALUE)
                    .subscribe(emitter::onNext);
        });

        /**
         *
         * publish
         *  加这俩方法转换冷和热
         * connect
         */

        ((ConnectableObservable<Long>) observable).connect();

        ConnectableObservable<String> connectableObservable = (ConnectableObservable) Observable.create(emitter -> {
            emitter.onNext("ssss");
        }).observeOn(Schedulers.newThread()).publish();

        connectableObservable.connect();


        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("consumer1   " + aLong);
            }
        });

        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("     consumer2    " + aLong);
            }
        });

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("               consumer3  " + aLong);
            }
        });


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

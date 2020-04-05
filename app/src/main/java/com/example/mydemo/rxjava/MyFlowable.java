package com.example.mydemo.rxjava;

import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.schedulers.Schedulers;

public class MyFlowable {

    public static void main(String[] args) {

        Flowable flowable = Flowable.create(new FlowableOnSubscribe<Object>() {
            @Override
            public void subscribe(FlowableEmitter<Object> emitter) throws Exception {

            }
        }, BackpressureStrategy.MISSING);
        flowable.subscribeOn(Schedulers.io())
                .subscribe(new FlowableSubscriber() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(Object o) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}

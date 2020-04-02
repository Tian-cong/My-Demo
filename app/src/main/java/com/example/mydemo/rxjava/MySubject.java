package com.example.mydemo.rxjava;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;


public class MySubject {

    public static void main(String[] args) {

//        asyncSubject();
        BehaviorSubject();
    }

    /**
     * 无论订阅发生在什么时候，只发射最后一个数据
     */
    public static void asyncSubject() {

        AsyncSubject<String> asyncSubject = AsyncSubject.create();

        asyncSubject.onNext("haha");
        asyncSubject.onNext("xixi");

//        asyncSubject.subscribe(s -> {
//
//        });

        asyncSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        asyncSubject.onNext("666");
        asyncSubject.onNext("777");
        asyncSubject.onComplete();

    }

    /**
     * 发送订阅之前的一个数据和订阅之后的全部数据
     */
    public static void BehaviorSubject() {
        BehaviorSubject behaviorSubject = BehaviorSubject.create();

        behaviorSubject.onNext("11111");
        behaviorSubject.onNext("22222");

        behaviorSubject.subscribe(o -> {
            System.out.println(o);
        });

        behaviorSubject.onNext("3333");
        behaviorSubject.onNext("444");

    }

    /**
     * 无论订阅发生在什么时候，都发射全部数据
     */
    public static void ReplaySubject() {
        ReplaySubject subject = ReplaySubject.create();
        subject.onNext("11111");
        subject.onNext("22222");

        subject.subscribe(o -> {
            System.out.println(o);
        });

        subject.onNext("3333");
        subject.onNext("444");

    }

    /**
     * 发送订阅之后全部数据
     */

    public static void PublishSubject() {
        PublishSubject subject = PublishSubject.create();

        subject.onNext("11111");
        subject.onNext("22222");

        subject.subscribe(o -> {
            System.out.println(o);
        });

        subject.onNext("3333");
        subject.onNext("444");

    }


}

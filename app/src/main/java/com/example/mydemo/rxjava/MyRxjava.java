package com.example.mydemo.rxjava;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * subscribe 订阅
 * observable 可观察的（被观察者）
 * observer 观察着
 * emitter 发射器
 * disposable 一次性的
 */

/**
 * Observable<T> 能够发射0或n个数据，并以成功或错误事件终止
 */
public class MyRxjava {


    /**
     * Lambda 表达式
     */

//    Observable observable = Observable.create(emitter -> {
//        if(emitter.isDisposed()) {
//            emitter.onNext("哈哈哈");
//            emitter.onNext("666");
//        }
//        emitter.onComplete();
//    });
    public static void main(String[] args) {

        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext(111);
                    emitter.onNext(Integer.valueOf("222"));
                }
                emitter.onComplete();
            }
        });

        Observable observable2 = Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext("hello rxjava2");
                    emitter.onNext("小伙伴们，你们好");
                }
                emitter.onComplete();
            }
        });

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable " + d);
                d.dispose();
            }

            @Override
            public void onNext(Object o) {
                System.out.println("onNext " + o);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Throwable " + e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        observable.map(o -> {
            return o;
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

        observable2.debounce(new Function() {
            @Override
            public Object apply(Object o) throws Exception {
                return null;
            }
        });


    }

}

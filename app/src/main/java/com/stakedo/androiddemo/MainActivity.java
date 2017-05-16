package com.stakedo.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Observable.defer(() ->  Observable.just(getNum()))
          Observable.just("one")
                .doOnNext(it->{
                    Log.d(TAG, it);
                })
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnNext(it->{
                    Log.d(TAG, it);
                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .map(it->{
                    Log.d(TAG, it);
                    return it;
                })

                .doOnNext(it->{
                    Log.d(TAG, it);
                })
//                .observeOn(Schedulers.newThread())
                .subscribe(it->{
                    Log.d(TAG, it);
                });

//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        Subject<Object> subject = PublishSubject.create().toSerialized();
//        final int[] i = {0};
//        subject.subscribe(o -> {
//            Log.d(TAG, list.get(i[0]));
//            i[0]++;
//        });
//
//        subject.onNext("");
//        subject.onComplete();
//        subject.onNext("");


    }


   public String getNum(){
       return "one";
   }

}

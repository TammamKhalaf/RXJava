package com.tammamkhalaf.rxnerds;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.core.Observable;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Long> cold = Observable.intervalRange(0,5,0,1, TimeUnit.SECONDS);

        cold.subscribe(i-> Log.i(TAG, "onCreate: student 1 "+i));

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            Log.i(TAG, "InterruptedException");
        }


        cold.subscribe(i-> Log.i(TAG, "onCreate: student 2 "+i));

    }
}
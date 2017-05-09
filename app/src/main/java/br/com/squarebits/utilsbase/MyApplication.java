package br.com.squarebits.utilsbase;

import android.app.Application;

import com.github.rrsystems.utilsplus.android.UtilsPlus;

/**
 * Created by Luan on 09/05/17.
 */

public class MyApplication extends Application {

    private static MyApplication sInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        UtilsPlus.initialize(getApplicationContext());
        UtilsPlus.initialize(getApplicationContext(), "my_preference");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

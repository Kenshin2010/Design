package com.manroid.examplemvp;

import android.app.Application;
import android.content.Context;

/**
 * Created by manro on 29/09/2017.
 */

public class App extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        this.context = this;
        super.onCreate();

    }

    public static Context getContext() {
        return context;
    }
}
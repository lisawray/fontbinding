package com.xwray.fontbinding;

import android.content.Context;

/**
 * I finally broke down and made an Application class to access the application context.
 */
public class Application extends android.app.Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        Application.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return Application.context;
    }
}

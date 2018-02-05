package com.google.firebase.codelab.friendlychat;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Logger;

import timber.log.Timber;

/**
 * Created by Hasnain Baxamoosa on 2/5/2018.
 */

public class FriendlyChatApplication extends android.app.Application {
    private static Context context;

    public static Context getAppContext() {
        return FriendlyChatApplication.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        /*
         * set Firebase database disk persistence to TRUE
         */
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        FriendlyChatApplication.context = getApplicationContext();


        if (BuildConfig.DEBUG) {

            //Including Jake Wharton's Timber logging library
            Timber.plant(new Timber.DebugTree());
            Timber.v("Timber.plant(new Timber.DebugTree());");

            /*
             * set Firebase database LOGGER level to DEBUG
            */
            FirebaseDatabase.getInstance().setLogLevel(Logger.Level.DEBUG);

        } else {
            // Timber.plant(new CrashReportingTree());
        }

        // Facebook Stetho
        Stetho.initializeWithDefaults(this);
    }
}

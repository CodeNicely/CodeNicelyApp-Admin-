package com.codenicely.project.groceryappadmin.helper;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


/**
 * Created by meghal on 23/10/16.
 */

public class MyApplication extends Application {

    private static Context context;
    private static String fcm;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //     FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/comfortaa.ttf");
        //    FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/homemade.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/itim.ttf");
        //    FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/patrick_hand.ttf");

        fcm = FirebaseInstanceId.getInstance().getToken();

    }

    public static String getFcm() {

        fcm = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG, "Fcm is " + fcm);
        return fcm;
    }

    public static Context getContext() {
        return context;
    }


}

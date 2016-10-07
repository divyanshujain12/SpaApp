package com.example.lenovo.SpaApp;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.lenovo.SpaApp.AppIntro.AppIntroActivity;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mInstance;
    private static Context context;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    public static SharedPreferences preference;

    public MyApplication() {

    }

    MyApplication(Context context) {
        MyApplication.context = context;

        mRequestQueue = getRequestQueue();
        preference = getSharedPreferences("BookingApp", MODE_PRIVATE);


        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }


    public static synchronized MyApplication getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new MyApplication(context);

        }
        MyApplication.context = context;
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(mInstance).deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        req.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        req.setRetryPolicy(new DefaultRetryPolicy(15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level > TRIM_MEMORY_MODERATE || level>=TRIM_MEMORY_COMPLETE) {
            // Restart app so data is reloaded
            android.os.Process.killProcess(android.os.Process.myPid());

        }

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}


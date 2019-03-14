package com.assignment.teo;

import com.assignment.teo.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import timber.log.Timber;
import timber.log.Timber.DebugTree;

/**
 * Main class of the application.
 */

public class MyApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder()
                .app(this)
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initTimber();
    }

    private void initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
    }

}
package com.assignment.teo.di;

import android.app.Application;

import com.assignment.teo.MyApplication;
import com.assignment.teo.di.builders.ActivityBindingModule;
import com.assignment.teo.di.modules.ApplicationModule;
import com.assignment.teo.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Dagger component.
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBindingModule.class,
        ApplicationModule.class,
        NetworkModule.class})
public interface ApplicationComponent extends AndroidInjector<MyApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder app(Application application);

        ApplicationComponent build();
    }

}

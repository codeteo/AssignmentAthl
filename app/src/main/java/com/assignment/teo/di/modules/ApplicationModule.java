package com.assignment.teo.di.modules;

import android.app.Application;
import android.content.Context;

import com.assignment.teo.Constants;
import com.assignment.teo.data.preferences.SharedPreferencesManagerImpl;
import com.assignment.teo.utils.BaseUrlInterceptor;
import com.assignment.teo.utils.NetworkUtils;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;
import com.assignment.teo.utils.schedulers.SchedulerProvider;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Dagger Module with application(singleton) scoped dependencies.
 */

@Module
public abstract class ApplicationModule {

    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL);

    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Singleton
    static SharedPreferencesManagerImpl provideSharedPreferences(Application application) {
        return new SharedPreferencesManagerImpl(application);
    }

    @Provides
    @Singleton
    static HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

    @Provides
    @Singleton
    static BaseUrlInterceptor providesBaseUrlInterceptor(HttpUrl baseUrl) {
        return new BaseUrlInterceptor(baseUrl.toString());
    }

    @Provides
    @Singleton
    @Named(API_KEY)
    static String providesApiKey() {
        return Constants.API_KEY;
    }

    @Provides
    @Singleton
    static NetworkUtils providesNetworkUtils(Context context) {
        return new NetworkUtils(context);
    }

    @Provides
    @Singleton
    static BaseSchedulerProvider providesBaseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }
}

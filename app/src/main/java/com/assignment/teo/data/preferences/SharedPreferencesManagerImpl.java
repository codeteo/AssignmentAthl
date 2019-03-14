package com.assignment.teo.data.preferences;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesManagerImpl implements SharedPreferencesManager {

    private SharedPreferences preferences;

    public SharedPreferencesManagerImpl(Application application) {
        preferences = PreferenceManager.getDefaultSharedPreferences(application);
    }

}

package com.assignment.teo.features.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.assignment.teo.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import timber.log.Timber;

public class SearchActivity extends AppCompatActivity implements SearchMVP.View {

    @Inject
    SearchMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void showMessage(String message) {
        Timber.i("SHOW MESSAGE");
    }
}

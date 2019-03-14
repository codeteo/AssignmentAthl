package com.assignment.teo.di.builders;

import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.features.search.SearchActivity;
import com.assignment.teo.features.search.di.SearchActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = SearchActivityModule.class)
    abstract SearchActivity bindSearchActivity();
}

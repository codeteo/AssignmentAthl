package com.assignment.teo.features.search.fragments.shows.di;

import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.features.search.fragments.shows.ShowsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ShowsListFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = {ShowsListDataModule.class, ShowsListPresenterModule.class})
    abstract ShowsListFragment providesShowsListFragment();

}


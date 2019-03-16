package com.assignment.teo.features.search.fragments.movies.di;

import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MoviesListFragmentBuilder {

    @ContributesAndroidInjector(modules = MoviesListDataModule.class)
    abstract MoviesListFragment providesMoviesListFragment();

}

package com.assignment.teo.features.search.fragments.movies.di;

import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MoviesListFragmentBuilder {

    @FragmentScope
    @ContributesAndroidInjector(modules = {MoviesListDataModule.class, MoviesListPresenterModule.class})
    abstract MoviesListFragment providesMoviesListFragment();

}

package com.assignment.teo.features.search.fragments.movies.di;

import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;
import com.assignment.teo.features.search.fragments.movies.MoviesListMVP;
import com.assignment.teo.features.search.fragments.movies.MoviesListPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Module which provides presenter for movies list feature.
 */

@Module
abstract class MoviesListPresenterModule {

    @FragmentScope
    @Binds
    abstract MoviesListMVP.View providesPopularFragment(MoviesListFragment fragment);

    @FragmentScope
    @Binds
    abstract MoviesListMVP.Presenter providesSearchMoviesPresenter(MoviesListPresenter presenter);

}

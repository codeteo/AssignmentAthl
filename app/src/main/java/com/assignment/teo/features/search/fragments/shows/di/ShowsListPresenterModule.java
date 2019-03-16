package com.assignment.teo.features.search.fragments.shows.di;

import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.features.search.fragments.shows.ShowsListFragment;
import com.assignment.teo.features.search.fragments.shows.ShowsListMVP;
import com.assignment.teo.features.search.fragments.shows.ShowsListPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Module which provides presenter for shows list feature.
 */

@Module
abstract class ShowsListPresenterModule {

    @FragmentScope
    @Binds
    abstract ShowsListMVP.View providesShowsListFragment(ShowsListFragment fragment);

    @FragmentScope
    @Binds
    abstract ShowsListMVP.Presenter providesShowsListPresenter(ShowsListPresenter presenter);

}


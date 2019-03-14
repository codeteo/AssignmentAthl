package com.assignment.teo.features.search.di;

import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.features.search.SearchActivity;
import com.assignment.teo.features.search.SearchMVP;
import com.assignment.teo.features.search.SearchPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Dagger module for {@link SearchActivity}.
 */

@Module
public abstract class SearchActivityModule {

    @ActivityScope
    @Binds
    abstract SearchMVP.Presenter providesSearchPresenter(SearchPresenter presenter);

    @ActivityScope
    @Binds
    abstract SearchMVP.View providesSearchActivity(SearchActivity activity);

}

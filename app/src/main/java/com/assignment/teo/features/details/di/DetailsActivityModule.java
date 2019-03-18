package com.assignment.teo.features.details.di;

import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.features.details.DetailsActivity;
import com.assignment.teo.features.details.DetailsMVP;
import com.assignment.teo.features.details.DetailsPresenter;
import com.assignment.teo.features.search.SearchActivity;

import dagger.Binds;
import dagger.Module;

/**
 * Dagger module for {@link SearchActivity}.
 */

@Module
public abstract class DetailsActivityModule {

    @ActivityScope
    @Binds
    abstract DetailsMVP.Presenter providesDetailsPresenter(DetailsPresenter presenter);

    @ActivityScope
    @Binds
    abstract DetailsMVP.View providesDetailsActivity(DetailsActivity activity);

}


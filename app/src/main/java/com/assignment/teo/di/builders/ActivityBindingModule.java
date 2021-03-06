package com.assignment.teo.di.builders;

import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.features.details.DetailsActivity;
import com.assignment.teo.features.details.di.DetailsActivityModule;
import com.assignment.teo.features.details.di.DetailsDataModule;
import com.assignment.teo.features.search.SearchActivity;
import com.assignment.teo.features.search.di.SearchActivityModule;
import com.assignment.teo.features.search.fragments.movies.di.MoviesListFragmentBuilder;
import com.assignment.teo.features.search.fragments.shows.di.ShowsListFragmentBuilder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
            modules = {
                    SearchActivityModule.class,
                    MoviesListFragmentBuilder.class,
                    ShowsListFragmentBuilder.class}
    )
    abstract SearchActivity bindSearchActivity();

    @ActivityScope
    @ContributesAndroidInjector(
            modules = {
                    DetailsActivityModule.class,
                    DetailsDataModule.class
            }
    )
    abstract DetailsActivity bindDetailsActivity();

}

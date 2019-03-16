package com.assignment.teo.features.search.fragments.movies;

import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.domain.SearchMoviesUseCase;

import javax.inject.Inject;

import timber.log.Timber;

@FragmentScope
public class MoviesListPresenter implements MoviesListMVP.Presenter {

    private SearchMoviesUseCase searchMovies;
    private MoviesListMVP.View view;

    @Inject
    MoviesListPresenter(SearchMoviesUseCase searchMovies, MoviesListMVP.View view) {
        this.searchMovies = searchMovies;
        this.view = view;
    }

    @Override
    public void onSearchMovies(String queryText) {
//        searchMovies.getMovies()
        Timber.i("PRESENTER - SEARCH - STRING %s", queryText);
    }
}

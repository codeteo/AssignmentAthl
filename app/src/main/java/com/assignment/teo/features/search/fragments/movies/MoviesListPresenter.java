package com.assignment.teo.features.search.fragments.movies;

import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.domain.SearchMoviesUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

@FragmentScope
public class MoviesListPresenter implements MoviesListMVP.Presenter {

    private SearchMoviesUseCase searchMovies;
    private MoviesListMVP.View view;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    MoviesListPresenter(SearchMoviesUseCase searchMovies, MoviesListMVP.View view) {
        this.searchMovies = searchMovies;
        this.view = view;
    }

    @Override
    public void onSearchMovies(String queryText) {
        disposable.add(
            searchMovies.getMovies(queryText)
                .subscribe(
                        movies -> view.showMovies(movies),
                        throwable -> Timber.i("THROWABLE: %s", throwable.getCause())));
    }

    @Override
    public void unsubscribe() {
        searchMovies.unsubscribe();

        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }

}

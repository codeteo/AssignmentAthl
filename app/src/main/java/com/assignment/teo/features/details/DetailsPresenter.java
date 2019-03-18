package com.assignment.teo.features.details;

import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.domain.GetGenresUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@ActivityScope
public class DetailsPresenter implements DetailsMVP.Presenter {

    private GetGenresUseCase fetchGenres;
    private DetailsMVP.View view;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public DetailsPresenter(GetGenresUseCase fetchGenres, DetailsMVP.View view) {
        this.fetchGenres = fetchGenres;
        this.view = view;
    }

    @Override
    public void onLoadMovieGenre() {
        disposable.add(
            fetchGenres
                .getMovieGenres()
                .subscribe(genres -> {}, throwable -> {}));
    }

    @Override
    public void onLoadShowGenre() {
        disposable.add(
            fetchGenres
                .getShowGenres()
                .subscribe(genres -> {}, throwable -> {}));
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }
}

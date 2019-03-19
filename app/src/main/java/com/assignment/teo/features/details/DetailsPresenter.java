package com.assignment.teo.features.details;

import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.domain.GetGenresUseCase;
import com.assignment.teo.domain.entities.Genre;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

@ActivityScope
public class DetailsPresenter implements DetailsMVP.Presenter {

    private GetGenresUseCase fetchGenres;
    private DetailsMVP.View view;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    DetailsPresenter(GetGenresUseCase fetchGenres, DetailsMVP.View view) {
        this.fetchGenres = fetchGenres;
        this.view = view;
    }

    @Override
    public void onLoadMovieGenre(int genreId) {
        disposable.add(
            fetchGenres
                .getMovieGenres()
                .subscribe(
                        genres -> findGenre(genreId, genres),
                        throwable -> {}));
    }

    @Override
    public void onLoadShowGenre(int genreId) {
        disposable.add(
            fetchGenres
                .getShowGenres()
                .subscribe(
                        genres -> findGenre(genreId, genres),
                        throwable -> {}));
    }

    private void findGenre(int genreId, List<Genre> genres) {
        if (genres != null && !genres.isEmpty()) {
            for (Genre genre: genres) {
                if (genre.getId() == genreId) {
                    view.showGenre(genre);
                }
            }
        }
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }
}

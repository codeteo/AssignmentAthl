package com.assignment.teo.domain;

import com.assignment.teo.domain.entities.Genre;
import com.assignment.teo.domain.repository.GenresRepository;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link GetGenresUseCase} that
 * represents a use case for retrieving a list of genres.
 */

public class GetGenresUseCaseImpl implements GetGenresUseCase {

    private GenresRepository repository;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public GetGenresUseCaseImpl(GenresRepository repository, BaseSchedulerProvider schedulerProvider) {
        this.repository = repository;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Observable<List<Genre>> getMovieGenres() {
        return repository.executeMovieGenres()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @Override
    public Observable<List<Genre>> getShowGenres() {
        return repository.executeShowGenres()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

}

package com.assignment.teo.domain;

import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.domain.repository.MoviesRepository;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * This class is an implementation of {@link SearchMoviesUseCase} that
 * represents a use case for retrieving a list of movies.
 */
public class SearchMoviesUseCaseImpl implements SearchMoviesUseCase {

    private MoviesRepository repository;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public SearchMoviesUseCaseImpl(MoviesRepository repository, BaseSchedulerProvider schedulerProvider) {
        this.repository = repository;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public Observable<List<Movie>> getMovies(String queryText) {
        return repository.execute(queryText)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }
}

package com.assignment.teo.data.repository;

import android.support.annotation.NonNull;

import com.assignment.teo.data.features.search.movies.entities.MovieDataModel;
import com.assignment.teo.data.features.search.movies.entities.MoviesSearchResponse;
import com.assignment.teo.data.features.search.movies.mappers.MovieDataMapper;
import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.domain.repository.MoviesRepository;
import com.assignment.teo.domain.repository.sources.MoviesDataSource;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;

public class MoviesDataRepository implements MoviesRepository {

    private MoviesDataSource dataSource;
    private BaseSchedulerProvider schedulerProvider;
    private MovieDataMapper mapper;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    public MoviesDataRepository(MoviesDataSource dataSource,
                                BaseSchedulerProvider schedulerProvider,
                                MovieDataMapper mapper) {
        this.dataSource = dataSource;
        this.schedulerProvider = schedulerProvider;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<Movie>> execute(String queryText) {
        return dataSource.movies(queryText)
                .map(mapsResponseToDomainModel())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @NonNull
    private Function<MoviesSearchResponse, List<Movie>> mapsResponseToDomainModel() {
        return dataModels -> {

            List<Movie> domainModels = new ArrayList<>();
            for (MovieDataModel dataModel : dataModels.getMovies()) {
                domainModels.add(mapper.transform(dataModel));
            }

            return domainModels;
        };
    }


    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }
}

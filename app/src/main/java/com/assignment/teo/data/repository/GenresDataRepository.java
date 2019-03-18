package com.assignment.teo.data.repository;

import android.support.annotation.NonNull;

import com.assignment.teo.data.features.search.genres.entities.GenreDataModel;
import com.assignment.teo.data.features.search.genres.entities.GenresResponse;
import com.assignment.teo.data.features.search.genres.mappers.GenreDataMapper;
import com.assignment.teo.domain.entities.Genre;
import com.assignment.teo.domain.repository.GenresRepository;
import com.assignment.teo.domain.repository.sources.GenresDataSource;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class GenresDataRepository implements GenresRepository {

    private GenresDataSource dataSource;
    private BaseSchedulerProvider schedulerProvider;
    private GenreDataMapper mapper;

    @Inject
    public GenresDataRepository(GenresDataSource dataSource,
                                BaseSchedulerProvider schedulerProvider, GenreDataMapper mapper) {
        this.dataSource = dataSource;
        this.schedulerProvider = schedulerProvider;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<Genre>> executeMovieGenres() {
        return dataSource.movieGenres()
                .map(mapsResponseToDomainModel())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @Override
    public Observable<List<Genre>> executeShowGenres() {
        return dataSource.showGenres()
                .map(mapsResponseToDomainModel())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @NonNull
    private Function<GenresResponse, List<Genre>> mapsResponseToDomainModel() {
        return dataModels -> {

            List<Genre> domainModels = new ArrayList<>();
            for (GenreDataModel dataModel : dataModels.getGenres()) {
                domainModels.add(mapper.transform(dataModel));
            }

            return domainModels;
        };
    }

}

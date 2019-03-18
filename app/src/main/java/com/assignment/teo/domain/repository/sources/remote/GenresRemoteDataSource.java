package com.assignment.teo.domain.repository.sources.remote;

//public interface GenresRemoteDataSource {

import com.assignment.teo.data.features.search.genres.GenresService;
import com.assignment.teo.data.features.search.genres.entities.GenresResponse;
import com.assignment.teo.domain.repository.sources.GenresDataSource;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Implementation of a data source that fetches data from
 * the network.
 */

public class GenresRemoteDataSource implements GenresDataSource {

    private GenresService service;
    private String apiKey;

    @Inject
    public GenresRemoteDataSource(GenresService service, @Named(API_KEY) String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<GenresResponse> movieGenres() {
        return service.getMovieGenres(apiKey);
    }

    @Override
    public Observable<GenresResponse> showGenres() {
        return service.getShowGenres(apiKey);
    }
}


package com.assignment.teo.domain.repository.sources.remote;

import com.assignment.teo.data.features.search.movies.MoviesSearchService;
import com.assignment.teo.data.features.search.movies.entities.MoviesSearchResponse;
import com.assignment.teo.domain.repository.sources.MoviesDataSource;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Implementation of a data source that fetches data from
 * the network.
 */

public class MoviesRemoteDataSource implements MoviesDataSource {

    private MoviesSearchService service;
    private String apiKey;

    @Inject
    public MoviesRemoteDataSource(MoviesSearchService service,
                                 @Named(API_KEY) String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<MoviesSearchResponse> movies(String queryText) {
        return service.searchMovies(apiKey, queryText, "false", "en-us");
    }
}

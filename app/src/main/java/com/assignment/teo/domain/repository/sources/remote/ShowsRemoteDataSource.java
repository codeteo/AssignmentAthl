package com.assignment.teo.domain.repository.sources.remote;

import com.assignment.teo.data.features.search.shows.ShowsSearchService;
import com.assignment.teo.data.features.search.shows.entities.ShowsSearchResponse;
import com.assignment.teo.domain.repository.sources.ShowsDataSource;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Implementation of a data source that fetches data from
 * the network.
 */

public class ShowsRemoteDataSource implements ShowsDataSource {

    private ShowsSearchService service;
    private String apiKey;

    @Inject
    public ShowsRemoteDataSource(ShowsSearchService service,
                                 @Named(API_KEY) String apiKey) {
        this.service = service;
        this.apiKey = apiKey;
    }

    @Override
    public Observable<ShowsSearchResponse> shows(String queryText) {
        return service.searchShows(apiKey, queryText);
    }
}


package com.assignment.teo.domain.repository.sources;

import com.assignment.teo.data.features.search.movies.entities.MovieDataModel;
import com.assignment.teo.data.features.search.movies.entities.MoviesSearchResponse;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */

public interface MoviesDataSource {

    /**
     * Get an {@link Observable} which will emit a List of {@link MovieDataModel}s.
     *
     * @param queryText user's search string.
     */
    Observable<MoviesSearchResponse> movies(String queryText);

}

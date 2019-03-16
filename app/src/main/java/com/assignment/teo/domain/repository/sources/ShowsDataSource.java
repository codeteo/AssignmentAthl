package com.assignment.teo.domain.repository.sources;

import com.assignment.teo.data.features.search.shows.entities.ShowDataModel;
import com.assignment.teo.data.features.search.shows.entities.ShowsSearchResponse;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */

public interface ShowsDataSource {

    /**
     * Get an {@link Observable} which will emit a List of {@link ShowDataModel}s.
     *
     * @param queryText user's search string.
     */
    Observable<ShowsSearchResponse> shows(String queryText);

}


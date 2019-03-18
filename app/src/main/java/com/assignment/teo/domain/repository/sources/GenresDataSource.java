package com.assignment.teo.domain.repository.sources;

import com.assignment.teo.data.features.search.genres.entities.GenreDataModel;
import com.assignment.teo.data.features.search.genres.entities.GenresResponse;

import io.reactivex.Observable;

/**
 * Interface that represents a data store from where data is retrieved.
 */

public interface GenresDataSource {

    /**
     * Get an {@link Observable} which will emit a List of {@link GenreDataModel}s.
     */
    Observable<GenresResponse> movieGenres();

    /**
     * Get an {@link Observable} which will emit a List of {@link GenreDataModel}s.
     */
    Observable<GenresResponse> showGenres();

}


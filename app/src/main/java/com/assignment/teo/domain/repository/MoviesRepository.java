package com.assignment.teo.domain.repository;


import com.assignment.teo.domain.entities.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesRepository {

    /**
     * Get an {@link Observable} which will emit a List of {@link Movie}s.
     */
    Observable<List<Movie>> execute(String queryText);

    /**
     * Remove RxJava subscriptions.
     */
    void unsubscribe();

}

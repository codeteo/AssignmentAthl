package com.assignment.teo.domain.repository;

import com.assignment.teo.domain.entities.Genre;

import java.util.List;

import io.reactivex.Observable;

public interface GenresRepository {

    /**
     * Get an {@link Observable} which will emit a list of movie {@link Genre}s.
     */
    Observable<List<Genre>> executeMovieGenres();

    /**
     * Get an {@link Observable} which will emit a list of TV show {@link Genre}s.
     */
    Observable<List<Genre>> executeShowGenres();

}


package com.assignment.teo.domain;

import com.assignment.teo.domain.entities.Genre;

import java.util.List;

import io.reactivex.Observable;

/**
 * Interactor for getting list of genres.
 */

public interface GetGenresUseCase {

    Observable<List<Genre>> getMovieGenres();

    Observable<List<Genre>> getShowGenres();

}



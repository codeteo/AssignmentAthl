package com.assignment.teo.domain;

import com.assignment.teo.domain.entities.Movie;
import java.util.List;
import io.reactivex.Observable;

/**
 * Interactor for getting searched movies.
 */

public interface SearchMoviesUseCase {

    Observable<List<Movie>> getMovies();

    void unsubscribe();
}

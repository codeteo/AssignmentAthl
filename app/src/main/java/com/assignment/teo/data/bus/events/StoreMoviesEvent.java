package com.assignment.teo.data.bus.events;

import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;
import com.assignment.teo.utils.RetainedFragment;

import java.util.List;

/**
 * Event class to pass movies from {@link MoviesListFragment} to
 * {@link RetainedFragment}.
 * <p>
 * This is because we need the list of movies to survive configuration
 * changes.
 */

public class StoreMoviesEvent {

    private List<Movie> movies;

    public StoreMoviesEvent(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}

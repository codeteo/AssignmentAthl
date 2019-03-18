package com.assignment.teo.features.search.fragments.movies.adapter;

import com.assignment.teo.domain.entities.Movie;

import static com.assignment.teo.Constants.EMPTY_STRING;

/**
 * ViewModel for the movie view in {@link MoviesAdapter}.
 */

public final class MovieViewModel {

    private Movie movie;

    public MovieViewModel(Movie movie) {
        this.movie = movie;
    }

    public String getTitle() {
        return movie.getTitle() == null ? EMPTY_STRING : movie.getTitle();
    }

    public String getOverview() {
        return movie.getOverview();
    }

    public String getThumbnail() {
        return movie.getThumbnail();
    }

    public int getRating() {
        return movie.getRating();
    }

    public String getReleaseDate() {
        return movie.getReleaseDate();
    }

    public int getGenreId() {
        return movie.getGenreIds()[0];
    }

}
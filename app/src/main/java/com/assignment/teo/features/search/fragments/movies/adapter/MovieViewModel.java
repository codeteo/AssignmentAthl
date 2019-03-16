package com.assignment.teo.features.search.fragments.movies.adapter;

import com.assignment.teo.domain.entities.Movie;

/**
 * ViewModel for the movie view in {@link MoviesAdapter}.
 */

public final class MovieViewModel {

    private Movie movie;

    public MovieViewModel(Movie movie) {
        this.movie = movie;
    }

    public String getTitle() {
        if (movie.getTitle() == null) {
            return "";
        } else {
            return movie.getTitle();
        }
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

}
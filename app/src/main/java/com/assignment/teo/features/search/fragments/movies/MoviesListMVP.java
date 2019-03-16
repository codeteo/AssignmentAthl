package com.assignment.teo.features.search.fragments.movies;

import com.assignment.teo.domain.entities.Movie;

import java.util.List;

/**
 *  Contract interface between View and Presenter for movies list feature.
 */

public interface MoviesListMVP {

    interface View {

        void showsMovies(List<Movie> movies);

    }

    interface Presenter {

        void onSearchMovies(String queryText);

        void unsubscribe();

    }

}

package com.assignment.teo.data.features.search.movies.mappers;

import com.assignment.teo.common.mapper.Mapper;
import com.assignment.teo.data.features.search.movies.entities.MovieDataModel;
import com.assignment.teo.domain.entities.Movie;

import javax.inject.Inject;

/**
 * Mapper class to transform data from the data layer ({@link MovieDataModel})
 * to objects in the domain layer ({@link Movie}).
 */

public class MovieDataMapper implements Mapper<MovieDataModel, Movie> {

    @Inject
    MovieDataMapper() {
        // required for constructor injection
    }

    @Override
    public Movie transform(MovieDataModel dataModel) {

        Movie movie = new Movie();

        movie.setTitle(dataModel.getTitle());
        movie.setOverview(dataModel.getOverview());
        movie.setRating(Math.round(dataModel.getVoteAverage()));
        movie.setThumbnail(dataModel.getBackdropPath());
        movie.setReleaseDate(dataModel.getReleaseDate());
        movie.setGenreIds(dataModel.getGenreIds());

        return movie;
    }
}

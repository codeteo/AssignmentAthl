package com.assignment.teo.data.features.search.genres.mappers;

import com.assignment.teo.common.mapper.Mapper;
import com.assignment.teo.data.features.search.genres.entities.GenreDataModel;
import com.assignment.teo.domain.entities.Genre;

import javax.inject.Inject;

/**
 * Mapper class to transform data from the data layer ({@link GenreDataModel})
 * to objects in the domain layer ({@link Genre}).
 */

public class GenreDataMapper implements Mapper<GenreDataModel, Genre> {

    @Inject
    GenreDataMapper() {
        // required for constructor injection
    }

    @Override
    public Genre transform(GenreDataModel dataModel) {

        Genre genre = new Genre();
        genre.setId(dataModel.getId());
        genre.setName(dataModel.getName());

        return genre;
    }
}


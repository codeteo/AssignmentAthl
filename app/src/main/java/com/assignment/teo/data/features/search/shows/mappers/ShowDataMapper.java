package com.assignment.teo.data.features.search.shows.mappers;

import com.assignment.teo.common.mapper.Mapper;
import com.assignment.teo.data.features.search.shows.entities.ShowDataModel;
import com.assignment.teo.domain.entities.Show;

import javax.inject.Inject;

/**
 * Mapper class to transform data from the data layer ({@link ShowDataModel})
 * to items in the domain layer ({@link Show}).
 */

public class ShowDataMapper implements Mapper<ShowDataModel, Show> {

    @Inject
    ShowDataMapper() {
        // required for constructor injection
    }

    @Override
    public Show transform(ShowDataModel showDataModel) {
        return null;
    }
}



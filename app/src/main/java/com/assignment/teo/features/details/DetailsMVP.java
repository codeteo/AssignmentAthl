package com.assignment.teo.features.details;

import com.assignment.teo.domain.entities.Genre;

/**
 * Contract class used for details feature {@link DetailsActivity}.
 */

public interface DetailsMVP {

    interface View {

        void showGenre(Genre genre);

    }

    interface Presenter {

        void onLoadMovieGenre(int genreId);

        void onLoadShowGenre(int genreId);

        void unsubscribe();

    }

}

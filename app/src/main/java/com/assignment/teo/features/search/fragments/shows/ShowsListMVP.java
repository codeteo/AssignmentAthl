package com.assignment.teo.features.search.fragments.shows;

import com.assignment.teo.domain.entities.Show;

import java.util.List;

/**
 *  Contract interface between View and Presenter for TV shows list feature.
 */

public interface ShowsListMVP {

    interface View {

        void showTvShows(List<Show> shows);

    }

    interface Presenter {

        void onSearchShows(String queryText);

        void unsubscribe();

    }

}


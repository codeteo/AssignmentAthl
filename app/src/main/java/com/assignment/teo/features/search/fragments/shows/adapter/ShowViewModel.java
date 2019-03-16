package com.assignment.teo.features.search.fragments.shows.adapter;

import com.assignment.teo.domain.entities.Show;

import static com.assignment.teo.Constants.EMPTY_STRING;

/**
 * ViewModel for the TV Show view in {@link ShowsAdapter}.
 */

public final class ShowViewModel {

    private Show show;

    public ShowViewModel(Show show) {
        this.show = show;
    }

    public String getTitle() {
        return show.getTitle() == null ? EMPTY_STRING : show.getTitle();
    }

    public String getOverview() {
        return show.getOverview();
    }

    public String getThumbnail() {
        return show.getThumbnail();
    }

    public int getRating() {
        return show.getRating();
    }

}

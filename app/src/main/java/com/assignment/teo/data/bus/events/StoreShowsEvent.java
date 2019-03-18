package com.assignment.teo.data.bus.events;

import com.assignment.teo.domain.entities.Show;
import com.assignment.teo.features.search.fragments.shows.ShowsListFragment;
import com.assignment.teo.utils.RetainedFragment;

import java.util.List;

/**
 * Event class to pass shows from {@link ShowsListFragment} to
 * {@link RetainedFragment}.
 * <p>
 * This is because we need the list of movies to survive configuration
 * changes.
 */

public class StoreShowsEvent {

    private List<Show> shows;

    public StoreShowsEvent(List<Show> shows) {
        this.shows = shows;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}


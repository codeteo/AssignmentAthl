package com.assignment.teo.utils;

import android.os.Bundle;

import com.assignment.teo.common.base.BaseFragment;
import com.assignment.teo.data.bus.events.StoreMoviesEvent;
import com.assignment.teo.data.bus.events.StoreShowsEvent;
import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.domain.entities.Show;
import com.squareup.otto.Subscribe;

import java.util.List;

public class RetainedFragment extends BaseFragment {

    public static final String RETAINED_FRAGMENT_TAG = "retained_tag";

    private List<Movie> movies;
    private List<Show> shows;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Subscribe
    public void onMoviesDataEvent(StoreMoviesEvent event) {
        this.movies = event.getMovies();
    }

    @Subscribe
    public void onShowsDataEvent(StoreShowsEvent event) {
        this.shows = event.getShows();
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}

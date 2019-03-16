package com.assignment.teo.features.search.fragments.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.assignment.teo.data.bus.events.QueryTextChangeEvent;
import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.features.search.base.BaseTabFragment;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Displays list of movies in search screen.
 */

public class MoviesListFragment extends BaseTabFragment implements MoviesListMVP.View {

    @Inject
    MoviesListMVP.Presenter presenter;

    public static MoviesListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MoviesListFragment fragment = new MoviesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Subscribe
    public void onQueryTextChanged(QueryTextChangeEvent event) {

    }

    @Override
    public void showsMovies(List<Movie> movies) {

    }
}

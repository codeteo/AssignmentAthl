package com.assignment.teo.features.search.fragments.movies;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseFragment;
import com.assignment.teo.data.bus.events.QueryTextChangeEvent;
import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.features.search.SearchActivity;
import com.assignment.teo.features.search.fragments.movies.adapter.MoviesAdapter;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Displays list of movies in search screen.
 */

public class MoviesListFragment extends BaseFragment implements MoviesListMVP.View {

    private RecyclerView recyclerView;

    @Inject
    MoviesListMVP.Presenter presenter;

    private MoviesAdapter adapter;

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
    public View onCreateView(@NonNull LayoutInflater inflater,
                                  @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);

        initViews(view);

        if (savedInstanceState != null) {
            showMovies(((SearchActivity) getActivity()).getMovies());
        }

        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.unsubscribe();
        }
    }

    @Subscribe
    public void onQueryTextChanged(QueryTextChangeEvent event) {
        if (adapter != null) {
            adapter.clearDataset();
        }

        presenter.onSearchMovies(event.getQueryText());
    }

    @Override
    public void showMovies(List<Movie> movies) {
        if (isAdded()) {
            if (adapter == null) {
                adapter = new MoviesAdapter(movies, getActivity());
            } else {
                adapter.setDataset(movies);
            }
            recyclerView.setAdapter(adapter);
        }
    }
}

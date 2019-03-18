package com.assignment.teo.features.search.fragments.shows;

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
import com.assignment.teo.domain.entities.Show;
import com.assignment.teo.features.search.SearchActivity;
import com.assignment.teo.features.search.fragments.shows.adapter.ShowsAdapter;
import com.squareup.otto.Subscribe;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Displays list of shows in search screen.
 */

public class ShowsListFragment extends BaseFragment implements ShowsListMVP.View {

    private RecyclerView recyclerView;

    @Inject
    ShowsListMVP.Presenter presenter;

    private ShowsAdapter adapter;

    public static ShowsListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ShowsListFragment fragment = new ShowsListFragment();
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
    public android.view.View onCreateView(@NonNull LayoutInflater inflater,
                                          @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shows_list, container, false);

        initViews(view);

        if (savedInstanceState != null) {
            showTvShows(((SearchActivity) getActivity()).getShows());
        }

        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_shows);
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

        presenter.onSearchShows(event.getQueryText());
    }

    @Override
    public void showTvShows(List<Show> shows) {
        if (isAdded()) {
            if (adapter == null) {
                adapter = new ShowsAdapter(shows, getActivity());
            } else {
                adapter.setDataset(shows);
            }
            recyclerView.setAdapter(adapter);
        }
    }
}

package com.assignment.teo.features.search.fragments.movies;

import android.os.Bundle;

import com.assignment.teo.features.search.base.BaseTabFragment;

/**
 * Displays list of movies in search screen.
 */

public class MoviesListFragment extends BaseTabFragment {

    public static MoviesListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MoviesListFragment fragment = new MoviesListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
}

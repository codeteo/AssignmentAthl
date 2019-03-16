package com.assignment.teo.features.search.fragments.shows;

import android.os.Bundle;

import com.assignment.teo.features.search.base.BaseTabFragment;

/**
 * Displays list of shows in search screen.
 */

public class ShowsListFragment extends BaseTabFragment {

    public static ShowsListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ShowsListFragment fragment = new ShowsListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
}

package com.assignment.teo.features.search;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.assignment.teo.features.search.base.BaseTabFragment;
import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;
import com.assignment.teo.features.search.fragments.shows.ShowsListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for Tabs in {@link SearchActivity}.
 */

class SearchTabAdapter extends FragmentStatePagerAdapter {

    private static final int NUM_OF_TABS = 2;
    private final List<BaseTabFragment> fragmentList = new ArrayList<>();

    SearchTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
                return MoviesListFragment.newInstance();
            case 1 :
                return ShowsListFragment.newInstance();
            default:
                return MoviesListFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return NUM_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 :
                return "MOVIES";
            case 1 :
                return "SHOWS";
            default:
                return "MOVIES";
        }
    }

    void addFragment(BaseTabFragment fragment, String title) {
        fragmentList.add(fragment);
    }

}
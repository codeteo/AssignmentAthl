package com.assignment.teo.features.search;

import com.assignment.teo.di.scopes.ActivityScope;

import javax.inject.Inject;

/**
 * Presenter for {@link SearchActivity}
 */

@ActivityScope
public class SearchPresenter implements SearchMVP.Presenter {

    private SearchMVP.View view;

    @Inject
    SearchPresenter(SearchMVP.View view) {
        this.view = view;
    }

}

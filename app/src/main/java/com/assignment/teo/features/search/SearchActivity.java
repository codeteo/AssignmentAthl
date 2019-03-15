package com.assignment.teo.features.search;

import android.os.Bundle;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseTransitionActivity;
import com.assignment.teo.features.search.views.SearchBar;
import com.assignment.teo.widgets.transitions.FadeInTransition;
import com.assignment.teo.widgets.transitions.FadeOutTransition;
import com.assignment.teo.widgets.transitions.SimpleTransitionListener;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import timber.log.Timber;

public class SearchActivity extends BaseTransitionActivity
        implements SearchMVP.View , SearchBar.SimpleToolbarCallback {

    private SearchBar searchbar;

    @Inject
    SearchMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(searchbar);

        searchbar.setActivityListener(this);

        if (isFirstTimeRunning(savedInstanceState)) {
            searchbar.hideContent();

            ViewTreeObserver viewTreeObserver = searchbar.getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    searchbar.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    showSearch();
                }

                private void showSearch() {
                    TransitionManager.beginDelayedTransition(searchbar, FadeInTransition.createTransition());
                    searchbar.showContent();
                }
            });
        }
    }

    private boolean isFirstTimeRunning(Bundle savedInstanceState) {
        return savedInstanceState == null;
    }

    public void finish() {
        hideKeyboard();

        exitTransitionWithAction(() -> {
            SearchActivity.super.finish();

            overridePendingTransition(0, 0);
        });
    }

    private void exitTransitionWithAction(final Runnable endingAction) {

        Transition transition = FadeOutTransition.withAction(new SimpleTransitionListener() {
            @Override
            public void onTransitionEnd(Transition transition) {
                endingAction.run();
            }
        });

        TransitionManager.beginDelayedTransition(searchbar, transition);
        searchbar.hideContent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.action_clear) {
            searchbar.clearText();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMessage(String message) {
        Timber.i("SHOW MESSAGE");
    }

    @Override
    public void onTextChanged(String text) {
        Timber.i("SEARCH-ACTIVITY TEXT: %s", text);
        // TODO: 15/3/2019 Call presenter to initiate network request
    }
}

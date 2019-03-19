package com.assignment.teo.features.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import com.assignment.teo.R;
import com.assignment.teo.data.bus.BusProvider;
import com.assignment.teo.data.bus.events.OpenDetailsActivityEvent;
import com.assignment.teo.data.bus.events.QueryTextChangeEvent;
import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.domain.entities.Show;
import com.assignment.teo.features.details.DetailsActivity;
import com.assignment.teo.features.search.base.BaseSearchActivity;
import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;
import com.assignment.teo.features.search.fragments.shows.ShowsListFragment;
import com.assignment.teo.features.search.views.SearchBar;
import com.assignment.teo.utils.RetainedFragment;
import com.assignment.teo.widgets.transitions.FadeInTransition;
import com.assignment.teo.widgets.transitions.FadeOutTransition;
import com.assignment.teo.widgets.transitions.SimpleTransitionListener;
import com.squareup.otto.Subscribe;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import static com.assignment.teo.Constants.EMPTY_STRING;
import static com.assignment.teo.features.details.DetailsActivity.GENRE_ID_INTENT_KEY;
import static com.assignment.teo.features.details.DetailsActivity.IMG_URL_INTENT_KEY;
import static com.assignment.teo.features.details.DetailsActivity.OVERVIEW_INTENT_KEY;
import static com.assignment.teo.features.details.DetailsActivity.TITLE_INTENT_KEY;
import static com.assignment.teo.features.details.DetailsActivity.TYPE_ENUM_INTENT_KEY;
import static com.assignment.teo.utils.RetainedFragment.RETAINED_FRAGMENT_TAG;

public class SearchActivity extends BaseSearchActivity
        implements SearchMVP.View , SearchBar.SimpleToolbarCallback, HasSupportFragmentInjector {

    private static final String MOVIES_TITLE = "MOVIES";
    private static final String SHOWS_TITLE = "SHOWS";

    public static final String SEARCH_STRING_LAST_VALUE_KEY = "last_value_key";

    private SearchBar searchbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    SearchMVP.Presenter presenter;

    private RetainedFragment retainedFragment;

    private String lastSearchedString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(searchbar);

        viewPager = findViewById(R.id.viewpager);
        setUpViewPager(viewPager, savedInstanceState);

        if (isFirstTimeRunning(savedInstanceState)) {
            retainedFragment = new RetainedFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(retainedFragment, RETAINED_FRAGMENT_TAG)
                    .commit();
        } else {

            lastSearchedString = savedInstanceState
                    .getString(SEARCH_STRING_LAST_VALUE_KEY, EMPTY_STRING);

            retainedFragment = (RetainedFragment) getSupportFragmentManager()
                    .findFragmentByTag(RETAINED_FRAGMENT_TAG);
        }

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

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

    private void setUpViewPager(ViewPager viewPager, Bundle savedInstanceState) {
        SearchTabAdapter adapter = new SearchTabAdapter(getSupportFragmentManager());

        if (isFirstTimeRunning(savedInstanceState)) {
            adapter.addFragment(MoviesListFragment.newInstance());
            adapter.addFragment(ShowsListFragment.newInstance());
        } else {
            adapter.addFragment((MoviesListFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, MOVIES_TITLE));
            adapter.addFragment((ShowsListFragment) getSupportFragmentManager()
                    .getFragment(savedInstanceState, SHOWS_TITLE));
        }

        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SEARCH_STRING_LAST_VALUE_KEY, lastSearchedString);
    }

    /**
     * Receives the search text and sends it with an event to movies and shows
     * Fragments.
     * Also it compares the text with the last saved search string and in case
     * they are equal then it's probably a configuration change so there is no
     * need to notify the two Fragments.
     */
    @Override
    public void onTextChanged(String text) {
        if (!lastSearchedString.equals(text)) {
            lastSearchedString = text;
            BusProvider.getInstance().post(new QueryTextChangeEvent(text));
        }
    }

    @NonNull
    public List<Movie> getMovies() {
        if (retainedFragment.getMovies() != null) {
            return retainedFragment.getMovies();
        } else {
            return Collections.emptyList();
        }
    }

    @NonNull
    public List<Show> getShows() {
        if (retainedFragment.getShows() != null) {
            return retainedFragment.getShows();
        } else {
            return Collections.emptyList();
        }
    }

    @Subscribe
    public void onOpenDetailsScreenEvent(OpenDetailsActivityEvent event) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(TITLE_INTENT_KEY, event.getTitle());
        intent.putExtra(IMG_URL_INTENT_KEY, event.getImageUrl());
        intent.putExtra(OVERVIEW_INTENT_KEY, event.getOverview());
        intent.putExtra(GENRE_ID_INTENT_KEY, event.getGenreId());
        intent.putExtra(TYPE_ENUM_INTENT_KEY, event.getType());
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}

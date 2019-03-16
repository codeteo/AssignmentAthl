package com.assignment.teo.features.search;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseTransitionActivity;
import com.assignment.teo.data.bus.BusProvider;
import com.assignment.teo.data.bus.events.QueryTextChangeEvent;
import com.assignment.teo.features.search.fragments.movies.MoviesListFragment;
import com.assignment.teo.features.search.fragments.shows.ShowsListFragment;
import com.assignment.teo.features.search.views.SearchBar;
import com.assignment.teo.widgets.transitions.FadeInTransition;
import com.assignment.teo.widgets.transitions.FadeOutTransition;
import com.assignment.teo.widgets.transitions.SimpleTransitionListener;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

public class SearchActivity extends BaseTransitionActivity
        implements SearchMVP.View , SearchBar.SimpleToolbarCallback, HasSupportFragmentInjector {

    private SearchBar searchbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Inject
    SearchMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchbar = findViewById(R.id.search_toolbar);
        setSupportActionBar(searchbar);

        viewPager = findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

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

    private void setUpViewPager(ViewPager viewPager) {
        SearchTabAdapter adapter = new SearchTabAdapter(getSupportFragmentManager());

        adapter.addFragment(MoviesListFragment.newInstance(), "MOVIES");
        adapter.addFragment(ShowsListFragment.newInstance(), "SHOWS");

        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
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
        BusProvider.getInstance().post(new QueryTextChangeEvent(text));
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentInjector;
    }
}

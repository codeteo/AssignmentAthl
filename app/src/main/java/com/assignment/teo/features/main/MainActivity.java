package com.assignment.teo.features.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.transition.Transition;
import android.support.transition.TransitionManager;
import android.widget.FrameLayout;

import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseTransitionActivity;
import com.assignment.teo.features.main.views.SimpleToolbar;
import com.assignment.teo.features.search.SearchActivity;
import com.assignment.teo.widgets.transitions.FadeInTransition;
import com.assignment.teo.widgets.transitions.FadeOutTransition;
import com.assignment.teo.widgets.transitions.SimpleTransitionListener;

/**
 * Main screen.
 */

public class MainActivity extends BaseTransitionActivity {

    private SimpleToolbar toolbar;
    private int toolbarMargin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        toolbarMargin = getResources().getDimensionPixelSize(R.dimen.toolbar_margin);
        toolbar.setOnClickListener(v -> {
            showKeyboard();
            transitionToSearch();
        });
    }


    private void transitionToSearch() {
        Transition transition = FadeOutTransition.withAction(navigateToSearchWhenDone());

        TransitionManager.beginDelayedTransition(toolbar, transition);
        FrameLayout.LayoutParams frameLP = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
        frameLP.setMargins(0, 0, 0, 0);
        toolbar.setLayoutParams(frameLP);
        toolbar.hideContent();
    }


    private Transition.TransitionListener navigateToSearchWhenDone() {
        return new SimpleTransitionListener() {
            @Override
            public void onTransitionEnd(Transition transition) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);

                overridePendingTransition(0, 0);
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

        fadeToolbarIn();
    }

    private void fadeToolbarIn() {
        TransitionManager.beginDelayedTransition(toolbar, FadeInTransition.createTransition());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
        layoutParams.setMargins(toolbarMargin, toolbarMargin, toolbarMargin, toolbarMargin);
        toolbar.showContent();
        toolbar.setLayoutParams(layoutParams);
    }

}

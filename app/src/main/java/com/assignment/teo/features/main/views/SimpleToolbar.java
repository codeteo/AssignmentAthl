package com.assignment.teo.features.main.views;

import android.content.Context;
import android.util.AttributeSet;

import com.assignment.teo.R;
import com.assignment.teo.widgets.TransformingToolbar;

/**
 * A white Toolbar with a Search icon as Up.
 */

public class SimpleToolbar extends TransformingToolbar {

    public SimpleToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(context.getResources().getColor(android.R.color.white));
        setNavigationIcon(R.drawable.ic_action_search);
    }
}
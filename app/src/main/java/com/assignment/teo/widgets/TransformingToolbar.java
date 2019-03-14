package com.assignment.teo.widgets;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;

/**
 * A Toolbar that knows how to hide and show its children.
 */
public class TransformingToolbar extends Toolbar {

    public TransformingToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Sets the Visibility of all children to GONE
     */
    public void hideContent() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(GONE);
        }
    }

    /**
     * Sets the Visibility of all children to VISIBLE
     */
    public void showContent() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(VISIBLE);
        }
    }

}
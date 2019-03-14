package com.assignment.teo.features.search.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.assignment.teo.R;
import com.assignment.teo.widgets.TransformingToolbar;

/**
 * A Toolbar with an EditText used for searching.
 */

public class SearchBar extends TransformingToolbar {

    private EditText editText;

    public SearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(context.getResources().getColor(android.R.color.white));
        setNavigationIcon(R.drawable.ic_action_back);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        inflate(getContext(), R.layout.merge_search, this);
        editText = findViewById(R.id.toolbar_search_edittext);
    }

    @Override
    public void showContent() {
        super.showContent();
        editText.requestFocus();
    }

    public void clearText() {
        editText.setText(null);
    }

}
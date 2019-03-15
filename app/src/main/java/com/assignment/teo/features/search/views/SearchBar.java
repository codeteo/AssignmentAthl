package com.assignment.teo.features.search.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.assignment.teo.R;
import com.assignment.teo.features.main.views.SimpleToolbar;
import com.assignment.teo.widgets.TransformingToolbar;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * A Toolbar with an EditText used for searching.
 */

public class SearchBar extends TransformingToolbar {

    /**
     * Callback interface to be implemented by {@link SimpleToolbar}'s
     * host Activity. It's used to communicate user's search strings to
     * the Activity.
     */
    public interface SimpleToolbarCallback {
        void onTextChanged(String text);
    }

    private SimpleToolbarCallback callback;

    public void setActivityListener(SimpleToolbarCallback listener) {
        callback = listener;
    }

    private EditText editText;
    private Disposable disposable;

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

        disposable = RxTextView.textChanges(editText)
                .skip(1)
                .debounce(200, TimeUnit.MILLISECONDS)
                .distinct()
                .filter(text -> !text.toString().isEmpty())
                .map(CharSequence::toString)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Timber.i("SEARCH: %s", s);
                    callback.onTextChanged(s);
                });

    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
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
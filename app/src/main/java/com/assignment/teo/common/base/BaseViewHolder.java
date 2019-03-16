package com.assignment.teo.common.base;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/**
 * Base class implementing {@link ViewHolder}.
 */

public abstract class BaseViewHolder<T> extends ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void setViewModel(T viewModel);
}

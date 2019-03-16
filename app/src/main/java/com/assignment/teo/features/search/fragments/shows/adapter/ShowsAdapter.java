package com.assignment.teo.features.search.fragments.shows.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.teo.R;
import com.assignment.teo.domain.entities.Show;

import java.util.List;

/**
 * Adapter for displaying a list of TV Shows.
 */

public class ShowsAdapter extends RecyclerView.Adapter<ShowViewHolder> {

    private List<Show> dataset;
    private Context context;

    public ShowsAdapter(List<Show> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public ShowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new ShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowViewHolder holder, int position) {
        holder.setViewModel(new ShowViewModel(dataset.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

}


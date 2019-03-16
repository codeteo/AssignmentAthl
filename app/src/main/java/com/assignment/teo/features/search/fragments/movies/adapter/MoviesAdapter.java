package com.assignment.teo.features.search.fragments.movies.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.teo.R;
import com.assignment.teo.domain.entities.Movie;

import java.util.List;

/**
 * Adapter for displaying a list of movies.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> dataset;
    private Context context;

    public MoviesAdapter(List<Movie> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setViewModel(new MovieViewModel(dataset.get(position)));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void clearDataset() {
        dataset.clear();
        notifyDataSetChanged();
    }

    public void setDataset(List<Movie> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

}

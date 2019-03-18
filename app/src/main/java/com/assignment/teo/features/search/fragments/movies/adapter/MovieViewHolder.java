package com.assignment.teo.features.search.fragments.movies.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import static com.assignment.teo.Constants.appendImageUrl;

/**
 * View holder for the movie item.
 */

@SuppressWarnings("FieldCanBeLocal")
public class MovieViewHolder extends BaseViewHolder<MovieViewModel> {

    private TextView tvTitle;
    private ImageView ivPoster;

    private final Context context;

    MovieViewHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_popular_movie_title);
        ivPoster = itemView.findViewById(R.id.iv_popular_movie_image);

        context = itemView.getContext();
    }

    /** binds the view to the model(data) **/
    @Override
    public void setViewModel(MovieViewModel viewModel) {
        tvTitle.setText(viewModel.getTitle());

        Picasso.with(context)
                .load(appendImageUrl(viewModel.getThumbnail()))
                .fit()
                .error(R.drawable.placeholder_movie)
                .into(ivPoster);
    }
}

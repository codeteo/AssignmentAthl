package com.assignment.teo.features.search.fragments.shows.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import static com.assignment.teo.Constants.appendImageUrl;

/**
 * View holder for the TV Show list item.
 */

@SuppressWarnings("FieldCanBeLocal")
public class ShowViewHolder extends BaseViewHolder<ShowViewModel> {

    private TextView tvTitle;
    private ImageView ivPoster;

    private final Context context;

    ShowViewHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_popular_movie_title);
        ivPoster = itemView.findViewById(R.id.iv_popular_movie_image);

        context = itemView.getContext();
    }

    /** binds the view to the model(data) **/
    @Override
    public void setViewModel(ShowViewModel viewModel) {
        tvTitle.setText(viewModel.getTitle());

        Picasso.with(context)
                .load(appendImageUrl(viewModel.getThumbnail()))
                .fit()
                .error(R.drawable.placeholder_movie)
                .into(ivPoster);
    }
}


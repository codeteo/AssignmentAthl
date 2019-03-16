package com.assignment.teo.features.search.fragments.shows.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.teo.Constants;
import com.assignment.teo.R;
import com.assignment.teo.common.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * View holder for the TV Show list item.
 */

@SuppressWarnings("FieldCanBeLocal")
public class ShowViewHolder extends BaseViewHolder<ShowViewModel> {

    private TextView tvTitle;
    private ImageView ivPoster;

    private final Context context;

    // Needs a strong reference so it won't be garbage collected
    private Target target;

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

        target = getTarget();

        Picasso.with(context)
                .load(Constants.appendImageUrl(viewModel.getThumbnail()))
                .into(target);

    }

    private Target getTarget() {
        return new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                ivPoster.setImageBitmap(bitmap);

                Palette.from(bitmap)
                        .generate(palette -> {
                            Palette.Swatch swatch = palette.getVibrantSwatch();
                            int textColor = Color.WHITE;
                            if (swatch != null) {
                                textColor = swatch.getRgb();
                            }
                            tvTitle.setTextColor(textColor);
                        });
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };
    }

}


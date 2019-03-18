package com.assignment.teo.features.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.assignment.teo.R;
import com.assignment.teo.domain.entities.Genre;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

import static com.assignment.teo.Constants.EMPTY_STRING;
import static com.assignment.teo.Constants.appendImageUrl;

/**
 * Screen displaying details about a movie or a show.
 */

public class DetailsActivity extends AppCompatActivity implements DetailsMVP.View {

    public static final String TITLE_INTENT_KEY = "title";
    public static final String IMG_URL_INTENT_KEY = "image_url";
    public static final String OVERVIEW_INTENT_KEY = "overview";
    public static final String GENRE_ID_INTENT_KEY = "genre_id";

    private static final String TITLE_KEY = "title_tag";
    private static final String IMAGE_URL_KEY = "image_url_tag";
    private static final String OVERVIEW_KEY = "overview_tag";
    private static final String GENRE_ID_KEY = "genre_id_tag";

    @BindView(R.id.toolbar_details) Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.iv_details_backdrop) ImageView ivImage;
    @BindView(R.id.tv_details_overview) TextView tvOverview;

    @Inject
    DetailsMVP.Presenter presenter;

    private String title, imageUrl, overview;
    private int genreId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            getExtras();
        } else {
            title = savedInstanceState.getString(TITLE_KEY);
            imageUrl = savedInstanceState.getString(IMAGE_URL_KEY);
            overview = savedInstanceState.getString(OVERVIEW_KEY);
            genreId = savedInstanceState.getInt(GENRE_ID_KEY);
        }

        setupViews();

        presenter.onLoadMovieGenre();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TITLE_KEY, title);
        outState.putString(OVERVIEW_KEY, overview);
        outState.putString(IMAGE_URL_KEY, imageUrl);
        outState.putInt(GENRE_ID_KEY, genreId);
    }

    private void setupViews() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        collapsingToolbar.setTitle(title);
        tvOverview.setText(overview);

        Picasso.with(this)
                .load(appendImageUrl(imageUrl))
                .fit()
                .error(R.drawable.placeholder_movie)
                .into(ivImage);
    }

    private void getExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString(TITLE_INTENT_KEY, EMPTY_STRING);
            imageUrl = extras.getString(IMG_URL_INTENT_KEY, EMPTY_STRING);
            overview = extras.getString(OVERVIEW_INTENT_KEY, EMPTY_STRING);
            genreId = extras.getInt(GENRE_ID_INTENT_KEY, 0);
        }
    }

    @Override
    public void showGenre(Genre genre) {

    }
}

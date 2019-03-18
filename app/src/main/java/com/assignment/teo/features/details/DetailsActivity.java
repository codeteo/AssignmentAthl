package com.assignment.teo.features.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.assignment.teo.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import static com.assignment.teo.Constants.EMPTY_STRING;
import static com.assignment.teo.Constants.appendImageUrl;

/**
 * Screen displaying details about a movie or a show.
 */

public class DetailsActivity extends AppCompatActivity {

    public static final String TITLE_KEY = "title";
    public static final String IMG_URL_KEY = "image_url";
    public static final String OVERVIEW_KEY = "overview";
    public static final String GENRE_ID_KEY = "genre_id";

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView ivImage;

    private String title, imageUrl, overview;
    private int genreId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        toolbar = findViewById(R.id.toolbar_details);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ivImage = findViewById(R.id.iv_details_backdrop);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title = extras.getString(TITLE_KEY, EMPTY_STRING);
            imageUrl = extras.getString(IMG_URL_KEY, EMPTY_STRING);
            overview = extras.getString(OVERVIEW_KEY, EMPTY_STRING);
            genreId = extras.getInt(GENRE_ID_KEY, 0);
        }

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Picasso.with(this)
                .load(appendImageUrl(imageUrl))
                .fit()
                .error(R.drawable.placeholder_movie)
                .into(ivImage);

        collapsingToolbar.setTitle(title);
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
}

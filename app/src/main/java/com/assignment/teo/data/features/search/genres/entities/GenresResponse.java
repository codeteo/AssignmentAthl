package com.assignment.teo.data.features.search.genres.entities;

import com.assignment.teo.data.features.search.genres.GenresService;
import com.google.gson.annotations.SerializedName;

/**
 * Models the response of {@link GenresService}.
 */

public class GenresResponse {

    @SerializedName("genres")
    private GenreDataModel[] genres;

    public GenreDataModel[] getGenres() {
        return genres;
    }

    public void setGenres(GenreDataModel[] genres) {
        this.genres = genres;
    }
}

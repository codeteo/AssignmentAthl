package com.assignment.teo.data.features.search.movies.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Movie object used in the data layer.
 */

public class MoviesSearchResponse {

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("results")
    private MovieDataModel[] movies;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public MovieDataModel[] getMovies() {
        return movies;
    }

    public void setMovies(MovieDataModel[] movies) {
        this.movies = movies;
    }
}

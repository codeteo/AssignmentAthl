package com.assignment.teo.data.features.search.shows.entities;

import com.assignment.teo.data.features.search.shows.ShowsSearchService;
import com.google.gson.annotations.SerializedName;

/**
 * Response object from {@link ShowsSearchService} used in the data layer.
 */

public class ShowsSearchResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int totalResults;

    @SerializedName("total_pages")
    private int totalPages;

    @SerializedName("results")
    private ShowDataModel[] shows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ShowDataModel[] getShows() {
        return shows;
    }

    public void setShows(ShowDataModel[] shows) {
        this.shows = shows;
    }
}

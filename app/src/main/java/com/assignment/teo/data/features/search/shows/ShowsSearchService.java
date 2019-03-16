package com.assignment.teo.data.features.search.shows;

import com.assignment.teo.data.features.search.shows.entities.ShowsSearchResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShowsSearchService {

    /**
     * Service for searching TV Shows from TheMovieDB's api based on user's queries.
     *
     * @see <a href="https://developers.themoviedb.org/3/search/search-tv-shows">documentation</a>
     */

    @POST("search/tv")
    Observable<ShowsSearchResponse> searchShows(
            @Query("api_key") String apiKey, @Query("query") String query,
            @Query("include_adult") String includeAdult, @Query("language") String language);

}

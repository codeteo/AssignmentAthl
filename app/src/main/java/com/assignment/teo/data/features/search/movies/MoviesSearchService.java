package com.assignment.teo.data.features.search.movies;

import com.assignment.teo.data.features.search.movies.entities.MoviesSearchResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MoviesSearchService {

    /**
     * Service for searching Movies from TheMovieDB's api based on user's queries.
     *
     * @see <a href="https://developers.themoviedb.org/3/search/search-movies">documentation</a>
     */

    @POST("search/movie")
    Observable<MoviesSearchResponse> searchMovies(
            @Query("api_key") String apiKey, @Query("query") String query,
            @Query("include_adult") String includeAdult, @Query("language") String language);

}

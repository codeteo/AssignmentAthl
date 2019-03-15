package com.assignment.teo.data.features.search.movies;

import com.assignment.teo.data.features.search.movies.entities.MoviesSearchResponse;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MoviesSearchService {

    /**
     * Service for searching Movies from TheMovieDB's api based on user's queries.
     *
     * @see <a href="https://developers.themoviedb.org/3/search/search-movies">documentation</a>
     */

    @POST("/search/movie")
    Observable<Response<MoviesSearchResponse>> searchMovies(
            @Query("api_key") String apiKey, @Query("query") String query);

}

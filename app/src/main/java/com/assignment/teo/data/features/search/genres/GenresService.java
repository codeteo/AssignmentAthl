package com.assignment.teo.data.features.search.genres;

import com.assignment.teo.data.features.search.genres.entities.GenresResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GenresService {

    /**
     * Service for retrieving movie genre list from TheMovieDB's api.
     *
     * @see <a href="https://developers.themoviedb.org/3/genres/get-movie-list">documentation</a>
     */
    @GET("genre/movie/list")
    Observable<GenresResponse> getMovieGenres(@Query("api_key") String apiKey);

    /**
     * Service for retrieving show genre list from TheMovieDB's api.
     *
     * @see <a href="https://developers.themoviedb.org/3/genres/get-tv-list">documentation</a>
     */
    @GET("genre/movie/list")
    Observable<GenresResponse> getShowGenres(@Query("api_key") String apiKey);

}

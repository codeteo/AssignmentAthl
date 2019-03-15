package com.assignment.teo.data.repository;

import com.assignment.teo.domain.entities.Movie;
import com.assignment.teo.domain.repository.MoviesRepository;

import java.util.List;

import io.reactivex.Observable;

public class MoviesDataRepository implements MoviesRepository {

    @Override
    public Observable<List<Movie>> execute() {
        return null;
    }

    @Override
    public void unsubscribe() {

    }
}

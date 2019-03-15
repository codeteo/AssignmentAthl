package com.assignment.teo.data.repository;

import com.assignment.teo.domain.entities.Show;
import com.assignment.teo.domain.repository.ShowsRepository;

import java.util.List;

import io.reactivex.Observable;

public class ShowsDataRepository implements ShowsRepository {

    @Override
    public Observable<List<Show>> execute() {
        return null;
    }

    @Override
    public void unsubscribe() {

    }
}


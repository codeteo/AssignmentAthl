package com.assignment.teo.domain.repository;

import com.assignment.teo.domain.entities.Show;

import java.util.List;

import io.reactivex.Observable;

public interface ShowsRepository {

    /**
     * Get an {@link Observable} which will emit a List of {@link Show}s.
     */
    Observable<List<Show>> execute();

    /**
     * Remove RxJava subscriptions.
     */
    void unsubscribe();

}

package com.assignment.teo.domain.repository;

import com.assignment.teo.domain.entities.Show;

import java.util.List;

import io.reactivex.Observable;

public interface ShowsRepository {

    /**
     * Get an {@link Observable} which will emit a List of {@link Show}s.
     *
     * @param queryText user's search string.
     */
    Observable<List<Show>> execute(String queryText);

}

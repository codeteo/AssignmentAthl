package com.assignment.teo.domain;

import com.assignment.teo.domain.entities.Show;
import java.util.List;
import io.reactivex.Observable;

/**
 * Interactor for getting searched movies.
 */

public interface SearchShowsUseCase {

    Observable<List<Show>> getShows();

    void unsubscribe();
}


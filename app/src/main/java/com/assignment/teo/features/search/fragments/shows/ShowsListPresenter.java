package com.assignment.teo.features.search.fragments.shows;

import com.assignment.teo.data.bus.BusProvider;
import com.assignment.teo.data.bus.events.StoreShowsEvent;
import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.domain.SearchShowsUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;


@FragmentScope
public class ShowsListPresenter implements ShowsListMVP.Presenter {

    private SearchShowsUseCase searchShows;
    private ShowsListMVP.View view;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Inject
    ShowsListPresenter(SearchShowsUseCase searchShows, ShowsListMVP.View view) {
        this.searchShows = searchShows;
        this.view = view;
    }

    @Override
    public void onSearchShows(String queryText) {
        disposable.add(
                searchShows.getShows(queryText)
                        .subscribe(
                                shows ->  {
                                    view.showTvShows(shows);
                                    BusProvider.getInstance().post(new StoreShowsEvent(shows));
                                },
                                throwable -> Timber.i("THROWABLE: %s", throwable.getCause())));
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }

}


package com.assignment.teo.data.repository;

import android.support.annotation.NonNull;

import com.assignment.teo.data.features.search.shows.entities.ShowDataModel;
import com.assignment.teo.data.features.search.shows.entities.ShowsSearchResponse;
import com.assignment.teo.data.features.search.shows.mappers.ShowDataMapper;
import com.assignment.teo.domain.entities.Show;
import com.assignment.teo.domain.repository.ShowsRepository;
import com.assignment.teo.domain.repository.sources.ShowsDataSource;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;

public class ShowsDataRepository implements ShowsRepository {

    private ShowsDataSource dataSource;
    private BaseSchedulerProvider schedulerProvider;
    private ShowDataMapper mapper;

    private CompositeDisposable disposable = new CompositeDisposable();

    public ShowsDataRepository(ShowsDataSource dataSource,
                               BaseSchedulerProvider schedulerProvider,
                               ShowDataMapper mapper) {
        this.dataSource = dataSource;
        this.schedulerProvider = schedulerProvider;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<Show>> execute(String queryText) {
        return dataSource.shows(queryText)
                .map(mapsResponseToDomainModel())
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }

    @NonNull
    private Function<ShowsSearchResponse, List<Show>> mapsResponseToDomainModel() {
        return dataModels -> {

            List<Show> domainModels = new ArrayList<>();
            for (ShowDataModel dataModel : dataModels.getShows()) {
                domainModels.add(mapper.transform(dataModel));
            }

            return domainModels;
        };
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.clear();
        }
    }
}


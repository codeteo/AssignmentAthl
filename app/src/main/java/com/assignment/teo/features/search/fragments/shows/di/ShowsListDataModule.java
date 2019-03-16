package com.assignment.teo.features.search.fragments.shows.di;

import com.assignment.teo.data.features.search.shows.ShowsSearchService;
import com.assignment.teo.data.features.search.shows.mappers.ShowDataMapper;
import com.assignment.teo.data.repository.ShowsDataRepository;
import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.domain.SearchShowsUseCase;
import com.assignment.teo.domain.SearchShowsUseCaseImpl;
import com.assignment.teo.domain.repository.ShowsRepository;
import com.assignment.teo.domain.repository.sources.ShowsDataSource;
import com.assignment.teo.domain.repository.sources.remote.ShowsRemoteDataSource;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Module which provides data related dependencies for shows list feature.
 */

@Module
public class ShowsListDataModule {

    @FragmentScope
    @Provides
    ShowsSearchService providesShowsSearchService(Retrofit retrofit) {
        return retrofit.create(ShowsSearchService.class);
    }

    @FragmentScope
    @Provides
    ShowsRepository providesShowsRepository(ShowsRemoteDataSource dataSource,
                                            BaseSchedulerProvider schedulerProvider, ShowDataMapper mapper) {

        return new ShowsDataRepository(dataSource, schedulerProvider, mapper);
    }

    @FragmentScope
    @Provides
    ShowsDataSource providesShowsDataSource(
            ShowsSearchService service, @Named(API_KEY) String apiKey) {

        return new ShowsRemoteDataSource(service, apiKey);
    }

    @FragmentScope
    @Provides
    SearchShowsUseCase providesSearchShowsUseCase(
            ShowsRepository repository, BaseSchedulerProvider schedulerProvider) {

        return new SearchShowsUseCaseImpl(repository, schedulerProvider);
    }

}


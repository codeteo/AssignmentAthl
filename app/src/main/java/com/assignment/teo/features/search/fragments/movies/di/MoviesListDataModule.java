package com.assignment.teo.features.search.fragments.movies.di;

import com.assignment.teo.data.features.search.movies.MoviesSearchService;
import com.assignment.teo.data.features.search.movies.mappers.MovieDataMapper;
import com.assignment.teo.data.repository.MoviesDataRepository;
import com.assignment.teo.di.scopes.FragmentScope;
import com.assignment.teo.domain.SearchMoviesUseCase;
import com.assignment.teo.domain.SearchMoviesUseCaseImpl;
import com.assignment.teo.domain.repository.MoviesRepository;
import com.assignment.teo.domain.repository.sources.MoviesDataSource;
import com.assignment.teo.domain.repository.sources.remote.MoviesRemoteDataSource;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Module which provides data related dependencies for movies list feature.
 */

@Module
class MoviesListDataModule {

    // service, repository, remoteDS, localDS, useCase

    @FragmentScope
    @Provides
    MoviesSearchService providesMoviesSearchService(Retrofit retrofit) {
        return retrofit.create(MoviesSearchService.class);
    }

    @FragmentScope
    @Provides
    MoviesRepository providesMoviesRepository(MoviesRemoteDataSource dataSource,
                    BaseSchedulerProvider schedulerProvider, MovieDataMapper mapper) {

        return new MoviesDataRepository(dataSource, schedulerProvider, mapper);
    }

    @FragmentScope
    @Provides
    MoviesDataSource providesMoviesDataSource(
            MoviesSearchService service, @Named(API_KEY) String apiKey) {

        return new MoviesRemoteDataSource(service, apiKey);
    }

    @FragmentScope
    @Provides
    SearchMoviesUseCase providesSearchMoviesUseCase(
            MoviesRepository repository, BaseSchedulerProvider schedulerProvider) {

        return new SearchMoviesUseCaseImpl(repository, schedulerProvider);
    }

}

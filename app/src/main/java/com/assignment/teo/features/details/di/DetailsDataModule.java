package com.assignment.teo.features.details.di;

import com.assignment.teo.data.features.search.genres.GenresService;
import com.assignment.teo.data.features.search.genres.mappers.GenreDataMapper;
import com.assignment.teo.data.repository.GenresDataRepository;
import com.assignment.teo.di.scopes.ActivityScope;
import com.assignment.teo.domain.GetGenresUseCase;
import com.assignment.teo.domain.GetGenresUseCaseImpl;
import com.assignment.teo.domain.repository.GenresRepository;
import com.assignment.teo.domain.repository.sources.GenresDataSource;
import com.assignment.teo.domain.repository.sources.remote.GenresRemoteDataSource;
import com.assignment.teo.utils.schedulers.BaseSchedulerProvider;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static com.assignment.teo.utils.Qualifiers.API_KEY;

/**
 * Module which provides data related dependencies for display genre feature.
 */

@Module
public class DetailsDataModule {

    @ActivityScope
    @Provides
    GenresService providesGenresService(Retrofit retrofit) {
        return retrofit.create(GenresService.class);
    }

    @ActivityScope
    @Provides
    GenresRepository providesGenresRepository(GenresRemoteDataSource dataSource,
                      BaseSchedulerProvider schedulerProvider, GenreDataMapper mapper) {

        return new GenresDataRepository(dataSource, schedulerProvider, mapper);
    }

    @ActivityScope
    @Provides
    GenresDataSource providesGenresDataSource(
            GenresService service, @Named(API_KEY) String apiKey) {

        return new GenresRemoteDataSource(service, apiKey);
    }

    @ActivityScope
    @Provides
    GetGenresUseCase providesGetGenresUseCase(
            GenresRepository repository, BaseSchedulerProvider schedulerProvider) {

        return new GetGenresUseCaseImpl(repository, schedulerProvider);
    }

}


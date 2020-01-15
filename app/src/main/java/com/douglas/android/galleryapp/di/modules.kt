package com.douglas.android.galleryapp.di

import android.app.Application
import android.content.Context
import com.douglas.android.galleryapp.data.AppRepositoryImp
import com.douglas.android.galleryapp.data.remote.ApiHelper
import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import com.douglas.android.galleryapp.data.remote.RemoteDataSourceImp
import com.douglas.android.galleryapp.data.remote.ServiceAppFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable


@Module
abstract class ActivityModule {
//    @ActivityScoped
//    @ContributesAndroidInjector(modules = [PostModule::class])
//    abstract fun postAcitivity(): PostActivity
}

@Module
class AppModule {
    @Provides
    @Reusable
    internal fun provideContext(application: Application): Context = application
}

@Module
class RepositoryModule {
    @Provides
    @Reusable
    internal fun provideAppRepository(remoteDataSource: RemoteDataSource) =
        AppRepositoryImp(remoteDataSource)
}

@Module
class NetworkModule {
    @Provides
    @Reusable
    internal fun provideRemoteRepository(apiHelper: ApiHelper): RemoteDataSource =
        RemoteDataSourceImp(apiHelper)

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create(true)
}

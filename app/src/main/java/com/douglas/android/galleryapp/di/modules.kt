package com.douglas.android.galleryapp.di

import android.app.Application
import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.data.AppRepositoryImp
import com.douglas.android.galleryapp.data.remote.ApiHelper
import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import com.douglas.android.galleryapp.data.remote.RemoteDataSourceImp
import com.douglas.android.galleryapp.data.remote.ServiceAppFactory
import com.douglas.android.galleryapp.features.gallery.view.GalleryAppActivity
import com.douglas.android.galleryapp.features.gallery.GalleryModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [GalleryModule::class])
    abstract fun galleryAcitivity(): GalleryAppActivity
}

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application) = application
}

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideAppRepository(remote: RemoteDataSource): AppRepository = AppRepositoryImp(remote)
}

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRemoteRepository(apiHelper: ApiHelper): RemoteDataSource =
        RemoteDataSourceImp(apiHelper)

    @Provides
    @Singleton
    fun providePostApi() = ServiceAppFactory.create(true)
}

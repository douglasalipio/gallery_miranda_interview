package com.douglas.android.galleryapp.di

import android.app.Application
import android.content.Context
import com.douglas.android.galleryapp.data.AppRepositoryImp
import com.douglas.android.galleryapp.data.remote.ApiHelper
import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import com.douglas.android.galleryapp.data.remote.RemoteDataSourceImp
import com.douglas.android.galleryapp.data.remote.ServiceAppFactory
import com.douglas.android.galleryapp.features.MainActivity
import com.douglas.android.galleryapp.features.gallery.GalleryModule
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [GalleryModule::class])
    abstract fun galleryAcitivity(): MainActivity
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
    internal fun provideAppRepository(remote: RemoteDataSource) = AppRepositoryImp(remote)
}

@Module
class NetworkModule {
    @Provides
    @Reusable
    internal fun provideRemoteRepository(apiHelper: ApiHelper) = RemoteDataSourceImp(apiHelper)

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create(true)
}

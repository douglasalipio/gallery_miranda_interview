package com.douglas.android.galleryapp.di

import android.app.Application
import android.content.Context
import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.data.AppRepositoryImp
import com.douglas.android.galleryapp.data.remote.ApiHelper
import com.douglas.android.galleryapp.data.remote.RemoteDataSource
import com.douglas.android.galleryapp.data.remote.RemoteDataSourceImp
import com.douglas.android.galleryapp.data.remote.ServiceAppFactory
import com.douglas.android.galleryapp.features.MainActivity
import com.douglas.android.galleryapp.features.gallery.GalleryModule
import com.douglas.android.galleryapp.utils.BaseSchedulerProvider
import com.douglas.android.galleryapp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton


@Module
abstract class ActivityModule {
    @ActivityScoped
    @ContributesAndroidInjector(modules = [GalleryModule::class])
    abstract fun galleryAcitivity(): MainActivity
}

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application) = application

    @Provides
    @Singleton
    fun provideAppExecutors(): BaseSchedulerProvider = SchedulerProvider()
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

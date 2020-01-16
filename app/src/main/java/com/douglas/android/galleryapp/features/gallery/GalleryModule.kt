package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.di.ActivityScoped
import com.douglas.android.galleryapp.utils.BaseSchedulerProvider
import dagger.Binds
import dagger.Module

@Module
abstract class GalleryModule {
	@ActivityScoped
	@Binds
	internal abstract fun provideGalleryPresenter(presenter: GalleryPresenter): GalleryContract.Presenter
}

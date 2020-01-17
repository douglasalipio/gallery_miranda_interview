package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.data.remote.dtos.fullImage
import com.douglas.android.galleryapp.data.remote.dtos.largeImage
import com.douglas.android.galleryapp.utils.BaseSchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class GalleryPresenter @Inject constructor(
    private val appRepository: AppRepository,
    private val schedulerProvider: BaseSchedulerProvider
) :
    GalleryContract.Presenter {

    private var view: GalleryContract.View? = null
    private val disposable = CompositeDisposable()

    override fun <T> takeView(view: T) {
        this.view = view as GalleryContract.View
    }

    override fun loadPhotosGallery(pageNumber: Int) {
        disposable.add(appRepository
            .requestMediaInfo(pageNumber)
            .subscribeOn(schedulerProvider.io())
            .flatMap { Observable.just(it.photoIds) }
            .flatMap { iterablePhotoIds(it) }
            .flatMap { appRepository.requestPhoto(it.toLong()) }
            .observeOn(schedulerProvider.ui())
            .subscribe { view?.showPhotos(it.sizes.largeImage(), it.sizes.fullImage()) })
    }

    private fun iterablePhotoIds(ids: List<String>) = Observable.fromIterable(ids)

    override fun dropView() {
        view = null
        disposable.clear()
    }

}

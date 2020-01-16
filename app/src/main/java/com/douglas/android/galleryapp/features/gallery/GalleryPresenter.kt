package com.douglas.android.galleryapp.features.gallery

import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.data.remote.dtos.Photos
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
            .requestMediasInfoAsync(pageNumber)
            .subscribeOn(schedulerProvider.io())
            .flatMap { Observable.just(it.photoIds) }
            .flatMap { iterablePhotoIds(it) }
            .flatMap { appRepository.requestPhotosAsync(it.toLong()) }
            .observeOn(schedulerProvider.ui())
            .subscribe { view?.showPhotos(it.largeImage) })
    }

    private fun iterablePhotoIds(ids: List<String>) = Observable.fromIterable(ids)

    override fun dropView() {
        view = null
        disposable.clear()
    }

}

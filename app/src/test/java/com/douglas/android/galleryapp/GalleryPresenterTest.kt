package com.douglas.android.galleryapp

import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.data.remote.dtos.*
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import com.douglas.android.galleryapp.features.gallery.GalleryPresenter
import com.douglas.android.galleryapp.utils.TrampolineSchedulerProvider
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.then
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks


class GalleryPresenterTest {

    @Mock
    private lateinit var appRepository: AppRepository
    @Mock
    private lateinit var view: GalleryContract.View
    private lateinit var presenter: GalleryContract.Presenter
    private var schedulerProvider = TrampolineSchedulerProvider()

    @Before
    fun setUp() {
        initMocks(this)
        presenter = GalleryPresenter(appRepository, schedulerProvider)
        presenter.takeView(view)
    }

    @Test
    fun `should load media information`() {
        //Given
        val photoDto = mockPhotoDto()
        val mediaInfoDto = mockMediaInfoDto()
        given(appRepository.requestMediaInfo(1)).willReturn(Observable.just(mediaInfoDto))
        given(appRepository.requestPhoto(10)).willReturn(Observable.just(photoDto))
        //When
        presenter.loadPhotosGallery()
        //Than
        then(view).should().showPhotos(photoDto.largeImage)
    }

    private fun mockMediaInfoDto(): MediaInfoDto {
        val photo = Photo("123", "owner", "secret", "server", 1, "title", 1, 1, 1)
        val photos = Photos(1, 1, 1, "10", listOf(photo))
        return MediaInfoDto(photos)
    }

    private fun mockPhotoDto(): PhotoDto {
        val size = Size("", 10, 10, "image_url", "url", "media")
        val sizes = Sizes(1, 1, 1, listOf(size))
        return PhotoDto(sizes)
    }
}

package com.douglas.android.galleryapp

import com.douglas.android.galleryapp.data.remote.dtos.*
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import com.douglas.android.galleryapp.features.gallery.GalleryInteractor
import com.douglas.android.galleryapp.features.gallery.GalleryPresenter
import com.douglas.android.galleryapp.utils.launchSilent
import com.nhaarman.mockitokotlin2.capture
import com.nhaarman.mockitokotlin2.verify
import org.junit.*
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks
import kotlin.coroutines.EmptyCoroutineContext


class GalleryPresenterTest {

    @Mock
    private lateinit var interactor: GalleryContract.Interactor
    @Mock
    private lateinit var view: GalleryContract.View
    @Captor
    private lateinit var getMediaCallbackCaptor: ArgumentCaptor<GalleryInteractor.GetMediaCallback>
    private lateinit var presenter: GalleryPresenter

    @Before
    fun setUp() {
        initMocks(this)
        presenter = GalleryPresenter(interactor)
        presenter.takeView(view)
    }

    @Test
    fun `should load media information`() {
        launchSilent(EmptyCoroutineContext) {
            //Given
            val photoDto = mockPhotoDto()
            presenter.loadMediaGallery(1)
            //When
            verify(interactor).requestMediaGallery(capture(getMediaCallbackCaptor))
            getMediaCallbackCaptor.value.onPhotoLoaded(photoDto)
            //Than
            verify(view).showPhotos(photoDto.sizes.largeImage(), photoDto.sizes.fullImage())
        }
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

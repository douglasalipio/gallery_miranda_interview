package com.douglas.android.galleryapp

import com.douglas.android.galleryapp.data.AppRepository
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import com.douglas.android.galleryapp.features.gallery.GalleryPresenter
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GalleryPresenterTest {

	@Mock
	private lateinit var appRepository: AppRepository
	@Mock
	private lateinit var view: GalleryContract.View
	private lateinit var presenter: GalleryPresenter

	@Before
	fun setUp() {
		MockitoAnnotations.initMocks(this)
		presenter = GalleryPresenter(appRepository)
		presenter.takeView(view)
	}
}

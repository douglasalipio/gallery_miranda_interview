package com.douglas.android.galleryapp.features


import android.os.Bundle
import com.douglas.android.galleryapp.R
import com.douglas.android.galleryapp.features.gallery.GalleryCardItem
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import com.douglas.android.galleryapp.utils.showFullPhotoDialog
import com.douglas.android.galleryapp.utils.initGridLayout
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), GalleryContract.View {

    @Inject
    lateinit var presenter: GalleryContract.Presenter
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val clickOpenPhoto: (String) -> Unit = this::onOpenPhotoClick

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    /**
     * Initialise components
     */
    private fun initComponents() {
        presenter.takeView(this)
        presenter.loadMediaGallery(3)
        galleryList?.initGridLayout(this, groupAdapter, 2)
    }

    /**
     * Load images in a recycler view
     */
    override fun showPhotos(largeImgUrl: String, fullImgUrl: String) =
        groupAdapter.add(GalleryCardItem(largeImgUrl, fullImgUrl, clickOpenPhoto))

    /**
     * Show full image in a dialog
     */
    private fun onOpenPhotoClick(url: String) = this.showFullPhotoDialog(url)

    /**
     * Wise view after the activity is destroyed
     */
    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }


}

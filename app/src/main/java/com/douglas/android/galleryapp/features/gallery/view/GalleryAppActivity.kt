package com.douglas.android.galleryapp.features.gallery.view


import android.os.Bundle
import android.widget.Toast
import com.douglas.android.galleryapp.R
import com.douglas.android.galleryapp.features.gallery.GalleryContract
import com.douglas.android.galleryapp.utils.showFullPhotoDialog
import com.douglas.android.galleryapp.utils.initGridLayout
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class GalleryAppActivity : DaggerAppCompatActivity(), GalleryContract.View {

    @Inject
    lateinit var presenter: GalleryContract.Presenter
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val clickOpenPhoto: (String) -> Unit = this::onPhotoClicked

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        presenter.takeView(this)
        presenter.loadMediaGallery(3)
        galleryList?.initGridLayout(this, groupAdapter, 2)
    }

    override fun showPhotos(largeImgUrl: String, fullImgUrl: String) =
        groupAdapter.add(GalleryCardItem(largeImgUrl, fullImgUrl, clickOpenPhoto))

    override fun showErrorMessage() =
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()

    private fun onPhotoClicked(url: String) = this.showFullPhotoDialog(url)

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropView()
    }
}

package com.yunusbedir.mtekbilisimtestapp.ui.activity.photoActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.util.DataSource
import kotlinx.android.synthetic.main.activity_photo_detail.*

class PhotoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_detail)

        setToolbar()
        setImage()
    }

    private fun setImage() {
        Glide.with(this)
            .load(DataSource.user?.urlImage)
            .into(imgPohoto)
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        onBackPressed()
        return true
    }
}

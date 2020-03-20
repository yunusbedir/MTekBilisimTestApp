package com.yunusbedir.mtekbilisimtestapp.ui.fragment.profileFragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.database.room.UserRepository
import com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity.DashBoardActivity
import com.yunusbedir.mtekbilisimtestapp.ui.activity.photoActivity.PhotoDetailActivity
import com.yunusbedir.mtekbilisimtestapp.util.*
import kotlinx.android.synthetic.main.fragment_profile.*


/**
 * Created by YUNUS BEDİR on 20.03.2020.
 */
class ProfileFragment : Fragment() {

    private val GALLERY_REQUEST_CODE = 1000

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        initViews()

        btnLogout.setOnClickListener {
            DashBoardActivity.appCompatActivity?.extLogOut()
        }

        imgProfilePhoto.setOnClickListener {
            DashBoardActivity.appCompatActivity?.let {
                val intent = Intent(it, PhotoDetailActivity::class.java)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    it,
                    imgProfilePhoto,
                    ViewCompat.getTransitionName(imgProfilePhoto).toString()
                )
                startActivity(intent, options.toBundle())
            }
        }

        btnChangePhoto.setOnClickListener {
            pickFromGallery()
        }
        btnUpdate.setOnClickListener {
            val validateName = validateName(textInputName)
            val validateEmail = validateEmail(textInputEmail)
            val validatePhone = validateMobileNumber(textInputMobileNumber)

            if (validateEmail && validateName && validatePhone) {
                updateUser()
            }
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun initViews() {
        textInputName.error = null
        textInputEmail.error = null
        textInputMobileNumber.error = null
        val user = DataSource.user
        user?.let {
            textInputName.editText?.setText(it.name)
            textInputEmail.editText?.setText(it.eMail)
            textInputMobileNumber.editText?.setText(it.mobileNumber)
            setImage()
        }

    }

    private fun updateUser() {
        DataSource.user?.apply {
            name = textInputName.editText?.text.toString()
            eMail = textInputEmail.editText?.text.toString()
            mobileNumber = textInputMobileNumber.editText?.text.toString()
        }
        UserRepository(this.context!!)
            .update(DataSource.user!!)
    }

    private fun pickFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        val mimeTypes = listOf("image/jpeg", "image/png")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes.toTypedArray())

        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GALLERY_REQUEST_CODE -> {
                    val selectedImage: Uri? = data!!.data
                    DataSource.user?.urlImage = selectedImage.toString()
                    setImage()

                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun setImage() {
        Glide
            .with(this)
            .load(DataSource.user?.urlImage)
            .error(R.drawable.ic_account_circle)
            .into(imgProfilePhoto)
    }
}
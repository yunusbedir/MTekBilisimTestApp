package com.yunusbedir.mtekbilisimtestapp.ui.fragment.profileFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.database.UserRepository
import com.yunusbedir.mtekbilisimtestapp.model.User
import com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity.DashBoardActivity
import com.yunusbedir.mtekbilisimtestapp.util.*
import kotlinx.android.synthetic.main.fragment_profile.*


/**
 * Created by YUNUS BEDİR on 20.03.2020.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnLogout.setOnClickListener {
            DashBoardActivity.appCompatActivity?.extLogOut()
        }

        initViews()

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
            textInputName.editText?.setText(it.name.toString())
            textInputEmail.editText?.setText(it.eMail.toString())
            textInputMobileNumber.editText?.setText(it.mobileNumber.toString())

            Glide
                .with(this)
                .load("https://www.aerobilet.com.tr/blog/wp-content/uploads/2018/04/baslik-6.jpg")
                .error(R.drawable.ic_pharmacy)
                .circleCrop()
                .into(imgProfilePhoto)

        }

    }

    private fun updateUser() {
        DataSource.user?.apply {
            name = textInputName.editText?.text.toString()
            eMail = textInputEmail.editText?.text.toString()
            mobileNumber = textInputMobileNumber.editText?.text.toString()
        }
        UserRepository(this.context!!).update(DataSource.user!!)
    }
}
package com.yunusbedir.mtekbilisimtestapp.ui.fragment.registerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.database.UserRepository
import com.yunusbedir.mtekbilisimtestapp.model.User
import com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity.MainActivity
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.loginFragment.LoginFragment
import com.yunusbedir.mtekbilisimtestapp.util.*
import kotlinx.android.synthetic.main.fragment_register.*


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
class RegisterFragment : Fragment() {
    private val activity: AppCompatActivity? = MainActivity.activity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvLogin.setOnClickListener {
            activity?.setFrameLayout(LoginFragment())
        }
        btnRegister.setOnClickListener {
            val isValidateName = validateName(textInputName)
            val isValidateEmail = validateEmail(textInputEmail)
            val isValidatePassword = validatePassword(textInputPassword)
            val isValidateMobileNumber = validateMobileNumber(textInputMobileNumber)

            if (isValidateEmail &&
                isValidateMobileNumber &&
                isValidateName &&
                isValidatePassword
            ) {
                register()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun register() {
        val user = User(
            name = textInputName.editText?.text.toString(),
            mobileNumber = textInputMobileNumber.editText?.text.toString(),
            eMail = textInputEmail.editText?.text.toString(),
            password = textInputPassword.editText?.text.toString(),
            urlImage = ""
        )
        UserRepository(activity!!.applicationContext).insert(user)
        activity?.setFrameLayout(LoginFragment())
    }
}
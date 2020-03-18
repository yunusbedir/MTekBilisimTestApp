package com.yunusbedir.mtekbilisimtestapp.ui.fragment.loginFragment

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.database.UserRepository
import com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity.DashBoardActivity
import com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity.MainActivity
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.registerFragment.RegisterFragment
import com.yunusbedir.mtekbilisimtestapp.util.*
import kotlinx.android.synthetic.main.fragment_login.*


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
class LoginFragment : Fragment() {

    private var activity = MainActivity.activity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvRegister.setOnClickListener {
            activity?.setFrameLayout(RegisterFragment())
        }
        btnLogin.setOnClickListener {
            val isValidateEmail = validateEmail(textInputEmail)
            val isValidatePassword = validatePassword(textInputPassword)
            if (isValidateEmail && isValidatePassword) {
                login()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }


    private fun login() {
        val email: String = etEmail.text.toString()
        val password: String = etPassword.text.toString()
        val user = UserRepository(activity!!.applicationContext).getUser(email, password)

        if (user == null) {
            activity!! extToast "Email or password is incorrect"
            textInputEmail.editText?.setText("")
            textInputPassword.editText?.setText("")
        } else {
            DataSource.user = user
            context?.extStartActivity(DashBoardActivity::class.java)
            activity?.finish()
        }

    }
}
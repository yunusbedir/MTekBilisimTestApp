package com.yunusbedir.mtekbilisimtestapp.ui.fragment.loginFragment

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.StaticValues
import com.yunusbedir.mtekbilisimtestapp.database.UserRepository
import com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity.DashBoardActivity
import com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity.MainActivity
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.registerFragment.RegisterFragment
import com.yunusbedir.mtekbilisimtestapp.util.PASSWORD_PATTERN
import com.yunusbedir.mtekbilisimtestapp.util.extStartActivity
import com.yunusbedir.mtekbilisimtestapp.util.extToast
import com.yunusbedir.mtekbilisimtestapp.util.setFrameLayout
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
            var isEmail = validateEmail()
            var isPassword = validatePassword()
            if (isEmail || isPassword) {
                login()
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun validateEmail(): Boolean {
        val email: String = etEmail.text.toString()
        if (email == "") {
            textInputEmail.error = "Field can't be empty"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            textInputEmail.error = "Please enter a valid email address"
            return false
        } else {
            textInputEmail.error = null
        }
        return true
    }

    private fun validatePassword(): Boolean {

        val password: String = etPassword.text.toString()
        if (password == "") {
            textInputPassword.error = "Field can't be empty"
            return false
        } else if (password.length < 7) {
            textInputPassword.error = "Password too short";
            return false
        } else {
            textInputPassword.error = null
        }
        return true
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
            StaticValues.user = user
            context?.extStartActivity(DashBoardActivity::class.java)
        }

    }
}
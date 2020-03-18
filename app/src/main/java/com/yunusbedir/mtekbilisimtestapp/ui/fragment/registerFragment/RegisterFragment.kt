package com.yunusbedir.mtekbilisimtestapp.ui.fragment.registerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity.MainActivity
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.loginFragment.LoginFragment
import com.yunusbedir.mtekbilisimtestapp.util.setFrameLayout
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

        super.onViewCreated(view, savedInstanceState)
    }
}
package com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.loginFragment.LoginFragment
import com.yunusbedir.mtekbilisimtestapp.util.setFrameLayout

class MainActivity : AppCompatActivity() {
    companion object {
        var activity: AppCompatActivity?=null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this
        this.setFrameLayout(LoginFragment())

    }
}

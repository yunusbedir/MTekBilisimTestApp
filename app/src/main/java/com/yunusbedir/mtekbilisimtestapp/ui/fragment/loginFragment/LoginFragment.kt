package com.yunusbedir.mtekbilisimtestapp.ui.fragment.loginFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}
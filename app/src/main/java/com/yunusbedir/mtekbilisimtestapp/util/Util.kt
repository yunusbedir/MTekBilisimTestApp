package com.yunusbedir.mtekbilisimtestapp.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.enums.Key


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */

infix fun AppCompatActivity.setFrameLayout(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(
        R.id.flFragmentContainer,
        fragment
    ).commit()
}

infix fun Context.extToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun <ClassName> Context.extStartActivity(cls: Class<ClassName>, bundle: Bundle? = null) {
    var intent = Intent(this, cls)
    intent.putExtra(Key.BUNDLE.name, bundle)
    this.startActivity(intent)
}
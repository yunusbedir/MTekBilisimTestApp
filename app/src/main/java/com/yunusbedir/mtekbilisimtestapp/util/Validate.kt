package com.yunusbedir.mtekbilisimtestapp.util

import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */


fun validateEmail(textInputEmail: TextInputLayout): Boolean {
    val email: String = textInputEmail.editText?.text.toString()
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

fun validateName(textInputName: TextInputLayout): Boolean {
    val name: String = textInputName.editText?.text.toString()
    if (name == "") {
        textInputName.error = "Field can't be empty"
        return false
    } else {
        textInputName.error = null
    }
    return true
}

fun validateMobileNumber(textInputMobileNUmber: TextInputLayout): Boolean {
    val mobileNumber: String = textInputMobileNUmber.editText?.text.toString()
    if (mobileNumber == "") {
        textInputMobileNUmber.error = "Field can't be empty"
        return false
    } else if (mobileNumber.length != 11) {
        textInputMobileNUmber.error = "Mobile number must be 11 characters"
        return false
    } else {
        textInputMobileNUmber.error = null
    }
    return true
}

fun validatePassword(textInputPassword: TextInputLayout): Boolean {

    val password: String = textInputPassword.editText?.text.toString()
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
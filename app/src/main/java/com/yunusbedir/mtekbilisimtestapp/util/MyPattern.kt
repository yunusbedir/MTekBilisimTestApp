package com.yunusbedir.mtekbilisimtestapp.util

import java.util.regex.Pattern


/**
 * Created by YUNUS BEDİR on 18.03.2020.
 */
val PASSWORD_PATTERN: Pattern? = Pattern.compile(
    "^" +  //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +  //any letter
            "(?=.*[@#$%^&+=])" +  //at least 1 special character
            "(?=\\S+$)" +  //no white spaces
            ".{4,}" +  //at least 4 characters
            "$"
)
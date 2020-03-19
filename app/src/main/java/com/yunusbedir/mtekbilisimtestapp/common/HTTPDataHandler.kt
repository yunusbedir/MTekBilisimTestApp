package com.yunusbedir.mtekbilisimtestapp.common

import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class HTTPDataHandler {
    companion object {
        var stream: String? = null
    }

    fun getHttpData(urlString: String): String {

        try {
            val url = URL(urlString)
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection

            if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                val inputStream = BufferedInputStream(urlConnection.inputStream)
                val bufferRead = BufferedReader(InputStreamReader(inputStream))
                val sb = StringBuilder()
                var line: String? = bufferRead.readLine()

                while (line != null) {
                    sb.append(line)
                    line = bufferRead.readLine()
                }

                stream = sb.toString()
                urlConnection.disconnect()
            }
            else{
                println("İnternet bağlantısı hatası")
            }

        } catch (e: Exception) {
            stream = ""
            e.printStackTrace()
        }
        return stream!!
    }
}
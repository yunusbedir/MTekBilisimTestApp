package com.yunusbedir.mtekbilisimtestapp.database.csv

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import com.yunusbedir.mtekbilisimtestapp.ui.activity.mainActivity.MainActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception


/**
 * Created by YUNUS BEDİR on 20.03.2020.
 */
class CSVAsyncTask(
    var activity: AppCompatActivity,
    var myOnPostExecute: (result: List<String>?) -> Unit
) :
    AsyncTask<Int, Void, List<String>?>() {

    override fun doInBackground(vararg params: Int?): List<String>? {
        val resultList = ArrayList<String>()
        val inputStream: InputStream =
            MainActivity.activity!!.resources.openRawResource(params[0]!!)
        val reader = BufferedReader(InputStreamReader(inputStream))
        try {
            var line: String? = reader.readLine()
            while (line != null) {
                resultList.add(line)
                try {
                    line = reader.readLine()
                } catch (e: Exception) {
                    break
                }
            }
        } catch (ex: IOException) {
            return null
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {

            }
        }
        return resultList
    }

    override fun onPostExecute(result: List<String>?) {
        myOnPostExecute(result)
        super.onPostExecute(result)
    }
}
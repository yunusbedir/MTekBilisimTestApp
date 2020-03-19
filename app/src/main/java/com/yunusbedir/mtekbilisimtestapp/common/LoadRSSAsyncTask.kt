package com.yunusbedir.mtekbilisimtestapp.common

import android.os.AsyncTask
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter.NewsAdapter
import com.yunusbedir.mtekbilisimtestapp.model.RSSBaseModel


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class LoadRSSAsyncTask(
    var progressBar: ProgressBar
) : AsyncTask<String, String, RSSBaseModel?>() {

    override fun onPreExecute() {
        progressBar.visibility = View.VISIBLE
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: String?): RSSBaseModel? {
        val result: String
        val http = HTTPDataHandler();
        result = http.getHttpData(params[0]!!)

        return Gson().fromJson(result, RSSBaseModel::class.java)
    }

    override fun onPostExecute(result: RSSBaseModel?) {
        progressBar.visibility = View.GONE
        super.onPostExecute(result)
    }
}
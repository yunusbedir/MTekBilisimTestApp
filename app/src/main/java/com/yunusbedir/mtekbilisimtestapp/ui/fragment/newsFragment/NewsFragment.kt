package com.yunusbedir.mtekbilisimtestapp.ui.fragment.newsFragment

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter.NewsAdapter
import com.yunusbedir.mtekbilisimtestapp.common.LoadRSSAsyncTask
import com.yunusbedir.mtekbilisimtestapp.model.Enclosure
import com.yunusbedir.mtekbilisimtestapp.model.Items
import com.yunusbedir.mtekbilisimtestapp.model.RSSBaseModel
import kotlinx.android.synthetic.main.fragment_news.*
import java.lang.StringBuilder


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class NewsFragment : Fragment() {

    private val RSS_LINK = "https://www.donanimhaber.com/rss/tum/"
    private val RSS_TO_JSON_API = "https://api.rss2json.com/v1/api.json?rss_url="


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerViewNews.adapter = NewsAdapter(context!! , loadRSS()!!)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun loadRSS(): RSSBaseModel?{
        val urlGetData = StringBuilder(RSS_TO_JSON_API)
        urlGetData.append(RSS_LINK)
        return LoadRSSAsyncTask(progressBar).execute(urlGetData.toString()).get()
    }

}
package com.yunusbedir.mtekbilisimtestapp.ui.fragment.newsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter.NewsAdapter
import com.yunusbedir.mtekbilisimtestapp.client.news.NewsAPIService
import com.yunusbedir.mtekbilisimtestapp.client.news.NewsClientInstance
import com.yunusbedir.mtekbilisimtestapp.model.RSSBaseModel
import com.yunusbedir.mtekbilisimtestapp.util.extToast
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_news.progressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
        setRetrofit()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setRetrofit() {

        progressBar.visibility = View.VISIBLE

        val service = NewsClientInstance.getInstance()?.create(
            NewsAPIService::class.java
        )

        val call = service?.getNews(RSS_LINK)
        call?.enqueue(object : Callback<RSSBaseModel>{
            override fun onFailure(call: Call<RSSBaseModel>?, t: Throwable?) {
                progressBar.visibility = View.GONE
                context?.extToast("Pharmacy Not Found")
            }

            override fun onResponse(call: Call<RSSBaseModel>?, response: Response<RSSBaseModel>?) {
                if (response!!.isSuccessful) {
                    recyclerViewNews.adapter = NewsAdapter(context!!,response.body())
                }
                progressBar.visibility = View.GONE
            }

        })
    }

}
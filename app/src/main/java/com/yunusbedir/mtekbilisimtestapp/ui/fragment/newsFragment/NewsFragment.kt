package com.yunusbedir.mtekbilisimtestapp.ui.fragment.newsFragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter.NewsAdapter
import com.yunusbedir.mtekbilisimtestapp.model.NewsModel
import kotlinx.android.synthetic.main.fragment_news.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class NewsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {



        recyclerViewNews.adapter = NewsAdapter(context!!,getListNews())
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getListNews():List<NewsModel>{
        val listNews = ArrayList<NewsModel>()
        listNews.add(NewsModel("asd","asd","asd","asd","asd"))
        listNews.add(NewsModel("asd","asd","asd","asd","asd"))
        listNews.add(NewsModel("asd","asd","asd","asd","asd"))
        listNews.add(NewsModel("asd","asd","asd","asd","asd"))
        listNews.add(NewsModel("asd","asd","asd","asd","asd"))
        listNews.add(NewsModel("asd","asd","asd","asd","asd"))
        return listNews
    }
}
package com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.enums.Key
import com.yunusbedir.mtekbilisimtestapp.model.Items
import com.yunusbedir.mtekbilisimtestapp.model.RSSBaseModel
import com.yunusbedir.mtekbilisimtestapp.ui.activity.newsActivity.NewsActivity
import com.yunusbedir.mtekbilisimtestapp.util.extStartActivity


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class NewsAdapter(var context: Context, rssBaseModel: RSSBaseModel) :
    RecyclerView.Adapter<NewsViewHolder>() {

    private var listNews: List<Items> = rssBaseModel.items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listNews[position]) {
            val bundle = Bundle()
            bundle.putParcelable(Key.NEWS_MODEL.name , listNews[position])
            context.extStartActivity(NewsActivity::class.java, bundle)
        }
    }
}
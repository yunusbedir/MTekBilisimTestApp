package com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter

import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.mtekbilisimtestapp.model.NewsModel
import kotlinx.android.synthetic.main.item_news.view.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(newsModel: NewsModel, onClick: (newModel: NewsModel) -> Unit) {
        itemView.tvTitle.text = newsModel.title
        itemView.tvDescription.text = newsModel.description
        itemView.tvDate.text = newsModel.date
        //set Image glide

        itemView.setOnClickListener {
            onClick(newsModel)
        }
    }
}
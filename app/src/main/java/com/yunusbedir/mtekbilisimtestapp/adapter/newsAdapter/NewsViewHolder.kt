package com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.mtekbilisimtestapp.model.Items
import kotlinx.android.synthetic.main.item_news.view.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(newsModel: Items, onClick: (newModel: Items) -> Unit) {
        itemView.tvTitle.text = newsModel.title
        itemView.tvDescription.text = newsModel.description
        itemView.tvDate.text = newsModel.pubDate
        //set Image glide

        itemView.setOnClickListener {
            onClick(newsModel)
        }
    }
}
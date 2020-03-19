package com.yunusbedir.mtekbilisimtestapp.adapter.newsAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yunusbedir.mtekbilisimtestapp.model.Items
import kotlinx.android.synthetic.main.item_news.view.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(newsModel: Items, onClick: (newModel: Items) -> Unit) {
        itemView.tvTitle.text = newsModel.title
        itemView.tvDescription.text = newsModel.description.split(">")[1]
        itemView.tvDate.text = newsModel.pubDate
        Glide.with(itemView).load(newsModel.thumbnail).centerCrop().into(itemView.imgNews)

        itemView.setOnClickListener {
            onClick(newsModel)
        }
    }
}
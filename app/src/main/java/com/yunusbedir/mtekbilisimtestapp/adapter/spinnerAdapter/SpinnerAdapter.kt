package com.yunusbedir.mtekbilisimtestapp.adapter.spinnerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.model.SpinnerBaseModel
import kotlinx.android.synthetic.main.item_spinner_dropdown.view.*


/**
 * Created by YUNUS BEDİR on 17.03.2020.
 */
class SpinnerAdapter(var list: List<SpinnerBaseModel>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.item_spinner_dropdown, parent, false)
        val tv = view.tvTitle
        tv.text = list[position].title
        return view
    }

    override fun getItem(position: Int): SpinnerBaseModel? {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return list[position].mID.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}
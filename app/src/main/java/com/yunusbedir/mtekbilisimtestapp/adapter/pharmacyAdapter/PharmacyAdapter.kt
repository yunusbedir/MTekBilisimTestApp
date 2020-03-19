package com.yunusbedir.mtekbilisimtestapp.adapter.pharmacyAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.model.PharmacyBaseModel


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class PharmacyAdapter(var pharmacyBaseModel: PharmacyBaseModel) : RecyclerView.Adapter<PharmacyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_pharmacy,parent,false)
        return PharmacyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pharmacyBaseModel.result?.size!!
    }

    override fun onBindViewHolder(holder: PharmacyViewHolder, position: Int) {
        holder.bind(pharmacyBaseModel.result?.get(position))
    }
}
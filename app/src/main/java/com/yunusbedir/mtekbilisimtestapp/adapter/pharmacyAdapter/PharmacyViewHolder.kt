package com.yunusbedir.mtekbilisimtestapp.adapter.pharmacyAdapter

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.model.Result
import com.yunusbedir.mtekbilisimtestapp.util.extStartActivity
import kotlinx.android.synthetic.main.item_pharmacy.view.*


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class PharmacyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(result: Result?) {

        itemView.tvName.text = result?.name
        itemView.tvPhone.text = result?.phone
        itemView.tvAddress.text = result?.address
        itemView.tvDist.text = result?.dist

        itemView.btnArrow.setOnClickListener {
            if (itemView.expandableView.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(itemView.cardView, AutoTransition())
                itemView.expandableView.visibility = View.VISIBLE
                itemView.btnArrow.setBackgroundResource(R.drawable.ic_arrow_up)
            } else {
                //TransitionManager.beginDelayedTransition(itemView.cardView, AutoTransition())
                itemView.expandableView.visibility = View.GONE
                itemView.btnArrow.setBackgroundResource(R.drawable.ic_arrow_down)
            }
        }

        itemView.btnMap.setOnClickListener {
            val uri = Uri.parse("geo:${result?.loc}?q=${result?.name} ${result?.address}")

            val intent = Intent(Intent.ACTION_VIEW , uri)
            intent.setPackage("com.google.android.apps.maps")
            itemView.context.startActivity(intent)
        }
    }
}
package com.yunusbedir.mtekbilisimtestapp.ui.fragment.pharmacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.pharmacyAdapter.PharmacyAdapter
import com.yunusbedir.mtekbilisimtestapp.client.PharmacyAPIService
import com.yunusbedir.mtekbilisimtestapp.client.PharmacyClientInstance
import com.yunusbedir.mtekbilisimtestapp.model.PharmacyBaseModel
import com.yunusbedir.mtekbilisimtestapp.util.extToast
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_pharmacy.*
import kotlinx.android.synthetic.main.fragment_pharmacy.progressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class PharmacyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pharmacy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnFilter.setOnClickListener {

            setRetrofit("sultanbeyli", "istanbul")
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun setRetrofit(city: String, province: String) {

        progressBar.visibility = View.VISIBLE

        val service = PharmacyClientInstance.getInstance()?.create(PharmacyAPIService::class.java)

        val call = service?.getPharmacyBaseModel(city, province)!!
        call.enqueue(object : Callback<PharmacyBaseModel> {
            override fun onFailure(call: Call<PharmacyBaseModel>, t: Throwable?) {
                progressBar.visibility = View.GONE
                context?.extToast("Pharmacy Not Found")
            }

            override fun onResponse(
                call: Call<PharmacyBaseModel>,
                response: Response<PharmacyBaseModel>
            ) {
                if (response.isSuccessful) {
                    setRecyclerView(response.body())
                }
                progressBar.visibility = View.GONE
            }

        })
    }

    fun setRecyclerView(pharmacyBaseModel: PharmacyBaseModel) {
        recyclerViewPharmacy.adapter = PharmacyAdapter(pharmacyBaseModel)
    }
}
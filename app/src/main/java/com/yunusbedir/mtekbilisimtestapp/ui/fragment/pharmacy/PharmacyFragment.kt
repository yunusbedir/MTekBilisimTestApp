package com.yunusbedir.mtekbilisimtestapp.ui.fragment.pharmacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.pharmacyAdapter.PharmacyAdapter
import com.yunusbedir.mtekbilisimtestapp.adapter.spinnerAdapter.SpinnerAdapter
import com.yunusbedir.mtekbilisimtestapp.client.pharmacy.PharmacyAPIService
import com.yunusbedir.mtekbilisimtestapp.client.pharmacy.PharmacyClientInstance
import com.yunusbedir.mtekbilisimtestapp.database.csv.CSVAsyncTask
import com.yunusbedir.mtekbilisimtestapp.model.City
import com.yunusbedir.mtekbilisimtestapp.model.PharmacyBaseModel
import com.yunusbedir.mtekbilisimtestapp.model.Province
import com.yunusbedir.mtekbilisimtestapp.util.extToast
import com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity.DashBoardActivity
import kotlinx.android.synthetic.main.fragment_pharmacy.*
import kotlinx.android.synthetic.main.fragment_pharmacy.progressBar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class PharmacyFragment : Fragment() {
    var listProvince = ArrayList<Province>()
    var city: String? = null
    var province: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_pharmacy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setProvinceSpinner()
        btnFilter.setOnClickListener {
            setRetrofit(city!!, province!!)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setProvinceSpinner() {
        CSVAsyncTask(DashBoardActivity.appCompatActivity!!) {
            it?.forEach { str ->
                val province = Province(
                    title = str.split(",")[1],
                    countryID = 1,
                    mID = str.split(",")[0].toInt()
                )
                listProvince.add(province)
            }
            spinnerProvince.adapter = SpinnerAdapter(listProvince)
        }.execute(R.raw.il)

        provinceSpinnerSelectedListener()
    }

    private fun provinceSpinnerSelectedListener() {
        spinnerProvince.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                setCitySpinner((position + 1).toString())
                province = (view as TextView).text as String
            }
        }
    }


    private fun setCitySpinner(provinceID: String) {
        CSVAsyncTask(DashBoardActivity.appCompatActivity!!) {
            val listCity = ArrayList<City>()
            it?.filter { str ->
                str.split(",")[1] == provinceID
            }?.forEach { str ->
                val city = City(
                    title = str.split(",")[2],
                    provinceID = str.split(",")[1].toInt(),
                    mID = str.split(",")[0].toInt()
                )
                listCity.add(city)
            }
            spinnerCity.adapter = SpinnerAdapter(listCity)
        }.execute(R.raw.ilce)

        citySpinnerSelectedListener()
    }

    private fun citySpinnerSelectedListener() {
        spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                city = (view as TextView).text as String
            }
        }
    }

    private fun setRetrofit(city: String, province: String) {
        progressBar.visibility = View.VISIBLE
        val service = PharmacyClientInstance.getInstance()?.create(
            PharmacyAPIService::class.java)
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
                }else {
                    if (response.code() == 429) {
                        context?.extToast("limit is reached")
                    }
                }
                progressBar.visibility = View.GONE
            }
        })
    }

    fun setRecyclerView(pharmacyBaseModel: PharmacyBaseModel) {
        recyclerViewPharmacy.adapter = PharmacyAdapter(pharmacyBaseModel)
    }
}

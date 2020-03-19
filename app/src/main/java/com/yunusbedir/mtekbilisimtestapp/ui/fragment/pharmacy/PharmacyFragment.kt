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
import com.yunusbedir.mtekbilisimtestapp.client.PharmacyAPIService
import com.yunusbedir.mtekbilisimtestapp.client.PharmacyClientInstance
import com.yunusbedir.mtekbilisimtestapp.model.City
import com.yunusbedir.mtekbilisimtestapp.model.PharmacyBaseModel
import com.yunusbedir.mtekbilisimtestapp.model.Province
import com.yunusbedir.mtekbilisimtestapp.util.extToast
import com.yunusbedir.mtekbilisimtestapp.util.readCSV
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

        spinnerProvince.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

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

    fun setProvinceSpinner(provinceList: List<Province>) {
        var arr = SpinnerAdapter(provinceList)
        spinnerProvince.adapter = arr
    }

    fun setCitySpinner(cityList: List<City>) {
        var arr = SpinnerAdapter(cityList)
        spinnerCity.adapter = arr
    }


    fun setProvinceSpinner() {
        setProvinceSpinner(getProvinceList())
    }

    fun setCitySpinner(provinceID: String) {
        setCitySpinner(getCityList(provinceID))
    }

    private fun getProvinceList(): List<Province> {
        val arr = readCSV(R.raw.il)
        val listProvince = ArrayList<Province>()

        arr.forEach {
            var province = Province(
                title = it.split(",")[1],
                countryID = 1,
                mID = it.split(",")[0].toInt()
            )
            listProvince.add(province)
        }
        return listProvince
    }

    private fun getCityList(provinceID: String): List<City> {
        var arr = readCSV(R.raw.ilce)
        val listCity = ArrayList<City>()
        arr.filter {
            it.split(",")[1] == provinceID
        }.forEach {
            var city = City(
                title = it.split(",")[2],
                provinceID = it.split(",")[1].toInt(),
                mID = it.split(",")[0].toInt()
            )
            listCity.add(city)
        }
        return listCity
    }
}
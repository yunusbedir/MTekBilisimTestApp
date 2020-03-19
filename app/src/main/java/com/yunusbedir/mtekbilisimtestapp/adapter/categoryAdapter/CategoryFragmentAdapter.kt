package com.yunusbedir.mtekbilisimtestapp.adapter.categoryAdapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yunusbedir.mtekbilisimtestapp.enums.Constant
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.newsFragment.NewsFragment
import com.yunusbedir.mtekbilisimtestapp.ui.fragment.pharmacy.PharmacyFragment


/**
 * Created by YUNUS BEDİR on 19.03.2020.
 */
class CategoryFragmentAdapter(var context: Context, fm:FragmentManager) : FragmentPagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        when(position){
            Constant.NEWS.id ->{
                return NewsFragment()
            }
            Constant.PHARMACY.id ->{
                return PharmacyFragment()
            }
            Constant.PROFILE.id ->{}
        }
        return NewsFragment()
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            Constant.NEWS.id ->{
                return "News"
            }
            Constant.PHARMACY.id ->{
                return "Pharmacy"
            }
            Constant.PROFILE.id ->{
                return "Profile"
            }
        }

        return "News"
    }
}
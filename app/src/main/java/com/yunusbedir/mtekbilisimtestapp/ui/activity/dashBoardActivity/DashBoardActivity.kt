package com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.categoryAdapter.CategoryFragmentAdapter
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class DashBoardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        setToolbar()
        setDrawer()
        setTabLayout()
        setNavigationView()
        setPagerAdapter()
    }

    private fun setPagerAdapter() {
        val pagerAdapter = CategoryFragmentAdapter(this, supportFragmentManager)
        viewpager.adapter = pagerAdapter
    }

    private fun setNavigationView() {
        if (navDrawer != null) {
            navDrawer.setNavigationItemSelectedListener(this)
        }
        onNavigationItemSelected(navDrawer.menu.getItem(0).setChecked(true))


    }

    private fun setTabLayout() {
        tabsSliding.setupWithViewPager(viewpager)
        tabsSliding.tabMode = TabLayout.GRAVITY_CENTER
        tabsSliding.tabGravity = TabLayout.GRAVITY_FILL

    }


    private fun setDrawer() {
        val toggle = ActionBarDrawerToggle(
            this,
            layoutDrawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        layoutDrawer.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_news -> {
                viewpager.currentItem = 0
            }
            R.id.nav_pharmacy -> {
                viewpager.currentItem = 1
            }
            R.id.nav_profile -> {
                viewpager.currentItem = 2
            }
            R.id.nav_log_out -> {
                //logout
            }
        }
        layoutDrawer.closeDrawer(GravityCompat.START)
        return true
    }
}

package com.yunusbedir.mtekbilisimtestapp.ui.activity.dashBoardActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.adapter.categoryAdapter.CategoryFragmentAdapter
import com.yunusbedir.mtekbilisimtestapp.util.DataSource
import com.yunusbedir.mtekbilisimtestapp.util.extLogOut
import kotlinx.android.synthetic.main.activity_dash_board.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*

class DashBoardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        var appCompatActivity: AppCompatActivity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        appCompatActivity = this
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu!!)
        return true
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuItemLogOut -> {
                this.extLogOut()
            }
        }

        return true
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
        setNavHeader()

    }

    private fun setNavHeader() {
        Glide
            .with(this)
            .load(DataSource.user?.urlImage)
            .centerCrop()
            .into(
            navDrawer.getHeaderView(0).imgProfilePhoto
        )

        navDrawer.getHeaderView(0).tvName.text = DataSource.user?.name
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
                this.extLogOut()
            }
        }
        layoutDrawer.closeDrawer(GravityCompat.START)
        return true
    }
}

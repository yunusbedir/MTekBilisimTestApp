package com.yunusbedir.mtekbilisimtestapp.ui.activity.newsActivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import com.yunusbedir.mtekbilisimtestapp.R
import com.yunusbedir.mtekbilisimtestapp.enums.Key
import com.yunusbedir.mtekbilisimtestapp.model.Items
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    lateinit var newsModel:Items

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val bundle = intent.getBundleExtra(Key.BUNDLE.name)
        newsModel = bundle?.getParcelable(Key.NEWS_MODEL.name)!!

        setToolbar()
        setWebView()
    }

    private fun setToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        tvTitle.text = newsModel.title
        this.setSupportActionBar(toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            16908332 ->{ onBackPressed()}
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl(newsModel.link)
    }
}

package by.icleborobot_repair

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
//нижеидущую строчку добавил:
    lateinit var webView:WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlWeb = getString(R.string.website_url)
        //изменил это на нижеидущее:
        //val webView = findViewById<WebView>(R.id.xml_webview)
        webView = findViewById<WebView>(R.id.xml_webview)


        webView.webViewClient = WebViewClient()
        webView.loadUrl(urlWeb)

        val webSettings=webView.settings

        webSettings.javaScriptEnabled=true

    }

    //нижеидущее добавил (всё):
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
    override fun onBackPressed() {
        if (webView!!.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
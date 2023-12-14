package by.icleborobot_repair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var urlWeb = getString(R.string.website_url)
        val webView = findViewById<WebView>(R.id.xml_webview)

        webView.webViewClient = WebViewClient()
        webView.loadUrl(urlWeb)
    }

}
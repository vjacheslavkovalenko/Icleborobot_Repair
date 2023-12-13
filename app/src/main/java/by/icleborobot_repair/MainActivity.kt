package by.icleborobot_repair

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    var urlWeb = getString(R.string.website_url)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val webView = findViewById<WebView>(R.id.xml_webview)

        webView = findViewById(R.id.xml_webview)
        webView.webViewClient = WebViewClient()
        webView.loadUrl(urlWeb)
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

}
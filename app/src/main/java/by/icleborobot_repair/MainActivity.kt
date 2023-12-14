package by.icleborobot_repair

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.webkit.WebView
import android.webkit.WebViewClient
import by.icleborobot_repair.databinding.ActivityMainBinding
import by.icleborobot_repair.databinding.ContentMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var binding_content: ContentMainBinding

   // val webView = findViewById<WebView>(R.id.xml_webview)

//нижеидущую строчку добавил:
 //   lateinit var webView:WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding_content=ContentMainBinding.inflate(layoutInflater)
        setContentView(binding_content.root)

        val urlWeb = getString(R.string.website_url)
        binding_content.xmlWebview.loadUrl(urlWeb)
        binding_content.xmlWebview.settings.javaScriptEnabled=true
        binding_content.xmlWebview.webViewClient = WebViewClient()

        //val urlWeb = getString(R.string.website_url)
        //изменил это на нижеидущее:
        //val webView = findViewById<WebView>(R.id.xml_webview)
       // webView = findViewById<WebView>(R.id.xml_webview)


        //webView.webViewClient = WebViewClient()
        //webView.loadUrl(urlWeb)

       // val webSettings=webView.settings

       // webSettings.javaScriptEnabled=true

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check whether the key event is the Back button and if there's history.
        if (keyCode == KeyEvent.KEYCODE_BACK && binding_content.xmlWebview.canGoBack()) {
            binding_content.xmlWebview.goBack()
            return true
        }
        // If it isn't the Back button or there isn't web page history, bubble up to
        // the default system behavior. Probably exit the activity.
        return super.onKeyDown(keyCode, event)
    }


}
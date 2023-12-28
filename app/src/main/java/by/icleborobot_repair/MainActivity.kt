package by.icleborobot_repair

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.KeyEvent
import android.view.Menu
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import by.icleborobot_repair.databinding.ActivityMainBinding
import by.icleborobot_repair.databinding.ContentMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var binding_content: ContentMainBinding
    private lateinit var dialog : AlertDialog
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    //private var progressBar = findViewById<ProgressBar>(R.id.progressBar)
    // val webView = findViewById<WebView>(R.id.xml_webview)

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding_content=ContentMainBinding.inflate(layoutInflater)
        setContentView(binding_content.root)

        val urlWeb = getString(R.string.website_url)
        binding_content.xmlWebview.loadUrl(urlWeb)
        binding_content.xmlWebview.settings.javaScriptEnabled=true
        binding_content.xmlWebview.webViewClient = WebViewClient()


        dialog = MaterialAlertDialogBuilder(this , R.style.MaterialAlertDialog_Rounded)
            .setView(R.layout.custom_dialog)
            .setCancelable(false)
            .create()

        val networkManager = NetworkManager(this)
        networkManager.observe(this){

            if (!it){
                if (!dialog.isShowing)
                    dialog.show()
            }else{
                if (dialog.isShowing)
                    dialog.hide()
            }
        }

        binding_content.xmlWebview.webViewClient = object : WebViewClient() {
            val progressBar= findViewById<ProgressBar>(R.id.progressBar)
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = View.VISIBLE
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?){
                progressBar.visibility = View.GONE
                super.onPageFinished(view, url)
            }

        }

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener (this)

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

    override fun onRefresh() {
        Handler(Looper.getMainLooper()).postDelayed({
            Toast.makeText(this, "Обновлено", Toast.LENGTH_LONG).show()
            swipeRefreshLayout.isRefreshing = false
        }, 300)
    }


}
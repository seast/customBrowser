package com.example.custombrowser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
 
public class WebViewActivity extends Activity {
 
    private WebView webView;
        
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
 
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.google.com");
        webView.setWebViewClient(new MyAppWebViewClient());
        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        webView.setWebChromeClient(new WebChromeClient(){     
          @Override
          public void onProgressChanged(WebView view, int progress){
            if(progress == 100) {
                 progressBar.setVisibility(View.GONE);
            } else {
              progressBar.setVisibility(View.VISIBLE);
              progressBar.setProgress(progress);
            }
          }
        });
    }
    
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
          webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
package com.example.challenge1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        WebView webviewAbout = findViewById(R.id.webview_about);

        WebSettings webSettings = webviewAbout.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webviewAbout.setWebViewClient(new WvClient());
        webviewAbout.loadUrl("https://andela.com/alc");
    }

    private class WvClient extends WebViewClient {
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }
}

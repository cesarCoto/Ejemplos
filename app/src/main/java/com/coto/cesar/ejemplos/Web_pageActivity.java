package com.coto.cesar.ejemplos;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class Web_pageActivity extends AppCompatActivity {

    WebView webView_launch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        webView_launch = (WebView) findViewById(R.id.web_launcher);

        Bundle bundle = getIntent().getExtras();
        String web = bundle.getString("Pagina");

        webView_launch.loadUrl(web);

        //Botton  ir atras
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }
}

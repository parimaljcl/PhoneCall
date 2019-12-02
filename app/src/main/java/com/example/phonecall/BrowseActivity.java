package com.example.phonecall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class BrowseActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        webView=findViewById(R.id.webview);
        //WebView webView=new WebView(this);
        //setContentView(webView);

        showWebView();

    }

private void showWebView()
{
    if (ContextCompat.checkSelfPermission(BrowseActivity.this,
            Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
        ActivityCompat.requestPermissions(BrowseActivity.this, new String []{Manifest.permission.INTERNET},10);
        //return;

    }
    else {
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://google.com/");
        //Toast.makeText(BrowseActivity.this,"Browse Activity",Toast.LENGTH_SHORT).show();
    }
}
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==10){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {
                showWebView();
            }
        }
    }

}

package vn.edu.usth.wikipedia;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    WebView wb;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        wb = (WebView) findViewById(R.id.web_view);
        wb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wb.loadUrl("https://www.wikipedia.org/");
    }

    public class myWebViewClient extends WebViewClient{
        @Override
        public void onPageFinished(WebView view, String url){
            super.onPageFinished(view, url);
            pb.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view,url);
        }


    }
        @Override
        public void onBackPressed(){
            super.onBackPressed();
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event){
            if((keyCode == KeyEvent.KEYCODE_BACK) && wb.canGoBack()){
                wb.goBack();
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }



}

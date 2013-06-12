package com.almyz125.rpitv;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class About extends Activity {

	private WebView about;
	private String fileAbout, fileError;
	final Activity activity = this;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		fileAbout = "file:///android_asset/html/about.html";
		fileError = "file:///android_asset/html/error.html";
		about = (WebView) this.findViewById(R.id.aboutView);
		about.getSettings().setJavaScriptEnabled(true);
		about.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(activity,"Well that wasnt supposed to happen...",
						Toast.LENGTH_LONG).show();
				about.loadUrl(fileError);
			}
		});
		about.loadUrl(fileAbout);
	}
}
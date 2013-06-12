package com.almyz125.rpitv;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Remote extends Activity {
	private WebView remote;
	private String url, uri, fileError;
	final Activity activity = this;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remote);
		fileError = "file:///android_asset/html/error.html";
		remote = (WebView) this.findViewById(R.id.remoteView);
		remote.getSettings().setJavaScriptEnabled(true);
		remote.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(activity,
						description + "\nCheck your IP and Port.",
						Toast.LENGTH_LONG).show();
				remote.loadUrl(fileError);
			}
		});
		load();
	}

	public void load() {
		url = "http://" + Information.url + ":" + Information.port + "/remote";
		uri = Uri.parse(url).toString();
		remote.loadUrl(uri);
	}

	@Override
	public void onBackPressed() {
		finish();
	}
}
package org.meizhuo.oneapp.app.ui.fragment;

import org.meizhuo.oneapp.app.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebSettings.LayoutAlgorithm;

@SuppressLint("SetJavaScriptEnabled")
public class OnePicutreFragment extends Fragment implements OnRefreshListener {
	WebView webview;
	String url = "http://etips.u.qiniudn.com/static/onepicture.html";
	SwipeRefreshLayout swipeLayout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_onepicture, container,
				false);
		swipeLayout = (SwipeRefreshLayout) v
				.findViewById(R.id.swipeRefreshLayout);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_blue_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_blue_light);
		webview = (WebView) v.findViewById(R.id.webview_onePicture);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl(url);
		if (!swipeLayout.isRefreshing())
			swipeLayout.setRefreshing(true);
		webview.setWebChromeClient(new MyWebChromeClient());
		return v;
	}

	@Override
	public void onRefresh() {
		webview.loadUrl(url);
	}

	class MyWebChromeClient extends WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			if (newProgress == 100) {
				swipeLayout.setRefreshing(false);
			}
		}
	}
}

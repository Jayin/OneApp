package org.meizhuo.oneapp.app.ui.fragment;

import org.meizhuo.oneapp.app.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class OneArticleFragment extends Fragment implements OnRefreshListener {

	WebView webview;
	String url = "http://etips.u.qiniudn.com/static/onearticle.html";
	SwipeRefreshLayout swipeLayout;
    String contentBody;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_onearticle, container,
				false);
		swipeLayout = (SwipeRefreshLayout) v
				.findViewById(R.id.swipeRefreshLayout);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
				android.R.color.holo_blue_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_blue_light);
		webview = (WebView) v.findViewById(R.id.webview_oneArticle);
		webview.getSettings().setJavaScriptEnabled(true);

		if (!swipeLayout.isRefreshing())
			swipeLayout.setRefreshing(true);
		webview.setWebChromeClient(new MyWebChromeClient());

		
		contentBody = "LOL!";
		// webview.loadUrl(url);
		webview.addJavascriptInterface(new WebAppInterface(getActivity()), "fromAndroid");
		webview.loadUrl("file:///android_asset/preview.html");
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

	private class WebAppInterface {
		Context mContext;

		/** Instantiate the interface and set the context */
		WebAppInterface(Context c) {
			mContext = c;
		}
		
		public String getContent(){
			return contentBody;
		}
	}

}

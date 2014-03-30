package org.meizhuo.oneapp.app.ui.fragment;

import org.meizhuo.oneapp.app.R;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

@SuppressLint("SetJavaScriptEnabled")
public class OnePicutreFragment extends Fragment {
	WebView webview;
	String url = "http://etips.u.qiniudn.com/static/onepicture.html";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_onepicture, container,
				false);
		webview = (WebView) v.findViewById(R.id.webview_onePicture);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl(url);
		return v;
	}
}

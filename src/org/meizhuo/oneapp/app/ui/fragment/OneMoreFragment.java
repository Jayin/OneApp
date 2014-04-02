package org.meizhuo.oneapp.app.ui.fragment;

import org.meizhuo.oneapp.app.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class OneMoreFragment extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_onemore, container, false);
		v.findViewById(R.id.btn_score).setOnClickListener(this);
		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_score:
			String mAddress = "market://details?id="+ getActivity().getPackageName();
			Intent marketIntent = new Intent("android.intent.action.VIEW");
			marketIntent.setData(Uri.parse(mAddress));
			startActivity(marketIntent);
			break;
		default:
			break;
		}
	}
}

package org.meizhuo.oneapp.app;

import org.meizhuo.oneapp.app.ui.BaseActivity;
import org.meizhuo.oneapp.app.ui.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AppStart extends BaseActivity {
    private boolean isDestroy = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_appstart);
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (!isDestroy) {
					startActivity(new Intent(getContext(), Main.class));
					closeActivity();
				}
			}
		}, 1000);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		isDestroy = true;
	}

	@Override
	protected void initData() {
		
	}

	@Override
	protected void initLayout() {
		
	}

}

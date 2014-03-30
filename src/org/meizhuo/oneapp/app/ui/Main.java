package org.meizhuo.oneapp.app.ui;

import java.util.ArrayList;
import java.util.List;

import org.meizhuo.oneapp.app.R;
import org.meizhuo.oneapp.app.ui.adapter.MainFragmentPagerAdapter;
import org.meizhuo.oneapp.app.ui.fragment.OneArticleFragment;
import org.meizhuo.oneapp.app.ui.fragment.OneMoreFragment;
import org.meizhuo.oneapp.app.ui.fragment.OnePicutreFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class Main extends BaseActivity implements TabListener {
	ActionBar mActionBar;
	String[] title = { "Picture", "Article", "More" };
	ViewPager viewpager;
	List<Fragment> fragments = new ArrayList<Fragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acty_main);
		initData();
		initLayout();
	}

	@Override
	protected void initData() {

	}

	@Override
	protected void initLayout() {
		mActionBar = getActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		viewpager = (ViewPager) _getView(R.id.viewpager);
		fragments.add(new OnePicutreFragment());
		fragments.add(new OneArticleFragment());
		fragments.add(new OneMoreFragment());
		viewpager.setAdapter(new MainFragmentPagerAdapter(
				getSupportFragmentManager(), fragments));

		viewpager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						mActionBar.setSelectedNavigationItem(position);
					}
				});

		mActionBar.removeAllTabs();
		for (int i = 0; i < title.length; i++) {
			mActionBar.addTab(mActionBar.newTab().setText(title[i])
					.setTabListener(this));
		}
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		viewpager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}
}

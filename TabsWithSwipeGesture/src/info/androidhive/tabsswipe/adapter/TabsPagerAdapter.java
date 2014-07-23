
//////////////////////////////////////////////////
// OptimusMobile Android Project
// File: TabsPagerAdapter.java
//
// This tells which pagefragment to be used at which 
// navigation tab which decided by the index.
//////////////////////////////////////////////////

package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.ShowAllRemindersFragment;
import info.androidhive.tabsswipe.GoogleMapsFragment;
import info.androidhive.tabsswipe.AddReminderFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new AddReminderFragment();
		case 1:
			// Games fragment activity
			return new ShowAllRemindersFragment();
		case 2:
			// Movies fragment activity
			return new GoogleMapsFragment();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}
	
}


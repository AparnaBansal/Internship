//////////////////////////////////////////////////
// OptimusMobile Android Project
// File: ExpandableList.java
//
// This contains the list of the expandable items and the group names.
// 
//////////////////////////////////////////////////


package info.androidhive.tabsswipe;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.tabsswipe.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class GoogleMapsFragment extends Fragment {

	List<String> groupList;
    List<String> childList;
    Map<String, List<String>> Collection;
    ExpandableListView expListView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.activity, container, false);
			
		return rootView;
	}
	
 
}

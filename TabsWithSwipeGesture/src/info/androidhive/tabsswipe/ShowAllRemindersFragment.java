//////////////////////////////////////////////////
// OptimusMobile Android Project
// File: ListviewCustomAdapter.java
//
// Creates the listview that contains textview, 
// imageview and checkbox till 100 entries.
//////////////////////////////////////////////////


package info.androidhive.tabsswipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import info.androidhive.tabsswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowAllRemindersFragment extends Fragment {

	private DatabaseController controller;;
	private ListView listView;
	String[] valuesCategory;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.showallreminder, container, false);
		controller=new DatabaseController(getActivity());
		ArrayList<String> employeeList =  controller.getAllPlaceSearch();
		Log.i("the data", "in browse");
		if(employeeList.size()!=0) {
			
			listView=(ListView)rootView.findViewById(R.id.listShowReminders);
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.textview ,employeeList );
			
			listView.setAdapter(adapter);
			Log.i("the data", String.valueOf(employeeList.size()));
		}
		else
			Log.i("the data", String.valueOf(employeeList.size()));
		return rootView;
	}
}

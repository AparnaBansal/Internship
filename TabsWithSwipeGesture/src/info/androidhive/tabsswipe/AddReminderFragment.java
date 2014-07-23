//////////////////////////////////////////////////
// OptimusMobile Android Project
// File: GridviewSdcardImage.java
//
// This java file takes all the images from the sdcard 
// folder and send them to gridView to set the data gridview.
//////////////////////////////////////////////////


package info.androidhive.tabsswipe;





import java.util.HashMap;

import android.os.Bundle;
import android.provider.SyncStateContract.Constants;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddReminderFragment extends Fragment {

	private EditText whatTodo;
	private AutoCompleteTextView category;
	private String selectedCategory=null;
	private Button clickToSubmit,addAnotherField;
	private ListView listViewCategory;
	private String[] places;
	DatabaseController controller;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.addreminder, container, false);
		whatTodo=(EditText)rootView.findViewById(R.id.whatToDo);
		category=(AutoCompleteTextView)rootView.findViewById(R.id.category);
		clickToSubmit=(Button)rootView.findViewById(R.id.clickToSubmit);
		addAnotherField=(Button)rootView.findViewById(R.id.addAnotherField);
		listViewCategory=(ListView)rootView.findViewById(R.id.listViewCategory);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),R.layout.textview ,getResources().getStringArray(R.array.list_of_places) );
		listViewCategory.setAdapter(adapter);
		
		places = getResources().getStringArray(R.array.list_of_places);
		ArrayAdapter adapterAutoListView = new ArrayAdapter(this.getActivity(),
				android.R.layout.simple_list_item_1, places);
		category.setThreshold(1);
		
		category.setAdapter(adapter);
		
		category.setOnClickListener(listener);
		clickToSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		addAnotherField.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HashMap<String, String> queryValues =  new  HashMap<String, String>();
				queryValues.put("ToDo", whatTodo.getText().toString());
				queryValues.put("Category", category.getText().toString());
				controller=new DatabaseController(getActivity());
				controller.insertPlaceSearch(queryValues);
				Toast.makeText(getActivity(), "Data Inserted, Please add another data", Toast.LENGTH_SHORT).show();
				whatTodo.setText("");
				category.setText("");
			}
		});
		return rootView;
	}
private OnClickListener listener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			category.showDropDown();
		}
	};
}

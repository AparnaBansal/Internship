package info.androidhive.tabsswipe;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Constants;
import android.util.Log;
import android.widget.Toast;

public class DatabaseController extends SQLiteOpenHelper {
	Context context;
	public DatabaseController(Context applicationcontext) {
        super(applicationcontext, "androidPlace.db", null, 1);
        context=applicationcontext;
        Log.i("Log","Created");
    }
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		String query;
		query = "CREATE TABLE placeSearch ( ToDo TEXT ,Category TEXT)";
        database.execSQL(query);
        Log.i("tag","placeSearch Created");
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
		String query;
		query = "DROP TABLE IF EXISTS placeSearch";
		database.execSQL(query);
        onCreate(database);
	}
	
	public int insertPlaceSearch(HashMap<String, String> queryValues) {
		int i=0;
		SQLiteDatabase database =null;
		try{
			database=this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("ToDo", queryValues.get("ToDo"));
			values.put("Category", queryValues.get("Category"));
			database.insert("placeSearch", null, values);
			database.close();
			
		}
		catch (SQLiteException e){
	        Log.e("tag","insert()",e);
		}
		return i;
				
	}
	
	public ArrayList<String> getAllPlaceSearch() {
		ArrayList<HashMap<String, String>> wordList;
		wordList = new ArrayList<HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM placeSearch";
	    SQLiteDatabase database = this.getWritableDatabase();
	    ArrayList<String> list=new ArrayList<String>();
	    Cursor cursor = database.rawQuery(selectQuery, null);
	    if (cursor.moveToFirst()) {
	        do {
	        	
	        //	map.put("ToDo", cursor.getString(0));
	        	list.add(cursor.getString(1));
	        	
               // wordList.add(map);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return list;
	}
	
	
/*	public ArrayList<HashMap<String, String>> getAllSpecificEmployee(String sp,String val) {
		ArrayList<HashMap<String, String>> wordList;
		wordList = new ArrayList<HashMap<String, String>>();
		String selectQuery = null;
		if((sp.compareTo("Designation"))==0)
			selectQuery = "SELECT  * FROM employee WHERE "+Constants.desgination+"= '"+val+"'";
		else if((sp.compareTo("EmployeeCode"))==0)
				selectQuery = "SELECT  * FROM employee WHERE "+Constants.empCode+"= '"+val+"'";
		else
		{
			String[] retval;
			retval=val.split(" ");
			selectQuery="SELECT * FROM employee WHERE "+Constants.firstName+"= '"+retval[0]+"' AND "+Constants.lastName+"= '"+retval[1]+"'";
		}
	//	Toast.makeText(context,selectQuery,Toast.LENGTH_SHORT).show();
	    SQLiteDatabase database = this.getWritableDatabase();
	    Cursor cursor = database.rawQuery(selectQuery,null);
	    if (cursor.moveToFirst()) {
	        do {
	        	HashMap<String, String> map = new HashMap<String, String>();
	        	map.put(Constants.firstName, cursor.getString(0));
	        	map.put(Constants.lastName, cursor.getString(1));
	        	map.put(Constants.desgination, cursor.getString(2));
	        	map.put(Constants.empCode, cursor.getString(3));
	        	map.put(Constants.tagLine, cursor.getString(4));
	        	map.put(Constants.department, cursor.getString(5));
	        	map.put(Constants.imgPath, cursor.getString(6));
	        	wordList.add(map);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return wordList;
	}*/

}

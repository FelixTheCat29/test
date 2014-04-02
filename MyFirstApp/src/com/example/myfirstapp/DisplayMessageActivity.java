package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends Activity {
	/*	Because the ActionBar APIs are available only on HONEYCOMB (API level 11) and higher, 
	 you must add the @SuppressLint("NewApi") tag to the onCreate() method to avoid lint errors.
*/	@SuppressLint("NewApi")
	  
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    // Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
	
	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);
	
	    // Set the text view as the activity layout
	    setContentView(textView);
	    
	    getActionBar().setDisplayHomeAsUpEnabled(true); //Sets the actionbar
	    Log.i("MY_MESSAGE", "onCreate (DisplayMessageActivity)");
	    Log.i("Git test","Git test");
	}

	@Override
	protected void onResume() {
		super.onResume();
		Log.i("MY_MESSAGE", "in onResume (DisplayMessageActivity)");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.i("MY_MESSAGE", "in onPause (DisplayMessageActivity)");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("MY_MESSAGE", "in onStop (DisplayMessageActivity)");
	}


	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			/*	Because the ActionBar APIs are available only on HONEYCOMB (API level 11) and higher, 
			 * you must add a condition around the getActionBar() method to check the current platform version.
			*/
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}
	
	
	/** To place the menu items into the action bar.
	 * Implements the onCreateOptionsMenu() callback method in your activity 
	 * to inflate the menu resource into the given Menu object.*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu); // Refers to /res/menu/main.xml 
	    return super.onCreateOptionsMenu(menu);
	}

	/** handles action bar activity */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search: // Search button
	            openSearch();
	            return true;
	        case R.id.action_settings: //Settings button
	            openSettings();
	            return true;
	        
	        case android.R.id.home: //Up button
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	            
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	 
	}
	
	public void openSearch() {
		Toast t = Toast.makeText(getApplicationContext(), "I would now call Search", Toast.LENGTH_LONG);
		t.show();
	}
	
	public void openSettings() {
		Toast t = Toast.makeText(getApplicationContext(), "I would now call Settings", Toast.LENGTH_LONG);
		t.show();
	}
	
}

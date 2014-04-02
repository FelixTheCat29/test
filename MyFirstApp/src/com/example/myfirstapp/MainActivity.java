package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	//This string will be sent to the intent when the send button is pressed
	 public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    
	 /** Called when the app launches */
	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Refers to the activity_main XML file under /res/layout
        //the default Activity class starts and loads a layout file
        Log.i("MY_MESSAGE", "in onCreate (MainActivity)");
	 }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu); //refers to main.xml under res/menu
        return true;
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	Log.i("MY_MESSAGE", "in onResume (MainActivity)");
    }
   
    @Override
    protected void onPause() {
    	super.onPause();
    	Log.i("MY_MESSAGE", "in onPause (MainActivity)");
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	Log.i("MY_MESSAGE", "in onStop (MainActivity)");
    }
   
    
    /** Called when the user clicks the Send button */
    /** Sends the message the user has typed, converted to string as and "extra" of the intent sent to new activity */
    public void sendMessage(View view) {
    	
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //Constructs and intent to start the new activity triggered by button push with 2 parameters:
        // 1) "this" of type context 
        // 2) Class of the app component that will deliver the intent
        
        EditText editText = (EditText)findViewById(R.id.edit_message);
        //return type of findViewById: View
        //findViewById (int id) Added in API level 1
        //Finds a view that was identified by the id attribute from the XML that was processed in onCreate(Bundle).
        //Returns The view if found or null otherwise.
        
        String message = editText.getText().toString();
        
        intent.putExtra(EXTRA_MESSAGE, message);
        // An Intent can carry a collection of various data types as key-value pairs called extras.
        //The putExtra() method takes the key name in the first parameter and the value in the second parameter.
        
        startActivity(intent);
        //Starts the activity with the intent constructed
    }
}

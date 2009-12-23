package com.droidled.demo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	static final String[] LISTITEMS = { "Toggle LED" };
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, LISTITEMS);
        setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// normally we'd look at the position and figure out what to do, but there's only one item, so let's
		// just go ahead and toggle the led
        try {
        	DroidLED led = new DroidLED();
        	led.enable(!led.isEnabled());
        }
        catch(Exception e) {
        	Toast.makeText(this, "Error interacting with LED.", Toast.LENGTH_SHORT).show();
        }        
	}	
}
package com.kaleidoscope.kmessenger;

import java.util.zip.Inflater;

import com.kaleidoscope.core.MessageItem;
import com.kaleidoscope.core.MessagePopupCreator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
private static int counter=-1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		int ID=getIDfromCounter();
		
		MessageItem sender=new MessageItem(ID, "Saini", null, null, null);
		MessageItem messageSent=new MessageItem(sender.getID(), "Hii", null);
		MessageItem messageReceived=new MessageItem(sender.getID(), null, "Hii..there");
		
		MessagePopupCreator creator=new MessagePopupCreator(getApplicationContext());
		creator.addMSGinContainer(messageSent);
		creator.addMSGinContainer(messageReceived);
		
		
		
		
	}
	private int getIDfromCounter() {
		++counter;
		return counter;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

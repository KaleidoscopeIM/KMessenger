package com.kaleidoscope.kmessenger;

import java.lang.reflect.Array;
import java.util.zip.Inflater;

import com.kaleidoscope.core.MessageItem;
import com.kaleidoscope.core.MessagePopupCreator;

import android.app.Activity;
import android.app.usage.UsageEvents.Event;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
private static int counter=-1;
public static String KTAG="KMessenger";
public static WindowManager kWindowManager;
private View dotView;
private LayoutInflater inflatorMain;
private MessagePopupCreator popUpCreator=null;
ImageView dotImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		dotImage=(ImageView)findViewById(R.id.dotImage);
		int ID=getIDfromCounter();
		
		kWindowManager=(WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
		inflatorMain=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		MessageItem sender=new MessageItem(ID, "Saini", null, null, null);
		MessageItem messageSent=new MessageItem(sender.getID(), "Hii", null);
		MessageItem messageReceived=new MessageItem(sender.getID(), null, "Hii..there");
		
		popUpCreator=new MessagePopupCreator(getApplicationContext());
		popUpCreator.addMSGinContainer(messageSent);
		popUpCreator.addMSGinContainer(messageReceived);
		
		
		
		
		
	}
	@Override
		public boolean onTouchEvent(MotionEvent event) {
			int[] location=new int[2];
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				Log.d(MainActivity.KTAG, "hii there"+event.getX()+"    "+event.getY());
				location[0]=(int) event.getX();
				location[1]=(int) event.getY();
				dotImage.setX(location[0]);
				dotImage.setY(location[1]);
				popUpCreator.showPopup(location,dotView);
			}
			
			Toast.makeText(MainActivity.this, "Hii tererr...", Toast.LENGTH_SHORT);
			return super.onTouchEvent(event);
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

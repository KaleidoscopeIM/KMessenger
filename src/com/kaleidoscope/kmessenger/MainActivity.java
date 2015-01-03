package com.kaleidoscope.kmessenger;

import com.kaleidoscope.core.MessageItem;
import com.kaleidoscope.core.MessageAdaptor;
import com.kaleidoscope.core.MessagePopupWindow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	private static int counter=-1;
	public static String KTAG="KMessenger";
	public static WindowManager windowManagerMain=null;
	private MessageAdaptor msgAdaptor=null;
	ImageView dotImage;
	private Context context;
	MessagePopupWindow popUpWindow=null;
	public static LayoutInflater layoutInflatorMain=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		context=MainActivity.this;
		
		dotImage=(ImageView)findViewById(R.id.dotImage);
		
		windowManagerMain=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		layoutInflatorMain=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		Log.d(MainActivity.KTAG,"Setting up application");
	}
	@Override
		public boolean onTouchEvent(MotionEvent event) {
			int[] location=new int[2];
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				Log.d(MainActivity.KTAG,"event point at x="+event.getX()+" y="+event.getY());
				location[0]=(int) event.getX();
				location[1]=(int) event.getY();
				dotImage.setX(location[0]);
				dotImage.setY(location[1]);
				
				infiniteLoopApp(location);
				
			}
			
			return super.onTouchEvent(event);
		}
	private void infiniteLoopApp(int[] location) {
		
		int ID=getIDfromCounter();
		popUpWindow=new MessagePopupWindow(context);
		msgAdaptor=new MessageAdaptor(context);
		MessageItem sender=new MessageItem(ID, "Saini", null, null, null);
		MessageItem messageSent=new MessageItem(sender.getID(), "Hii", null);
		MessageItem messageReceived=new MessageItem(sender.getID(), null, "Hii..there");
		popUpWindow.showPopup(location);
		msgAdaptor.addMSGinContainer(popUpWindow,messageSent);
		msgAdaptor.addMSGinContainer(popUpWindow,messageReceived);
		
	}
	private int getIDfromCounter() {
		++counter;
		Log.d(MainActivity.KTAG,"counter is : "+MainActivity.counter);
		return counter;

	}
}

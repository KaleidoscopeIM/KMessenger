package com.kaleidoscope.kmessenger;

import com.kaleidoscope.core.MessageItem;
import com.kaleidoscope.core.MessageAdaptor;
import com.kaleidoscope.core.MessagePopupWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	
	private static int counter=-1;
	public static String KTAG="KMessenger";
	public static WindowManager windowManagerMain=null;
	private MessageAdaptor msgAdaptor=null;
	ImageView dotImage;
	private Context context;
	MessagePopupWindow currentPopup=null;
	public static LayoutInflater layoutInflatorMain=null;
	RelativeLayout mainLayout=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		context=MainActivity.this;
		
		mainLayout=(RelativeLayout)findViewById(R.id.layout_main);
		
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
				
				createDotImageAtLocation(location);
				
				infiniteLoopApp(location);
				
			}
			
			return super.onTouchEvent(event);
		}
	private void createDotImageAtLocation(int[] location) {
		
		ImageView dotView=new ImageView(context);
		dotView.setBackgroundResource(R.drawable.dot);
		dotView.setClickable(true);
		dotView.setFocusable(true);
		
		mainLayout.addView(dotView);
		dotView.setX(location[0]-23);
		dotView.setY(location[1]-23);
		
	}
	private void infiniteLoopApp(int[] location) {
		
		int ID=getIDfromCounter();
		//MessagePopupWindow popUpWindow;
		//popUpWindow=new MessagePopupWindow(context);
		msgAdaptor=new MessageAdaptor(context);
		MessageItem sender=new MessageItem(ID, "Saini", null, null, null);
		MessageItem messageSent=new MessageItem(sender.getID(), "Hii", null);
		MessageItem messageReceived=new MessageItem(sender.getID(), null, "Hii..there");
		//popUpWindow.showPopup(location);
		msgAdaptor.addMSGinContainer(messageSent);
		msgAdaptor.addMSGinContainer(messageReceived);
		msgAdaptor.showPopup(location);
		
	}
	
	private int getIDfromCounter() {
		++counter;
		Log.d(MainActivity.KTAG,"counter is : "+MainActivity.counter);
		return counter;

	}
}

package com.kaleidoscope.core;

import com.kaleidoscope.kmessenger.MainActivity;

import com.kaleidoscope.kmessenger.R;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MessagePopupWindow{
	
	protected View kRootView;
	protected TextView kUserName;
	protected ScrollView kScrollView;
	protected LinearLayout kMSGContainer=null;
	protected EditText kEnterMSG;
	protected Button kButtonSend;
	protected ImageView imageUP;
	protected ImageView imageDOWN;
	protected PopupWindow popUP;
	
	public MessagePopupWindow(Context con)
	{
		Log.d(MainActivity.KTAG,"constructor of MessagePopupWindow");
		
		kRootView =MainActivity.layoutInflatorMain.inflate(R.layout.container, null);
		kUserName=(TextView) kRootView.findViewById(R.id.userName);
		kScrollView=(ScrollView) kRootView.findViewById(R.id.scrollView);
		kMSGContainer=(LinearLayout) kRootView.findViewById(R.id.msgContainer);
		kEnterMSG=(EditText) kRootView.findViewById(R.id.editTextMSG);
		kButtonSend=(Button) kRootView.findViewById(R.id.buttonSend);
		imageUP=(ImageView)kRootView.findViewById(R.id.image_up);
		imageDOWN=(ImageView)kRootView.findViewById(R.id.image_down);
		
		popUP=new PopupWindow(con);
		
		init();
		
	}
	public void addMSG(TextView item, int pos)
	{
		if(kMSGContainer!=null)
		{
			kMSGContainer.addView(item, pos);
			Log.d(MainActivity.KTAG,"successfully added msg in contaner");
		}
		else
			Log.d(MainActivity.KTAG,"kMSGContainer is null");
	}
	public void preShow()
	{
		
	}
	public void init()
	{
		Log.d(MainActivity.KTAG,"inside init() method");
		if(kRootView==null)
		{
			Log.d(MainActivity.KTAG,"cannnot create a popup");
			//return;
		}else{
			popUP.setBackgroundDrawable(new BitmapDrawable());
			popUP.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
			popUP.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
			popUP.setFocusable(true);
			popUP.setTouchable(true);
			popUP.setOutsideTouchable(true);
			popUP.setContentView(kRootView);
			
			Log.d(MainActivity.KTAG,"init method done");
		}
	}
	public void postShow()
	{
		
	}
	
	
	public void showPopupAtPosition(int x1, int y1)
	{
		Log.d(MainActivity.KTAG,"calling final show at location");
		popUP.showAtLocation(kRootView, Gravity.NO_GRAVITY, x1, y1);
	}
	

}

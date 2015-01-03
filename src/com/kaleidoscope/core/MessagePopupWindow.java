package com.kaleidoscope.core;

import com.kaleidoscope.kmessenger.MainActivity;

import com.kaleidoscope.kmessenger.R;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MessagePopupWindow extends PopupWindow{
	
	private Context contextPopup;
	private Drawable background=null;
	protected View kRootView;
	private TextView kUserName;
	private ScrollView kScrollView;
	private LinearLayout kMSGContainer=null;
	private EditText kEnterMSG;
	private Button kButtonSend;
	
	public MessagePopupWindow(Context con)
	{
		Log.d(MainActivity.KTAG,"constructor of MessagePopupWindow");
		
		contextPopup=con;
		kRootView =MainActivity.layoutInflatorMain.inflate(R.layout.container, null);
		kUserName=(TextView) kRootView.findViewById(R.id.userName);
		kScrollView=(ScrollView) kRootView.findViewById(R.id.scrollView);
		kMSGContainer=(LinearLayout) kRootView.findViewById(R.id.msgContainer);
		kEnterMSG=(EditText) kRootView.findViewById(R.id.editTextMSG);
		kButtonSend=(Button) kRootView.findViewById(R.id.buttonSend);
		
		init();
		
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
			setBackgroundDrawable(new BitmapDrawable());
			setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
			setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
			setFocusable(true);
			setTouchable(true);
			setOutsideTouchable(true);
			setContentView(kRootView);
			
			Log.d(MainActivity.KTAG,"init method done");
		}
	}
	public void postShow()
	{
		
	}
	public void dismiss()
	{/*if(popup!=null)
		{
			popup.dismiss();
		}*/
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
	
	public void showPopup(int[] location) {
		
		Log.d(MainActivity.KTAG,"inside method showPopUP");
		int xPosition,yPosition;
		 
		kRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		int screenHeight=MainActivity.windowManagerMain.getDefaultDisplay().getHeight();
		int screenWidth=MainActivity.windowManagerMain.getDefaultDisplay().getWidth();
		int rootHeight=kRootView.getMeasuredHeight();
		int rootWidth=kRootView.getMeasuredWidth();
		if(location[0]+rootWidth>screenWidth)
		{
			xPosition=screenWidth-location[0];
		}else
		{
			xPosition=location[0];
		}
		int top=location[1];
		int bottom=screenHeight-location[1];
		if(top>bottom)
		{
			if(rootHeight>location[1])
			{
				LayoutParams parm=(LayoutParams) kScrollView.getLayoutParams();
				parm.height=location[1];
				yPosition=10;
			}else
			{
				yPosition=top-location[1];
			}
			
			
		}else
		{
			if(rootHeight>bottom)
			{
				LayoutParams l=(LayoutParams) kScrollView.getLayoutParams();
				l.height=bottom-10;
				yPosition=location[1];
			}else
			{
				yPosition=location[1];
			}
		}
		showPopupAtPosition(xPosition,yPosition);
		
	}
	public void showPopupAtPosition(int x1, int y1)
	{
		Log.d(MainActivity.KTAG,"calling final show at location");
		showAtLocation(kRootView, Gravity.NO_GRAVITY, x1, y1);
	}
	

}

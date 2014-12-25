package com.kaleidoscope.core;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MessagePopupWindow {
	private Context contextPopup;
	private Drawable background=null;
	private PopupWindow popup=null;
	private View rootView;
	private WindowManager winManager;
	private LayoutInflater inflator=null;
	
	public MessagePopupWindow(Context con)
	{
		this.contextPopup=con;
		popup=new PopupWindow(contextPopup);
		winManager=(WindowManager)contextPopup.getSystemService(contextPopup.WINDOW_SERVICE);
		popup.setTouchInterceptor(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if(event.getAction()==event.ACTION_OUTSIDE)
				{
					popup.dismiss();
					return true;
				}
				return false;
			}
		});
	}
	public void preShow()
	{
		
	}
	public void init()
	{
		if(rootView==null)
		{
			Toast.makeText(contextPopup, "unable to create popUp", Toast.LENGTH_SHORT);
		}
			popup.setBackgroundDrawable(new BitmapDrawable());
			popup.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
			popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
			popup.setFocusable(true);
			popup.setTouchable(true);
			popup.setOutsideTouchable(true);
			popup.setContentView(rootView);
			
	}
	public void postShow()
	{
		
	}
	public void dismiss()
	{
		if(popup!=null)
		{
			popup.dismiss();
		}
	}
	public void setPopupLayout(int layoutID)
	{
		inflator=(LayoutInflater)contextPopup.getSystemService(contextPopup.LAYOUT_INFLATER_SERVICE);
		//setContentView(inflator.inflate(layoutID, viewGroup));
	}
	public void setRootView(View root)
	{
		this.rootView=root;
	}

}

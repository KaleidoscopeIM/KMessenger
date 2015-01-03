package com.kaleidoscope.core;

import com.kaleidoscope.kmessenger.MainActivity;
import com.kaleidoscope.kmessenger.R.drawable;

import android.R.string;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MessageItem {
	private int msgID=-1;
	private String sender;
	private String sentMSG=null;
	private String receivedMSG=null;
	private EditText enterMSG=null;
	private Drawable icon;
	private Button sendButton;
	private boolean isSticky;
	private boolean isSelected;
	public MessageItem(int ID,String sender, Drawable icon, EditText ET, Button btn) {
		this.sender=sender;
		this.msgID=ID;
		this.icon=icon;
		this.enterMSG=ET;
		this.sendButton=btn;
		Log.d(MainActivity.KTAG,"message item created");
	}
	public MessageItem(int ID ,String sendM ,String RecM )
	{
		this.msgID=ID;
		this.sentMSG=sendM;
		this.receivedMSG=RecM;
		Log.d(MainActivity.KTAG,"message item created");
	}
	public String getSentMSG()
	{
		return sentMSG;
	}
	public String getReceivedMSG()
	{
		return receivedMSG;
	}
	//get and set for selected messages
	public void setSelected()
	{
		isSelected=true;
	}
	public boolean getSelected()
	{
		return isSelected;
	}
	//get and set for sticky items
	public void setSticky(boolean value)
	{
		isSticky=value;
	}
	public boolean getSticky()
	{
		return isSticky;
	}
	//get and set for bitmap
	public void setIcon(Drawable thumb)
	{
		this.icon=thumb;
	}
	public Drawable getBitmap()
	{
		return this.icon;
	}
	//get and set for ID
	public void setID(int id)
	{
		msgID=id;
	}
	public int getID()
	{
		return msgID;
	}

}

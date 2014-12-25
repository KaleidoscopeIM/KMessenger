package com.kaleidoscope.core;

import android.graphics.Bitmap;
import android.widget.Button;
import android.widget.EditText;

public class MessageItem {
	private int msgID=-1;
	private String sender;
	private String senderMSG;
	private String receivedMSG;
	private EditText enterMSG;
	private Bitmap thumbnail;
	private Button sendButton;
	private boolean isSticky;
	private boolean isSelected;
	public MessageItem(int ID,String senderM,String receiveM,Bitmap thumb, boolean sticky, boolean selected) {
		this.sender=sender;
		this.senderMSG=senderM;
		this.receivedMSG=receiveM;
		this.msgID=ID;
		this.thumbnail=thumb;
		
		this.isSticky=sticky;
		this.isSelected=selected;
		
	}
	public MessageItem(int ID,EditText editText)
	{
		this.enterMSG=editText;
	}
	public MessageItem(int ID, Button btn)
	{
		this.sendButton=btn;
	}
	public MessageItem(int ID, String sender,String sendM ,String RecM )
	{
		this.msgID=ID;
		this.sender=sender;
		this.senderMSG=sendM;
		this.receivedMSG=RecM;
	}
	public MessageItem(EditText editText)
	{
		this.enterMSG=editText;
	}
	public MessageItem(Button button)
	{
		this.sendButton=button;
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
	public void setBitmap(Bitmap thumb)
	{
		this.thumbnail=thumb;
	}
	public Bitmap getBitmap()
	{
		return this.thumbnail;
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

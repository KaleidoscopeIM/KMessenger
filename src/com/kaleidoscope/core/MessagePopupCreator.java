package com.kaleidoscope.core;

import java.util.ArrayList;
import java.util.List;

import com.kaleidoscope.kmessenger.R;

import android.app.SearchManager.OnDismissListener;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MessagePopupCreator extends MessagePopupWindow implements OnDismissListener{
	private List<MessageItem> MSGItemList=new ArrayList<MessageItem>();
	Context kContext;
	private static LayoutInflater kInflator;
	public View kRootView;
	private TextView kUserName;
	private ScrollView kScrollView;
	private LinearLayout kMSGContainer;
	private EditText kEnterMSG;
	private Button kButtonSend;
	private String sentMSG;
	private String receivedMSG;
	private int userID;
	private TextView kMessage=null;
	private LayoutParams gravityLayout;
	public MessagePopupCreator(Context con) {
		super(con);
		kContext=con;
		kInflator=(LayoutInflater)kContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		kRootView=(ViewGroup)kInflator.inflate(R.layout.container, null);
		kUserName=(TextView) kRootView.findViewById(R.id.userName);
		kScrollView=(ScrollView) kRootView.findViewById(R.id.scrollView);
		kMSGContainer=(LinearLayout) kRootView.findViewById(R.id.msgContainer);
		kEnterMSG=(EditText) kRootView.findViewById(R.id.editTextMSG);
		kButtonSend=(Button) kRootView.findViewById(R.id.buttonSend);
		//this is for cheking app is crashing
		//kRootView.setLayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		setViewInPopup(kRootView);
	}
	public void addMSGinContainer(MessageItem message) {
		sentMSG=message.getSentMSG();
		receivedMSG=message.getReceivedMSG();
		userID=message.getID();
		kMessage=new TextView(kContext);
		//start from here
		
		
		if(sentMSG==null || receivedMSG==null)
		{
			if(sentMSG !=null)
				kMessage.setText(sentMSG);
			if(receivedMSG!=null)
				kMessage.setText(receivedMSG);
			
		}
	}
	@Override
	public void onDismiss() {
	}
	
	
}

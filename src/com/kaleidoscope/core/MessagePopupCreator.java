package com.kaleidoscope.core;

import java.util.ArrayList;
import java.util.List;

import com.kaleidoscope.kmessenger.MainActivity;
import com.kaleidoscope.kmessenger.R;

import android.app.SearchManager.OnDismissListener;
import android.content.Context;
import android.content.IntentSender.SendIntentException;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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
	private static int msgPosition=0;
	private int[] arrowPosition;
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
		gravityLayout =new LayoutParams();
		
		if(sentMSG!=null || receivedMSG!=null)
		{
			if(sentMSG !=null)
			{	kMessage.setText(sentMSG);
				gravityLayout.gravity=Gravity.RIGHT;
			}
			else
			{
				kMessage.setText(receivedMSG);
				gravityLayout.gravity=Gravity.LEFT;
			}
			kMessage.setLayoutParams(gravityLayout);
			kMSGContainer.addView(kMessage, msgPosition);
			msgPosition++;
		}
	}
	@Override
	public void onDismiss() {
	}
	public void showPopup(int[] location,View v) {
		int xPosition,yPosition;
		arrowPosition=new int[2];
		arrowPosition=location; 
		Log.d(MainActivity.KTAG, "got location of pointer :"+location[0]+" and "+location[1]);
		kRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		int screenHeight=MainActivity.kWindowManager.getDefaultDisplay().getHeight();
		int screenWidth=MainActivity.kWindowManager.getDefaultDisplay().getWidth();
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
		popup.showAsDropDown(v);
		
	}
	
	
}

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

public class MessageAdaptor extends MessagePopupWindow implements OnDismissListener{
	
	private List<MessageItem> MSGItemList=new ArrayList<MessageItem>();
	private Context kContext;
	
	private String sentMSG;
	private String receivedMSG;
	private int userID;
	private TextView kMessage=null;
	private LayoutParams gravityLayout;
	private static int msgPosition=0;
	
	public MessageAdaptor(Context con) {
		super(con);
		kContext=con;
		// TODO Auto-generated constructor stub
	}
	
	public void addMSGinContainer(MessageItem message) {
		Log.d(MainActivity.KTAG,"inside method addMSGinContainer");
		sentMSG=message.getSentMSG();
		receivedMSG=message.getReceivedMSG();
		userID=message.getID();
		kMessage=new TextView(kContext);
		if(sentMSG!=null || receivedMSG!=null)
		{
			if(sentMSG !=null)
			{	kMessage.setText(sentMSG);
				//gravityLayout.gravity=Gravity.RIGHT;
			}
			else
			{
				kMessage.setText(receivedMSG);
				//gravityLayout.gravity=Gravity.LEFT;
			}
			//kMessage.setLayoutParams(gravityLayout);
			//kMSGContainer.addView(kMessage, msgPosition);
			Log.d(MainActivity.KTAG,"message is "+kMessage.getText());
			addMSG(kMessage, msgPosition);
			msgPosition++;
		}
	}
	
	
	public void showPopup(int[] location) {
		
		Log.d(MainActivity.KTAG,"inside method showPopUP");
		int xPosition,yPosition;
		 
		kRootView.measure(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		int screenHeight=MainActivity.windowManagerMain.getDefaultDisplay().getHeight();
		int screenWidth=MainActivity.windowManagerMain.getDefaultDisplay().getWidth();
		int rootHeight=kRootView.getMeasuredHeight();
		int rootWidth=kRootView.getMeasuredWidth();
		Log.d(MainActivity.KTAG,"screenHeight: "+screenHeight+" screenWidth: "+screenWidth+" rootHeight: "+rootHeight+" rootWidth: "+rootWidth);
		if(location[0]+rootWidth>screenWidth)
		{
			xPosition=screenWidth-location[0];
		}else
		{
			xPosition=location[0]/2;
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
			imageDOWN.setVisibility(View.VISIBLE);
			imageDOWN.setLeft(location[0]);
			ViewGroup.MarginLayoutParams lp=(ViewGroup.MarginLayoutParams)imageDOWN.getLayoutParams();
			lp.leftMargin=location[0];
			imageDOWN.setLayoutParams(lp);
			
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
			imageUP.setVisibility(View.VISIBLE);
			//imageUP.setLeft(location[0]);
		}
		Log.d(MainActivity.KTAG,"xPosition :"+xPosition+" yPositon:"+yPosition);
		showPopupAtPosition(xPosition,yPosition);
		
	}
	@Override
	public void onDismiss() {
		// TODO Auto-generated method stub
		if(popUP!=null)
		{
			popUP.dismiss();
		}
		
	}
	
	
	
	
}

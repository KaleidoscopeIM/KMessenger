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

public class MessageAdaptor implements OnDismissListener{
	private List<MessageItem> MSGItemList=new ArrayList<MessageItem>();
	private Context kContext;
	public View kRootView;
	private String sentMSG;
	private String receivedMSG;
	private int userID;
	private TextView kMessage=null;
	private LayoutParams gravityLayout;
	private static int msgPosition=0;
	private int[] arrowPosition;
	public MessageAdaptor(Context con) {
		
		kContext=con;
		
	}
	public void addMSGinContainer(MessagePopupWindow obj,MessageItem message) {
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
			obj.addMSG(kMessage, msgPosition);
			msgPosition++;
		}
	}
	@Override
	public void onDismiss() {
	}
	
	
	
}

package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.warriorbattle.R;

import controller.Menu.WarriorInformation;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Item extends Activity {
	private int possessed = 0, equipped = 0, action = 0;
	private String result;
	private String warrior_gold;
	private String warrior_user, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg;
	private String possession_item1, possession_item2, possession_item3, possession_item4, possession_item5, possession_item6, possession_item7, possession_item8, possession_item9, possession_item10, possession_item11, possession_item12;
	private String rightHand_id, rightHand_name, rightHand_type, rightHand_armor, rightHand_dps, rightHand_strength, rightHand_critical;
	private String leftHand_id, leftHand_name, leftHand_type, leftHand_armor, leftHand_dps, leftHand_strength, leftHand_critical;
	private String head_id, head_name, head_life, head_armor;
	private String body_id, body_name, body_life, body_armor;
	private String leg_id, leg_name, leg_life, leg_armor;
	private String item_id, item_type, item_price, itemString;
	private TextView textItem;
	private Button buttonAction;
	private Handler handlerBuy, handlerEquip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.item);
		// Gets the previously created intent
		Intent item = getIntent();		
		// Will return Extra values
		warrior_user = item.getStringExtra("warrior_user");
		warrior_rightHand = item.getStringExtra("warrior_rightHand");
		warrior_leftHand = item.getStringExtra("warrior_leftHand");
		warrior_head = item.getStringExtra("warrior_head");
		warrior_body = item.getStringExtra("warrior_head");
		warrior_leg = item.getStringExtra("warrior_leg");
		warrior_gold = item.getStringExtra("warrior_gold");
		possession_item1 = item.getStringExtra("possession_item1");
		possession_item2 = item.getStringExtra("possession_item2");
		possession_item3 = item.getStringExtra("possession_item3");
		possession_item4 = item.getStringExtra("possession_item4");
		possession_item5 = item.getStringExtra("possession_item5");
		possession_item6 = item.getStringExtra("possession_item6");
		possession_item7 = item.getStringExtra("possession_item7");
		possession_item8 = item.getStringExtra("possession_item8");
		possession_item9 = item.getStringExtra("possession_item9");
		possession_item10 = item.getStringExtra("possession_item10");
		possession_item11 = item.getStringExtra("possession_item11");
		possession_item12 = item.getStringExtra("possession_item12");
		rightHand_id = item.getStringExtra("rightHand_id");
		rightHand_name = item.getStringExtra("rightHand_name");
		rightHand_type = item.getStringExtra("rightHand_type");
		rightHand_armor = item.getStringExtra("rightHand_armor");
		rightHand_dps = item.getStringExtra("rightHand_dps");
		rightHand_strength = item.getStringExtra("rightHand_strength");
		rightHand_critical = item.getStringExtra("rightHand_critical");
		leftHand_id = item.getStringExtra("leftHand_id");
		leftHand_name = item.getStringExtra("leftHand_name");
		leftHand_type = item.getStringExtra("leftHand_type");
		leftHand_armor = item.getStringExtra("leftHand_armor");
		leftHand_dps = item.getStringExtra("leftHand_dps");
		leftHand_strength = item.getStringExtra("leftHand_strength");
		leftHand_critical = item.getStringExtra("leftHand_critical");
		head_id = item.getStringExtra("head_id");
		head_name = item.getStringExtra("head_name");
		head_life = item.getStringExtra("head_life");
		head_armor = item.getStringExtra("head_armor");
		body_id = item.getStringExtra("body_id");
		body_name = item.getStringExtra("body_name");
		body_life = item.getStringExtra("body_life");
		body_armor = item.getStringExtra("body_armor");
		leg_id = item.getStringExtra("leg_id");
		leg_name = item.getStringExtra("leg_name");
		leg_life = item.getStringExtra("leg_life");
		leg_armor = item.getStringExtra("leg_armor");
		item_id = item.getStringExtra("item_id");
		item_type = item.getStringExtra("item_type");
		item_price = item.getStringExtra("item_price");
		
		/*
		 * TEXTVIEW
		 */
		
		//TextView textFight
		textItem = (TextView)findViewById(R.id.textItem);
		
		/*
		 * BUTTON
		 */
		
		// Button buttonAction
		buttonAction = (Button)findViewById(R.id.buttonAction);
		
		/*
		 * MAIN PROCESS
		 */
		
		// Check if item is possessed
		if(item_id.equals(possession_item1)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item2)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item3)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item4)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item5)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item6)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item7)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item8)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item9)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item10)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item11)) {
			possessed = 1;
		}
		if(item_id.equals(possession_item12)) {
			possessed = 1;
		}
		
		// Check if item is equipped
		if (possessed == 1) {
			if(item_id.equals(rightHand_id)) {
				equipped = 1;
			}
			if(item_id.equals(leftHand_id)) {
				equipped = 1;
			}
			if(item_id.equals(head_id)) {
				equipped = 1;
			}
			if(item_id.equals(body_id)) {
				equipped = 1;
			}
			if(item_id.equals(leg_id)) {
				equipped = 1;
			}
		}
		
		// Action Button: Buy, Equip, Equipped
		if (possessed == 0) {
			// CLICK TO BUY
			buttonAction.setText("Click To Buy");
			action = 1;
		}
		else {
			if (equipped == 0) {
				// CLICK TO EQUIP
				buttonAction.setText("Click To Equip");
				action = 2;
			}
			else {
				// EQUIPPED
				buttonAction.setText("Already Equipped");
				action = 3;
			}
		}
		//itemString = item_id + " // " + item_type + " // " + warrior_user + "\n";
		//itemString = itemString + " // " + warrior_rightHand + " // " + warrior_leftHand + " // " + warrior_head + " // " + warrior_body + " // " + warrior_leg;
		//textItem.setText(itemString);
		
		buttonAction.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				switch(action) {
					case 1:
						// CLICK TO BUY
						
						/*
						 * GET BUY ITEM
						 */
						if (Integer.parseInt(item_price) <= Integer.parseInt(warrior_gold)) {
							warrior_gold = Integer.toString((Integer.parseInt(warrior_gold) - Integer.parseInt(item_price)));
							new BuyItem().execute(new DatabaseConnection());				
							handlerBuy = new Handler() {
								public void handleMessage(Message myMessage) {
									result = myMessage.getData().getString("result");
									if (result.equals("True")) {
										Intent startMenu = new Intent(Item.this, Menu.class);
										startMenu.putExtra("userId", warrior_user);
										startActivity(startMenu);
									}
									else {
										itemString = "Missing Data!";
										textItem.setText(itemString);
									}
								}
							};
						}
						else {
							itemString = "Not enough money!";
							textItem.setText(itemString);
						}
						break;
					case 2:
						// CLICK TO EQUIP
						
						/*
						 * GET EQUIP ITEM
						 */
						
						if(item_type.equals("1")) {
							warrior_leftHand = warrior_rightHand;
							warrior_rightHand = item_id;
						}
						if(item_type.equals("2")) {
							warrior_rightHand = item_id;
							warrior_leftHand = "null";
						}
						if(item_type.equals("3")) {
							warrior_head = item_id;
						}
						if(item_type.equals("4")) {
							warrior_body = item_id;
						}
						if(item_type.equals("5")) {
							warrior_leg = item_id;
						}
						new EquipItem().execute(new DatabaseConnection());				
						handlerEquip = new Handler() {
							public void handleMessage(Message myMessage) {
								result = myMessage.getData().getString("result");
								if (result.equals("True")) {
									Intent startMenu = new Intent(Item.this, Menu.class);
				            		startMenu.putExtra("userId", warrior_user);
									startActivity(startMenu);
								}
								else {
									itemString = "Missing Data!";
									textItem.setText(itemString);
								}
							}
						};
						break;
					case 3:
						// EQUIPPED
						Intent startMenu = new Intent(Item.this, Menu.class);
	            		startMenu.putExtra("userId", warrior_user);
						startActivity(startMenu);
						break;
				}
			}
		});
	}
	
	/*
	 * THREAD BUY ITEM
	 */
	
	public class BuyItem extends AsyncTask<DatabaseConnection, Long, JSONObject> {
		@Override
		protected JSONObject doInBackground(DatabaseConnection... params) {
			// It's executed on background thread.
			return params[0].BuyItem(warrior_user, item_id, warrior_gold);
		}
		@Override
		protected void onPostExecute(JSONObject joBuyItem) {
			try {
				result = (joBuyItem.getString("result"));
				
				// Creates a message to send to our UI thread.
				Message myMessage = new Message();
				// Creates the data for the message.
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle.
				databundle.putString("result", result);
				myMessage.setData(databundle);
				// Sends the message to the handler.
				handlerBuy.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	/*
	 * THREAD EQUIP ITEM
	 */
	
	public class EquipItem extends AsyncTask<DatabaseConnection, Long, JSONObject> {
		@Override
		protected JSONObject doInBackground(DatabaseConnection... params) {
			// It's executed on background thread.
			return params[0].EquipItem(warrior_user, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg);
		}
		@Override
		protected void onPostExecute(JSONObject joEquipItem) {
			try {
				result = (joEquipItem.getString("result"));
				
				// Creates a message to send to our UI thread.
				Message myMessage = new Message();
				// Creates the data for the message.
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle.
				databundle.putString("result", result);
				myMessage.setData(databundle);
				// Sends the message to the handler.
				handlerEquip.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
}

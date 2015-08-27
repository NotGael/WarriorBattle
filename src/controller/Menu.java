package controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.warriorbattle.R;

public class Menu extends Activity {
	// ON fait le get * des info du perso ici comme ça on le fait une fois pendant l ouverture de l'app et on utilise pas la connection internet à chaque fois qu'on change de menu
	private int userId, first = 0, check1 = 0, check2 = 0, check3 = 0;
	private String textResult, warrior_user, warrior_name, warrior_level, warrior_life, warrior_armor, warrior_dps, warrior_strength, warrior_critical, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg, warrior_gold, warrior_xp;
	private String possession_item1, possession_item2, possession_item3, possession_item4, possession_item5, possession_item6, possession_item7, possession_item8, possession_item9, possession_item10, possession_item11, possession_item12;
	private String rightHand_id, rightHand_name, rightHand_type, rightHand_armor, rightHand_dps, rightHand_strength, rightHand_critical;
	private String leftHand_id, leftHand_name, leftHand_type, leftHand_armor, leftHand_dps, leftHand_strength, leftHand_critical;
	private String head_id, head_name, head_life, head_armor;
	private String body_id, body_name, body_life, body_armor;
	private String leg_id, leg_name, leg_life, leg_armor;
	private String item_type;
	private Button buttonWarrior, buttonShop, buttonArena;
	private TextView textError;
	private static Handler handlerWarrior, handlerPossession, handlerItem;
	ArrayList<String> possessionList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.menu);
		
		/* 
		 * GET EXTRA
		 */
		
		// Gets the previously created intent
		Intent startMenu = getIntent();
		// Will return Extra values
		userId = Integer.parseInt(startMenu.getStringExtra("userId"));

		/*
		 * BUTTON 
		 */
		
		// Button Warrior
		buttonWarrior=(Button)findViewById(R.id.buttonWarrior);
		buttonWarrior.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent warrior = new Intent(Menu.this, Warrior.class);
				warrior.putExtra("warrior_user", warrior_user);
				warrior.putExtra("warrior_name", warrior_name);
				warrior.putExtra("warrior_level", warrior_level);
				warrior.putExtra("warrior_life", warrior_life);
				warrior.putExtra("warrior_armor", warrior_armor);
				warrior.putExtra("warrior_dps", warrior_dps);
				warrior.putExtra("warrior_strength", warrior_strength);
				warrior.putExtra("warrior_critical", warrior_critical);
				warrior.putExtra("warrior_rightHand", warrior_rightHand);
				warrior.putExtra("warrior_leftHand", warrior_leftHand);
				warrior.putExtra("warrior_head", warrior_head);
				warrior.putExtra("warrior_body", warrior_body);
				warrior.putExtra("warrior_leg", warrior_leg);
				warrior.putExtra("warrior_gold", warrior_gold);
				warrior.putExtra("warrior_xp", warrior_xp);
				warrior.putExtra("possession_item1", possession_item1);
				warrior.putExtra("possession_item2", possession_item2);
				warrior.putExtra("possession_item3", possession_item3);
				warrior.putExtra("possession_item4", possession_item4);
				warrior.putExtra("possession_item5", possession_item5);
				warrior.putExtra("possession_item6", possession_item6);
				warrior.putExtra("possession_item7", possession_item7);
				warrior.putExtra("possession_item8", possession_item8);
				warrior.putExtra("possession_item9", possession_item9);
				warrior.putExtra("possession_item10", possession_item10);
				warrior.putExtra("possession_item11", possession_item11);
				warrior.putExtra("possession_item12", possession_item12);
				warrior.putExtra("rightHand_id", rightHand_id);
				warrior.putExtra("rightHand_name", rightHand_name);
				warrior.putExtra("rightHand_type", rightHand_type);
				warrior.putExtra("rightHand_armor", rightHand_armor);
				warrior.putExtra("rightHand_dps", rightHand_dps);
				warrior.putExtra("rightHand_strength", rightHand_strength);
				warrior.putExtra("rightHand_critical", rightHand_critical);
				warrior.putExtra("leftHand_id", leftHand_id);
				warrior.putExtra("leftHand_name", leftHand_name);
				warrior.putExtra("leftHand_type", leftHand_type);
				warrior.putExtra("leftHand_armor", leftHand_armor);
				warrior.putExtra("leftHand_dps", leftHand_dps);
				warrior.putExtra("leftHand_strength", leftHand_strength);
				warrior.putExtra("leftHand_critical", leftHand_critical);
				warrior.putExtra("head_id", head_id);
				warrior.putExtra("head_name", head_name);
				warrior.putExtra("head_life", head_life);
				warrior.putExtra("head_armor", head_armor);
				warrior.putExtra("body_id", body_id);
				warrior.putExtra("body_name", body_name);
				warrior.putExtra("body_life", body_life);
				warrior.putExtra("body_armor", body_armor);
				warrior.putExtra("leg_id", leg_id);
				warrior.putExtra("leg_name", leg_name);
				warrior.putExtra("leg_life", leg_life);
				warrior.putExtra("leg_armor", leg_armor);
				startActivity(warrior);
			}
		});
		// Button Shop
		buttonShop=(Button)findViewById(R.id.buttonShop);
		buttonShop.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent warrior = new Intent(Menu.this, Shop.class);
				warrior.putExtra("warrior_user", warrior_user);
				warrior.putExtra("warrior_name", warrior_name);
				warrior.putExtra("warrior_level", warrior_level);
				warrior.putExtra("warrior_life", warrior_life);
				warrior.putExtra("warrior_armor", warrior_armor);
				warrior.putExtra("warrior_dps", warrior_dps);
				warrior.putExtra("warrior_strength", warrior_strength);
				warrior.putExtra("warrior_critical", warrior_critical);
				warrior.putExtra("warrior_rightHand", warrior_rightHand);
				warrior.putExtra("warrior_leftHand", warrior_leftHand);
				warrior.putExtra("warrior_head", warrior_head);
				warrior.putExtra("warrior_body", warrior_body);
				warrior.putExtra("warrior_leg", warrior_leg);
				warrior.putExtra("warrior_gold", warrior_gold);
				warrior.putExtra("warrior_xp", warrior_xp);
				warrior.putExtra("possession_item1", possession_item1);
				warrior.putExtra("possession_item2", possession_item2);
				warrior.putExtra("possession_item3", possession_item3);
				warrior.putExtra("possession_item4", possession_item4);
				warrior.putExtra("possession_item5", possession_item5);
				warrior.putExtra("possession_item6", possession_item6);
				warrior.putExtra("possession_item7", possession_item7);
				warrior.putExtra("possession_item8", possession_item8);
				warrior.putExtra("possession_item9", possession_item9);
				warrior.putExtra("possession_item10", possession_item10);
				warrior.putExtra("possession_item11", possession_item11);
				warrior.putExtra("possession_item12", possession_item12);
				warrior.putExtra("rightHand_id", rightHand_id);
				warrior.putExtra("rightHand_name", rightHand_name);
				warrior.putExtra("rightHand_type", rightHand_type);
				warrior.putExtra("rightHand_armor", rightHand_armor);
				warrior.putExtra("rightHand_dps", rightHand_dps);
				warrior.putExtra("rightHand_strength", rightHand_strength);
				warrior.putExtra("rightHand_critical", rightHand_critical);
				warrior.putExtra("leftHand_id", leftHand_id);
				warrior.putExtra("leftHand_name", leftHand_name);
				warrior.putExtra("leftHand_type", leftHand_type);
				warrior.putExtra("leftHand_armor", leftHand_armor);
				warrior.putExtra("leftHand_dps", leftHand_dps);
				warrior.putExtra("leftHand_strength", leftHand_strength);
				warrior.putExtra("leftHand_critical", leftHand_critical);
				warrior.putExtra("head_id", head_id);
				warrior.putExtra("head_name", head_name);
				warrior.putExtra("head_life", head_life);
				warrior.putExtra("head_armor", head_armor);
				warrior.putExtra("body_id", body_id);
				warrior.putExtra("body_name", body_name);
				warrior.putExtra("body_life", body_life);
				warrior.putExtra("body_armor", body_armor);
				warrior.putExtra("leg_id", leg_id);
				warrior.putExtra("leg_name", leg_name);
				warrior.putExtra("leg_life", leg_life);
				warrior.putExtra("leg_armor", leg_armor);
				startActivity(warrior);
			}
		});
		// Button Arena
		buttonArena=(Button)findViewById(R.id.buttonArena);
		buttonArena.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent warrior = new Intent(Menu.this, Arena.class);
				warrior.putExtra("warrior_user", warrior_user);
				warrior.putExtra("warrior_name", warrior_name);
				warrior.putExtra("warrior_level", warrior_level);
				warrior.putExtra("warrior_life", warrior_life);
				warrior.putExtra("warrior_armor", warrior_armor);
				warrior.putExtra("warrior_dps", warrior_dps);
				warrior.putExtra("warrior_strength", warrior_strength);
				warrior.putExtra("warrior_critical", warrior_critical);
				warrior.putExtra("warrior_rightHand", warrior_rightHand);
				warrior.putExtra("warrior_leftHand", warrior_leftHand);
				warrior.putExtra("warrior_head", warrior_head);
				warrior.putExtra("warrior_body", warrior_body);
				warrior.putExtra("warrior_leg", warrior_leg);
				warrior.putExtra("warrior_gold", warrior_gold);
				warrior.putExtra("warrior_xp", warrior_xp);
				warrior.putExtra("possession_item1", possession_item1);
				warrior.putExtra("possession_item2", possession_item2);
				warrior.putExtra("possession_item3", possession_item3);
				warrior.putExtra("possession_item4", possession_item4);
				warrior.putExtra("possession_item5", possession_item5);
				warrior.putExtra("possession_item6", possession_item6);
				warrior.putExtra("possession_item7", possession_item7);
				warrior.putExtra("possession_item8", possession_item8);
				warrior.putExtra("possession_item9", possession_item9);
				warrior.putExtra("possession_item10", possession_item10);
				warrior.putExtra("possession_item11", possession_item11);
				warrior.putExtra("possession_item12", possession_item12);
				warrior.putExtra("rightHand_id", rightHand_id);
				warrior.putExtra("rightHand_name", rightHand_name);
				warrior.putExtra("rightHand_type", rightHand_type);
				warrior.putExtra("rightHand_armor", rightHand_armor);
				warrior.putExtra("rightHand_dps", rightHand_dps);
				warrior.putExtra("rightHand_strength", rightHand_strength);
				warrior.putExtra("rightHand_critical", rightHand_critical);
				warrior.putExtra("leftHand_id", leftHand_id);
				warrior.putExtra("leftHand_name", leftHand_name);
				warrior.putExtra("leftHand_type", leftHand_type);
				warrior.putExtra("leftHand_armor", leftHand_armor);
				warrior.putExtra("leftHand_dps", leftHand_dps);
				warrior.putExtra("leftHand_strength", leftHand_strength);
				warrior.putExtra("leftHand_critical", leftHand_critical);
				warrior.putExtra("head_id", head_id);
				warrior.putExtra("head_name", head_name);
				warrior.putExtra("head_life", head_life);
				warrior.putExtra("head_armor", head_armor);
				warrior.putExtra("body_id", body_id);
				warrior.putExtra("body_name", body_name);
				warrior.putExtra("body_life", body_life);
				warrior.putExtra("body_armor", body_armor);
				warrior.putExtra("leg_id", leg_id);
				warrior.putExtra("leg_name", leg_name);
				warrior.putExtra("leg_life", leg_life);
				warrior.putExtra("leg_armor", leg_armor);
				startActivity(warrior);
			}
		});
		
		/*
		 * TEXTVIEW 
		 */
		
		// TextView textError
		textError=(TextView)findViewById(R.id.textError);
		
		/*
		 * GET ALL WARRIOR INFORMATION
		 */
		
		new WarriorInformation().execute(new DatabaseConnection());				
		handlerWarrior = new Handler() {
			public void handleMessage(Message myMessage) {
				warrior_user = (myMessage.getData().getString("warrior_user"));
				warrior_name = (myMessage.getData().getString("warrior_name"));
				warrior_level = (myMessage.getData().getString("warrior_level"));
				warrior_life = (myMessage.getData().getString("warrior_life"));
				warrior_armor = (myMessage.getData().getString("warrior_armor"));
				warrior_dps = (myMessage.getData().getString("warrior_dps"));
				warrior_strength = (myMessage.getData().getString("warrior_strength"));
				warrior_critical = (myMessage.getData().getString("warrior_critical"));
				warrior_rightHand = (myMessage.getData().getString("warrior_rightHand"));
				warrior_leftHand = (myMessage.getData().getString("warrior_leftHand"));
				warrior_head = (myMessage.getData().getString("warrior_head"));
				warrior_body = (myMessage.getData().getString("warrior_body"));
				warrior_leg = (myMessage.getData().getString("warrior_leg"));
				warrior_gold = (myMessage.getData().getString("warrior_gold"));
				warrior_xp = (myMessage.getData().getString("warrior_xp"));
				//textResult = warrior_user + "\n" + warrior_name + "\n" + warrior_level + "\n" + warrior_life + "\n" + warrior_armor + "\n" + warrior_dps + "\n" + warrior_strength + "\n" + warrior_critical + "\n" + warrior_rightHand + "\n" + warrior_leftHand + "\n" + warrior_head + "\n" + warrior_body + "\n" + warrior_leg + "\n" + warrior_gold + "\n" + warrior_xp;
				//textError.setText(textResult);
				//check1 = 1;
			}
		};
		
		/*
		 * GET ALL POSSESSION INFORMATION
		 */
		
		new PossessionInformation().execute(new DatabaseConnection());		
		handlerPossession = new Handler() {
			public void handleMessage(Message myMessage) {
				possession_item1 = (myMessage.getData().getString("possession_item1"));
				possession_item2 = (myMessage.getData().getString("possession_item2"));
				possession_item3 = (myMessage.getData().getString("possession_item3"));
				possession_item4 = (myMessage.getData().getString("possession_item4"));
				possession_item5 = (myMessage.getData().getString("possession_item5"));
				possession_item6 = (myMessage.getData().getString("possession_item6"));
				possession_item7 = (myMessage.getData().getString("possession_item7"));
				possession_item8 = (myMessage.getData().getString("possession_item8"));
				possession_item9 = (myMessage.getData().getString("possession_item9"));
				possession_item10 = (myMessage.getData().getString("possession_item10"));
				possession_item11 = (myMessage.getData().getString("possession_item11"));
				possession_item12 = (myMessage.getData().getString("possession_item12"));
			}
		};
			
		/*
		 * GET ALL ITEM INFORMATION
		 */
			
		new ItemInformation().execute(new DatabaseConnection());		
		handlerItem = new Handler() {
			public void handleMessage(Message myMessage) {
				rightHand_id = (myMessage.getData().getString("rightHand_id"));
				rightHand_name = (myMessage.getData().getString("rightHand_name"));
				rightHand_type = (myMessage.getData().getString("rightHand_type"));
				rightHand_armor = (myMessage.getData().getString("rightHand_armor"));
				rightHand_dps = (myMessage.getData().getString("rightHand_dps"));
				rightHand_strength = (myMessage.getData().getString("rightHand_strength"));
				rightHand_critical = (myMessage.getData().getString("rightHand_critical"));
				leftHand_id = (myMessage.getData().getString("leftHand_id"));
				leftHand_name = (myMessage.getData().getString("leftHand_name"));
				leftHand_type = (myMessage.getData().getString("leftHand_type"));
				leftHand_armor = (myMessage.getData().getString("leftHand_armor"));
				leftHand_dps = (myMessage.getData().getString("leftHand_dps"));
				leftHand_strength = (myMessage.getData().getString("leftHand_strength"));
				leftHand_critical = (myMessage.getData().getString("leftHand_critical"));
				head_id = (myMessage.getData().getString("head_id"));
				head_name = (myMessage.getData().getString("head_name"));
				head_life = (myMessage.getData().getString("head_life"));
				head_armor = (myMessage.getData().getString("head_armor"));
				body_id = (myMessage.getData().getString("body_id"));
				body_name = (myMessage.getData().getString("body_name"));
				body_life = (myMessage.getData().getString("body_life"));
				body_armor = (myMessage.getData().getString("body_armor"));
				leg_id = (myMessage.getData().getString("leg_id"));
				leg_name = (myMessage.getData().getString("leg_name"));
				leg_life = (myMessage.getData().getString("leg_life"));
				leg_armor = (myMessage.getData().getString("leg_armor"));
			}
		};
	}
	
	/*
	 * THREAD WARRIOR INFORMATION
	 */
	
	public class WarriorInformation extends AsyncTask<DatabaseConnection, Long, JSONArray> {
		@Override
		protected JSONArray doInBackground(DatabaseConnection... params) {
			// It's executed on background thread
			return params[0].WarriorInformation(userId);
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayWarrior) {
			try {
				JSONObject dataArrayWarrior = jsonArrayWarrior.getJSONObject(0);
				warrior_user = dataArrayWarrior.getString("warrior_user");
				warrior_name = dataArrayWarrior.getString("warrior_name");
				warrior_level = dataArrayWarrior.getString("warrior_level");
				warrior_life = dataArrayWarrior.getString("warrior_life");
				warrior_armor = dataArrayWarrior.getString("warrior_armor");
				warrior_dps = dataArrayWarrior.getString("warrior_dps");
				warrior_strength = dataArrayWarrior.getString("warrior_strength");
				warrior_critical = dataArrayWarrior.getString("warrior_critical");
				warrior_rightHand = dataArrayWarrior.getString("warrior_rightHand");
				warrior_leftHand = dataArrayWarrior.getString("warrior_leftHand");
				warrior_head = dataArrayWarrior.getString("warrior_head");
				warrior_body = dataArrayWarrior.getString("warrior_body");
				warrior_leg = dataArrayWarrior.getString("warrior_leg");
				warrior_gold = dataArrayWarrior.getString("warrior_gold");
				warrior_xp = dataArrayWarrior.getString("warrior_xp");
				// Creates a message to send to our UI thread
				Message myMessage = new Message();
				// Creates the data for the message
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle
				databundle.putString("warrior_user", warrior_user);
				databundle.putString("warrior_name",  warrior_name);
				databundle.putString("warrior_level",  warrior_level);
				databundle.putString("warrior_life",  warrior_life);
				databundle.putString("warrior_armor",  warrior_armor);
				databundle.putString("warrior_dps",  warrior_dps);
				databundle.putString("warrior_strength",  warrior_strength);
				databundle.putString("warrior_critical",  warrior_critical);
				databundle.putString("warrior_rightHand",  warrior_rightHand);
				databundle.putString("warrior_leftHand",  warrior_leftHand);
				databundle.putString("warrior_head",  warrior_head);
				databundle.putString("warrior_body",  warrior_body);
				databundle.putString("warrior_leg",  warrior_leg);
				databundle.putString("warrior_gold",  warrior_gold);
				databundle.putString("warrior_xp",  warrior_xp);
				myMessage.setData(databundle);
				// Sends the message to the handler
				handlerWarrior.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	/*
	 * THREAD POSSESSION INFORMATION
	 */
	
	public class PossessionInformation extends AsyncTask<DatabaseConnection, Long, JSONArray> {
		@Override
		protected JSONArray doInBackground(DatabaseConnection... params) {
			// It's executed on background thread
			return params[0].PossessionInformation(userId);
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayPossession) {
			try { 
				for(int i=0; i<jsonArrayPossession.length(); i++) {
					JSONObject dataArrayPossession = jsonArrayPossession.getJSONObject(i);
					switch(i) {
						case 0:
							possession_item1 = dataArrayPossession.getString("possession_item");
							break;
						case 1:
							possession_item2 = dataArrayPossession.getString("possession_item");
							break;
						case 2:
							possession_item3 = dataArrayPossession.getString("possession_item");
							break;
						case 3:
							possession_item4 = dataArrayPossession.getString("possession_item");
							break;
						case 4:
							possession_item5 = dataArrayPossession.getString("possession_item");
							break;
						case 5:
							possession_item6 = dataArrayPossession.getString("possession_item");
							break;
						case 6:
							possession_item7 = dataArrayPossession.getString("possession_item");
							break;
						case 7:
							possession_item8 = dataArrayPossession.getString("possession_item");
							break;
						case 8:
							possession_item9 = dataArrayPossession.getString("possession_item");
							break;
						case 9:
							possession_item10 = dataArrayPossession.getString("possession_item");
							break;
						case 10:
							possession_item11 = dataArrayPossession.getString("possession_item");
							break;
						case 11:
							possession_item12 = dataArrayPossession.getString("possession_item");
							break;	
					}
				}
				// Creates a message to send to our UI thread
				Message myMessage = new Message();
				// Creates the data for the message
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle
				databundle.putString("possession_item1", possession_item1);
				databundle.putString("possession_item2", possession_item2);
				databundle.putString("possession_item3", possession_item3);
				databundle.putString("possession_item4", possession_item4);
				databundle.putString("possession_item5", possession_item5);
				databundle.putString("possession_item6", possession_item6);
				databundle.putString("possession_item7", possession_item7);
				databundle.putString("possession_item8", possession_item8);
				databundle.putString("possession_item9", possession_item9);
				databundle.putString("possession_item10", possession_item10);
				databundle.putString("possession_item11", possession_item11);
				databundle.putString("possession_item12", possession_item12);
				myMessage.setData(databundle);
				// Sends the message to the handler
				handlerPossession.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	/*
	 * THREAD ITEM INFORMATION
	 */
	
	public class ItemInformation extends AsyncTask<DatabaseConnection, Long, JSONArray> {
		@Override
		protected JSONArray doInBackground(DatabaseConnection... params) {
			// It's executed on background thread
			return params[0].ItemInformation(warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg);
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayItem) {
			try { 
				for(int i=0; i<jsonArrayItem.length(); i++) {
					JSONObject dataArrayItem = jsonArrayItem.getJSONObject(i);
					item_type = dataArrayItem.getString("item_type");
					if(item_type.equals("1")) {
						if(first == 0) {
							rightHand_id = dataArrayItem.getString("item_id");
							rightHand_name = dataArrayItem.getString("item_name");
							rightHand_type = dataArrayItem.getString("item_type");
							rightHand_armor = dataArrayItem.getString("item_armor");
							rightHand_dps = dataArrayItem.getString("item_dps");
							rightHand_strength = dataArrayItem.getString("item_strength");
							rightHand_critical = dataArrayItem.getString("item_critical");
							first = 1;
						}
						else {
							leftHand_id = dataArrayItem.getString("item_id");
							leftHand_name = dataArrayItem.getString("item_name");
							leftHand_type = dataArrayItem.getString("item_type");
							leftHand_armor = dataArrayItem.getString("item_armor");
							leftHand_dps = dataArrayItem.getString("item_dps");
							leftHand_strength = dataArrayItem.getString("item_strength");
							leftHand_critical = dataArrayItem.getString("item_critical");
						}
					}
					if(item_type.equals("2")) {
						if(first == 0) {
							rightHand_id = dataArrayItem.getString("item_id");
							rightHand_name = dataArrayItem.getString("item_name");
							rightHand_type = dataArrayItem.getString("item_type");
							rightHand_armor = dataArrayItem.getString("item_armor");
							rightHand_dps = dataArrayItem.getString("item_dps");
							rightHand_strength = dataArrayItem.getString("item_strength");
							rightHand_critical = dataArrayItem.getString("item_critical");
							first = 1;
						}
					}
					if(item_type.equals("3")) {
						head_id = dataArrayItem.getString("item_id");
						head_name = dataArrayItem.getString("item_name");
						head_life = dataArrayItem.getString("item_life");
						head_armor = dataArrayItem.getString("item_armor");
					}
					if(item_type.equals("4")) {
						body_id = dataArrayItem.getString("item_id");
						body_name = dataArrayItem.getString("item_name");
						body_life = dataArrayItem.getString("item_life");
						body_armor = dataArrayItem.getString("item_armor");
					}
					if(item_type.equals("5")) {
						leg_id = dataArrayItem.getString("item_id");
						leg_name = dataArrayItem.getString("item_name");
						leg_life = dataArrayItem.getString("item_life");
						leg_armor = dataArrayItem.getString("item_armor");
					}
				}
				// Creates a message to send to our UI thread
				Message myMessage = new Message();
				// Creates the data for the message
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle
				databundle.putString("rightHand_id", rightHand_id);
				databundle.putString("rightHand_name", rightHand_name);
				databundle.putString("rightHand_type", rightHand_type);
				databundle.putString("rightHand_armor", rightHand_armor);
				databundle.putString("rightHand_dps", rightHand_dps);
				databundle.putString("rightHand_strength", rightHand_strength);
				databundle.putString("rightHand_critical", rightHand_critical);
				databundle.putString("leftHand_id", leftHand_id);
				databundle.putString("leftHand_name", leftHand_name);
				databundle.putString("leftHand_type", leftHand_type);
				databundle.putString("leftHand_armor", leftHand_armor);
				databundle.putString("leftHand_dps", leftHand_dps);
				databundle.putString("leftHand_strength", leftHand_strength);
				databundle.putString("leftHand_critical", leftHand_critical);
				databundle.putString("head_id", head_id);
				databundle.putString("head_name", head_name);
				databundle.putString("head_life", head_life);
				databundle.putString("head_armor", head_armor);
				databundle.putString("body_id", body_id);
				databundle.putString("body_name", body_name);
				databundle.putString("body_life", body_life);
				databundle.putString("body_armor", body_armor);
				databundle.putString("leg_id", leg_id);
				databundle.putString("leg_name", leg_name);
				databundle.putString("leg_life", leg_life);
				databundle.putString("leg_armor", leg_armor);
				myMessage.setData(databundle);
				// Sends the message to the handler
				handlerItem.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
}
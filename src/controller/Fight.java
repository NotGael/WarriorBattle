package controller;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.warriorbattle.R;

public class Fight extends Activity {
	private int first, enemyId;
	private double lifeTotal, armorTotal, dpsTotal, strengthTotal, criticalTotal;
	private double enemyLifeTotal, enemyArmorTotal, enemyDpsTotal, enemyStrengthTotal, enemyCriticalTotal;
	private double wCritical, eCritical, damage, damageE;
	private String warrior_user, warrior_name, warrior_level, warrior_life, warrior_armor, warrior_dps, warrior_strength, warrior_critical, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg, warrior_gold, warrior_xp;
	private String rightHand_id, rightHand_name, rightHand_type, rightHand_armor, rightHand_dps, rightHand_strength, rightHand_critical;
	private String leftHand_id, leftHand_name, leftHand_type, leftHand_armor, leftHand_dps, leftHand_strength, leftHand_critical;
	private String head_id, head_name, head_life, head_armor;
	private String body_id, body_name, body_life, body_armor;
	private String leg_id, leg_name, leg_life, leg_armor;
	private String provider, result;
	private String item_type;
	private String enemy_id, fightingString;
	private String enemy_user, enemy_name, enemy_level, enemy_life, enemy_armor, enemy_dps, enemy_strength, enemy_critical, enemy_rightHand, enemy_leftHand, enemy_head, enemy_body, enemy_leg, enemy_gold, enemy_xp;
	private String enemyRightHand_id, enemyRightHand_name, enemyRightHand_type, enemyRightHand_armor, enemyRightHand_dps, enemyRightHand_strength, enemyRightHand_critical;
	private String enemyLeftHand_id, enemyLeftHand_name, enemyLeftHand_type, enemyLeftHand_armor, enemyLeftHand_dps, enemyLeftHand_strength, enemyLeftHand_critical;
	private String enemyHead_id, enemyHead_name, enemyHead_life, enemyHead_armor;
	private String enemyBody_id, enemyBody_name, enemyBody_life, enemyBody_armor;
	private String enemyLeg_id, enemyLeg_name, enemyLeg_life, enemyLeg_armor;
	private String victorious_id, victorious_gold, victorious_xp, victorious_level;
	private TextView textFight;
	private Button buttonMenu;
	private static Handler handlerWarriorEnemy, handlerItem, handlerReward;
	
	@SuppressLint("HandlerLeak")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fight);
		
		/* 
		 * GET EXTRA
		 */
		
		// Gets the previously created intent
		Intent warrior = getIntent();		
		// Will return Extra values
		enemy_id = warrior.getStringExtra("enemy_id");
		
		warrior_user = warrior.getStringExtra("warrior_user");
		warrior_name = warrior.getStringExtra("warrior_name");
		warrior_level = warrior.getStringExtra("warrior_level");
		warrior_life = warrior.getStringExtra("warrior_life");
		warrior_armor = warrior.getStringExtra("warrior_armor");
		warrior_dps = warrior.getStringExtra("warrior_dps");
		warrior_strength = warrior.getStringExtra("warrior_strength");
		warrior_critical = warrior.getStringExtra("warrior_critical");
		warrior_rightHand = warrior.getStringExtra("warrior_rightHand");
		warrior_leftHand = warrior.getStringExtra("warrior_leftHand");
		warrior_head = warrior.getStringExtra("warrior_head");
		warrior_body = warrior.getStringExtra("warrior_body");
		warrior_leg = warrior.getStringExtra("warrior_leg");
		warrior_gold = warrior.getStringExtra("warrior_gold");
		warrior_xp = warrior.getStringExtra("warrior_xp");
		rightHand_id = warrior.getStringExtra("rightHand_id");
		rightHand_name = warrior.getStringExtra("rightHand_name");
		rightHand_type = warrior.getStringExtra("rightHand_type");
		rightHand_armor = warrior.getStringExtra("rightHand_armor");
		rightHand_dps = warrior.getStringExtra("rightHand_dps");
		rightHand_strength = warrior.getStringExtra("rightHand_strength");
		rightHand_critical = warrior.getStringExtra("rightHand_critical");
		leftHand_id = warrior.getStringExtra("leftHand_id");
		leftHand_name = warrior.getStringExtra("leftHand_name");
		leftHand_type = warrior.getStringExtra("leftHand_type");
		leftHand_armor = warrior.getStringExtra("leftHand_armor");
		leftHand_dps = warrior.getStringExtra("leftHand_dps");
		leftHand_strength = warrior.getStringExtra("leftHand_strength");
		leftHand_critical = warrior.getStringExtra("leftHand_critical");
		head_id = warrior.getStringExtra("head_id");
		head_name = warrior.getStringExtra("head_name");
		head_life = warrior.getStringExtra("head_life");
		head_armor = warrior.getStringExtra("head_armor");
		body_id = warrior.getStringExtra("body_id");
		body_name = warrior.getStringExtra("body_name");
		body_life = warrior.getStringExtra("body_life");
		body_armor = warrior.getStringExtra("body_armor");
		leg_id = warrior.getStringExtra("leg_id");
		leg_name = warrior.getStringExtra("leg_name");
		leg_life = warrior.getStringExtra("leg_life");
		leg_armor = warrior.getStringExtra("leg_armor");
		
		enemyId = Integer.parseInt(enemy_id); 
		
		/*
		 * TEXTVIEW 
		 */
		
		//TextView textFight
		textFight = (TextView)findViewById(R.id.textFight);
		
		// Button Login
				buttonMenu = (Button)findViewById(R.id.buttonMenu);
				buttonMenu.setOnClickListener(new OnClickListener () {
					@Override
					public void onClick(View v) {
						Intent startMenu = new Intent(Fight.this, Menu.class);
	            		startMenu.putExtra("userId", warrior_user);
						startActivity(startMenu);
					}
				});
		
		/*
		 * GET ALL ENEMY WARRIOR INFORMATION
		 */
		
		new EnemyWarriorInformation().execute(new DatabaseConnection());				
		handlerWarriorEnemy = new Handler() {
			public void handleMessage(Message myMessage) {
				enemy_user = (myMessage.getData().getString("enemy_user"));
				enemy_name = (myMessage.getData().getString("enemy_name"));
				enemy_level = (myMessage.getData().getString("enemy_level"));
				enemy_life = (myMessage.getData().getString("enemy_life"));
				enemy_armor = (myMessage.getData().getString("enemy_armor"));
				enemy_dps = (myMessage.getData().getString("enemy_armor"));
				enemy_strength = (myMessage.getData().getString("enemy_strength"));
				enemy_critical = (myMessage.getData().getString("enemy_critical"));
				enemy_rightHand = (myMessage.getData().getString("enemy_rightHand"));
				enemy_leftHand = (myMessage.getData().getString("enemy_leftHand"));
				enemy_head = (myMessage.getData().getString("enemy_head"));
				enemy_body = (myMessage.getData().getString("enemy_body"));
				enemy_leg = (myMessage.getData().getString("enemy_leg"));
				enemy_gold = (myMessage.getData().getString("enemy_gold"));
				enemy_xp = (myMessage.getData().getString("enemy_xp"));
			}
		};
			
		/*
		 * GET ALL ENEMY ITEM INFORMATION
		 */
		
		new ItemInformation().execute(new DatabaseConnection());		
		handlerItem = new Handler() {
			public void handleMessage(Message myMessage) {
				enemyRightHand_id = (myMessage.getData().getString("enemyRightHand_id"));
				enemyRightHand_name = (myMessage.getData().getString("enemyRightHand_name"));
				enemyRightHand_type = (myMessage.getData().getString("enemyRightHand_type"));
				enemyRightHand_armor = (myMessage.getData().getString("enemyRightHand_armor"));
				enemyRightHand_dps = (myMessage.getData().getString("enemyRightHand_dps"));
				enemyRightHand_strength = (myMessage.getData().getString("enemyRightHand_strength"));
				enemyRightHand_critical = (myMessage.getData().getString("enemyRightHand_critical"));
				enemyLeftHand_id = (myMessage.getData().getString("enemyLeftHand_id"));
				enemyLeftHand_name = (myMessage.getData().getString("enemyLeftHand_name"));
				enemyLeftHand_type = (myMessage.getData().getString("enemyLeftHand_type"));
				enemyLeftHand_armor = (myMessage.getData().getString("enemyLeftHand_armor"));
				enemyLeftHand_dps = (myMessage.getData().getString("leftHand_dps"));
				enemyLeftHand_strength = (myMessage.getData().getString("leftHand_strength"));
				enemyLeftHand_critical = (myMessage.getData().getString("leftHand_critical"));
				enemyHead_id = (myMessage.getData().getString("enemyHead_id"));
				enemyHead_name = (myMessage.getData().getString("enemyHead_name"));
				enemyHead_life = (myMessage.getData().getString("enemyHead_life"));
				enemyHead_armor = (myMessage.getData().getString("enemyHead_armor"));
				enemyBody_id = (myMessage.getData().getString("enemyBody_id"));
				enemyBody_name = (myMessage.getData().getString("enemyBody_name"));
				enemyBody_life = (myMessage.getData().getString("enemyBody_life"));
				enemyBody_armor = (myMessage.getData().getString("enemyBody_life"));
				enemyLeg_id = (myMessage.getData().getString("enemyLeg_id"));
				enemyLeg_name = (myMessage.getData().getString("enemyLeg_id"));
				enemyLeg_life = (myMessage.getData().getString("enemyLeg_life"));
				enemyLeg_armor = (myMessage.getData().getString("enemyLeg_armor"));
			}
		};
		
		enemy_user = "0";
		enemy_name = "SuperTestMan";
		enemy_level = "1";
		enemy_life = "100";
		enemy_armor = "0";
		enemy_dps = "10";
		enemy_strength = "1";
		enemy_critical = "0";
		enemy_rightHand = "1";
		enemy_leftHand = "0";
		enemy_head = "10";
		enemy_body = "0";
		enemy_leg = "0";
		enemy_gold = "50";
		enemy_xp = "10";
		enemyRightHand_id = "1";
		enemyRightHand_name = "Ranger knife";
		enemyRightHand_type = "1";
		enemyRightHand_armor = "0";
		enemyRightHand_dps = "5";
		enemyRightHand_strength = "1";
		enemyRightHand_critical = "2";
		enemyLeftHand_id = "null";
		enemyLeftHand_name = "null";
		enemyLeftHand_type = "null";
		enemyLeftHand_armor = "null";
		enemyLeftHand_dps = "null";
		enemyLeftHand_strength = "null";
		enemyLeftHand_critical = "null";
		enemyHead_id = "10";
		enemyHead_name = "Ranger bandana";
		enemyHead_life = "25";
		enemyHead_armor = "2";
		enemyBody_id = "null";
		enemyBody_name = "null";
		enemyBody_life = "null";
		enemyBody_armor = "null";
		enemyLeg_id = "null";
		enemyLeg_name = "null";
		enemyLeg_life = "null";
		enemyLeg_armor = "null";

		
		//fightingString = "/WARRIOR INFO/" + warrior_user  + "//" + warrior_name  + "//" + warrior_level  + "//" + warrior_life  + "//" + warrior_armor  + "//" + warrior_dps  + "//" + warrior_strength  + "//" + warrior_critical  + "//" + warrior_rightHand  + "//" + warrior_leftHand  + "//" + warrior_head  + "//" + warrior_body  + "//" + warrior_leg  + "//" + warrior_gold  + "//" + warrior_xp  + "/WARRIOR ITEMS/" + rightHand_id  + "//" + rightHand_name  + "//" + rightHand_type  + "//" + rightHand_armor  + "//" + rightHand_dps  + "//" + rightHand_strength  + "//" + rightHand_critical  + "//" + leftHand_id  + "//" + leftHand_name  + "//" + leftHand_type  + "//" + leftHand_armor  + "//" + leftHand_dps  + "//" + leftHand_strength  + "//" + leftHand_critical  + "//" + head_id  + "//" + head_name  + "//" + head_life  + "//" + head_armor  + "//" + body_id  + "//" + body_name  + "//" + body_life  + "//" + body_armor  + "//" + leg_id  + "//" + leg_name  + "//" + leg_life  + "//" + leg_armor  + "/ENEMY INFO/" + enemy_id + "//" + enemy_user  + "//" + enemy_name  + "//" + enemy_level  + "//" + enemy_life  + "//" + enemy_armor  + "//" + enemy_dps  + "//" + enemy_strength  + "//" + enemy_critical  + "//" + enemy_rightHand  + "//" + enemy_leftHand  + "//" + enemy_head  + "//" + enemy_body  + "//" + enemy_leg  + "//" + enemy_gold  + "//" + enemy_xp  + "/ENEMY ITEMS/" + enemyRightHand_id  + "//" + enemyRightHand_name  + "//" + enemyRightHand_type  + "//" + enemyRightHand_armor  + "//" + enemyRightHand_dps  + "//" + enemyRightHand_strength  + "//" + enemyRightHand_critical  + "//" + enemyLeftHand_id  + "//" + enemyLeftHand_name  + "//" + enemyLeftHand_type  + "//" + enemyLeftHand_armor  + "//" + enemyLeftHand_dps  + "//" + enemyLeftHand_strength  + "//" + enemyLeftHand_critical  + "//" + enemyHead_id  + "//" + enemyHead_name  + "//" + enemyHead_life  + "//" + enemyHead_armor  + "//" + enemyBody_id  + "//" + enemyBody_name  + "//" + enemyBody_life  + "//" + enemyBody_armor  + "//" + enemyLeg_id  + "//" + enemyLeg_name  + "//" + enemyLeg_life  + "//" + enemyLeg_armor;
		//fightingString = "/enemy_id/" + enemy_id + " /enemyId/ " + enemyId + " /enemy_user/ " + enemy_user + " /enemy_name/ " + enemy_name;
		
		/* 
		 * CALCUL WARRIOR INFO
		 */
		
		lifeTotal = Integer.parseInt(warrior_life);
		armorTotal = Integer.parseInt(warrior_armor);
		dpsTotal = Integer.parseInt(warrior_dps);
		strengthTotal = Integer.parseInt(warrior_strength);
		criticalTotal = Integer.parseInt(warrior_critical);
		if(!warrior_rightHand.equals("null")) {
			if(!warrior_rightHand.equals("0")) {
				armorTotal = armorTotal + Integer.parseInt(rightHand_armor);
				dpsTotal = dpsTotal + Integer.parseInt(rightHand_dps);
				strengthTotal = strengthTotal + Integer.parseInt(rightHand_strength);
				criticalTotal = criticalTotal + Integer.parseInt(rightHand_critical);
			}
		}
		if(!warrior_leftHand.equals("null")) {
			if(!warrior_leftHand.equals("0")) {
				armorTotal = armorTotal + Integer.parseInt(leftHand_armor);
				dpsTotal = dpsTotal + Integer.parseInt(leftHand_dps);
				strengthTotal = strengthTotal + Integer.parseInt(leftHand_strength);
				criticalTotal = criticalTotal + Integer.parseInt(leftHand_critical);
			}
		}
		if(!warrior_head.equals("null")) {
			if(!warrior_head.equals("0")) {
				lifeTotal = lifeTotal + Integer.parseInt(head_life);
				armorTotal = armorTotal + Integer.parseInt(head_armor);
			}
		}
		if(!warrior_body.equals("null")) {
			if(!warrior_body.equals("0")) {
				lifeTotal = lifeTotal + Integer.parseInt(body_life);
				armorTotal = armorTotal + Integer.parseInt(body_armor);
			}
		}
		if(!warrior_leg.equals("null")) {
			if(!warrior_leg.equals("0")) {
				lifeTotal = lifeTotal + Integer.parseInt(leg_life);
				armorTotal = armorTotal + Integer.parseInt(leg_armor);
			}
		}
		
		/*
		 *  CALCUL ENEMY INFO
		 */
		
		enemyLifeTotal = Integer.parseInt(enemy_life);
		enemyArmorTotal = Integer.parseInt(enemy_armor);
		enemyDpsTotal = Integer.parseInt(enemy_dps);
		enemyStrengthTotal = Integer.parseInt(enemy_strength);
		enemyCriticalTotal = Integer.parseInt(enemy_critical);
		if(!enemy_rightHand.equals("null")) {
			if(!enemy_rightHand.equals("0")) {
				enemyArmorTotal = enemyArmorTotal + Integer.parseInt(enemyRightHand_armor);
				enemyDpsTotal = enemyDpsTotal + Integer.parseInt(enemyRightHand_dps);
				enemyStrengthTotal = enemyStrengthTotal + Integer.parseInt(enemyRightHand_strength);
				enemyCriticalTotal = enemyCriticalTotal + Integer.parseInt(enemyRightHand_critical);
				}
		}
		if(!enemy_leftHand.equals("null")) {
			if(!enemy_leftHand.equals("0")) {
				enemyArmorTotal = enemyArmorTotal + Integer.parseInt(enemyLeftHand_armor);
				enemyDpsTotal = enemyDpsTotal + Integer.parseInt(enemyLeftHand_dps);
				enemyStrengthTotal = enemyStrengthTotal + Integer.parseInt(enemyLeftHand_strength);
				enemyCriticalTotal = enemyCriticalTotal + Integer.parseInt(enemyLeftHand_critical);
			}
		}
		if(!enemy_head.equals("null")) {
			if(!enemy_head.equals("0")) {
				enemyLifeTotal = enemyLifeTotal + Integer.parseInt(enemyHead_life);
				enemyArmorTotal = enemyArmorTotal + Integer.parseInt(enemyHead_armor);
			}
		}
		if(!enemy_body.equals("null")) {
			if(!enemy_body.equals("0")) {
				enemyLifeTotal = enemyLifeTotal + Integer.parseInt(enemyBody_life);
				enemyArmorTotal = enemyArmorTotal + Integer.parseInt(enemyBody_armor);
			}
		}
		if(!enemy_leg.equals("null")) {
			if(!enemy_leg.equals("0")) {
				enemyLifeTotal = enemyLifeTotal + Integer.parseInt(enemyLeg_life);
				enemyArmorTotal = enemyArmorTotal + Integer.parseInt(enemyLeg_armor);
			}
		}
		/*
		enemyLifeTotal = 125;
		enemyArmorTotal = 2;
		enemyDpsTotal = 15;
		enemyStrengthTotal = 2;
		enemyCriticalTotal = 2;
		*/
		/*
		 *  FIGHTING ALGORITHM
		 */
		if (enemyArmorTotal == 0) {
			enemyArmorTotal = 1;
		}
		if (armorTotal == 0) {
			armorTotal = 1;
		}
		
		if (criticalTotal == 0) {
			criticalTotal = 1;
		}
		if (enemyCriticalTotal == 0) {
			enemyCriticalTotal = 1;
		}
		
		wCritical = 0;
		eCritical = 0;
		fightingString = "";
		while(enemyLifeTotal>=0 && lifeTotal>=0) {
			wCritical = wCritical + criticalTotal;
			// The warrior hit the enemy
			if(wCritical >= 100) {
				damage = (dpsTotal + (dpsTotal * (strengthTotal/100)) + (dpsTotal * (criticalTotal/100))) / enemyArmorTotal;
				damage = 10*damage;
				enemyLifeTotal = enemyLifeTotal - damage;
				wCritical = wCritical - 100;
				fightingString = fightingString + warrior_name + ": critical hit " + enemy_name + "\n" + enemy_name + " lose " + damage + " life point and has now " + enemyLifeTotal + " life point.\n";
			}
			else {
				damage = (dpsTotal + (dpsTotal * (strengthTotal/100))) / enemyArmorTotal;
				damage = 10*damage;
				enemyLifeTotal = enemyLifeTotal - damage;
				fightingString = fightingString + warrior_name + ": hit " + enemy_name + "\n" + enemy_name + " lose " + damage + " life point and has now " + enemyLifeTotal + " life point.\n";
			}
			eCritical = eCritical + enemyCriticalTotal;
			if(enemyLifeTotal > 0) {
				// The enemy hit the warrior
				if(eCritical >= 100) {
					damageE = (enemyDpsTotal + (enemyDpsTotal * (enemyStrengthTotal/100)) + (enemyDpsTotal * (enemyCriticalTotal/100))) /  armorTotal;
					damageE = 2*damageE;
					lifeTotal = lifeTotal - damage;
					eCritical = wCritical - 100;
					fightingString = fightingString + enemy_name + ": critical hit " + warrior_name + "\n" + warrior_name + " lose " + damageE + " life point and has now " + lifeTotal + " life point.\n";
				}
				else {
					damageE = (enemyDpsTotal + (enemyDpsTotal * (enemyStrengthTotal/100))) / armorTotal;
					damageE = 2*damageE;
					lifeTotal = lifeTotal - damage;
					fightingString = fightingString + enemy_name + ": hit " + warrior_name + "\n" + warrior_name + " lose " + damageE + " life point and has now " + lifeTotal + " life point.\n";
				}
			}
		}
		if(enemyLifeTotal <= 0) {
			//YOU WIN
			fightingString = fightingString + "VICTORY\n+ 10 XP\n+ 50 Gold\n";
			if (((Integer.parseInt(enemy_xp)) + 10) >= 100) {
				warrior_level = Integer.toString((Integer.parseInt(warrior_level)) + 1);
				warrior_xp = Integer.toString(0);
				warrior_gold = Integer.toString((Integer.parseInt(warrior_gold)) + 50);
				fightingString = fightingString + "LEVEL UP !";
			}
			else {
				warrior_xp = Integer.toString((Integer.parseInt(warrior_xp)) + 10);
				warrior_gold = Integer.toString((Integer.parseInt(warrior_gold)) + 50);
			}
			
			/*
			 * GET REWARD
			 */
			victorious_id = warrior_user;
			victorious_gold = warrior_gold;
			victorious_xp = warrior_xp;
			victorious_level = warrior_level;
		}
		else {
			//YOU LOSE
			fightingString = fightingString + "DEFEAT\n";
			if (((Integer.parseInt(enemy_xp)) + 10) >= 100) {
				enemy_level = Integer.toString((Integer.parseInt(enemy_level)) + 1);
				enemy_xp = Integer.toString(0);
				enemy_gold = Integer.toString((Integer.parseInt(enemy_gold)) + 50);
			}
			else {
				enemy_xp = Integer.toString((Integer.parseInt(enemy_xp)) + 10);
				enemy_gold = Integer.toString((Integer.parseInt(enemy_gold)) + 50);
			}
			/*
			 * GET REWARD
			 */
			victorious_id = enemy_user;
			victorious_gold = enemy_gold;
			victorious_xp = enemy_xp;
			victorious_level = enemy_level;
		}	
		
		/*
		 * GET REWARD
		 */
		
		new Reward().execute(new DatabaseConnection());		
		handlerReward = new Handler() {
			public void handleMessage(Message myMessage) {
					// Nothing
			}
		};
		//fightingString = fightingString + "//" + victorious_id + "//" + victorious_gold + "//" + victorious_xp + "//" + victorious_level;
		textFight.setText(fightingString);
	}

	/*
	 * THREAD WARRIOR INFORMATION
	 */
	
	public class EnemyWarriorInformation extends AsyncTask<DatabaseConnection, Long, JSONArray> {
		@Override
		protected JSONArray doInBackground(DatabaseConnection... params) {
			// It's executed on background thread
			return params[0].EnemyWarriorInformation(enemyId);
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayEnemyWarrior) {
			try {
				JSONObject dataArrayEnemyWarrior = jsonArrayEnemyWarrior.getJSONObject(0);
				enemy_user = dataArrayEnemyWarrior.getString("warrior_user");
				enemy_name = dataArrayEnemyWarrior.getString("warrior_name");
				enemy_level = dataArrayEnemyWarrior.getString("warrior_level");
				enemy_life = dataArrayEnemyWarrior.getString("warrior_life");
				enemy_armor = dataArrayEnemyWarrior.getString("warrior_armor");
				enemy_dps = dataArrayEnemyWarrior.getString("warrior_dps");
				enemy_strength = dataArrayEnemyWarrior.getString("warrior_strength");
				enemy_critical = dataArrayEnemyWarrior.getString("warrior_critical");
				enemy_rightHand = dataArrayEnemyWarrior.getString("warrior_rightHand");
				enemy_leftHand = dataArrayEnemyWarrior.getString("warrior_leftHand");
				enemy_head = dataArrayEnemyWarrior.getString("warrior_head");
				enemy_body = dataArrayEnemyWarrior.getString("warrior_body");
				enemy_leg = dataArrayEnemyWarrior.getString("warrior_leg");
				enemy_gold = dataArrayEnemyWarrior.getString("warrior_gold");
				enemy_xp = dataArrayEnemyWarrior.getString("warrior_xp");
				// Creates a message to send to our UI thread
				Message myMessage = new Message();
				// Creates the data for the message
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle
				databundle.putString("enemy_user", enemy_user);
				databundle.putString("enemy_name",  enemy_name);
				databundle.putString("enemy_level",  enemy_level);
				databundle.putString("enemy_life",  enemy_life);
				databundle.putString("enemy_armor",  enemy_armor);
				databundle.putString("enemy_dps",  enemy_dps);
				databundle.putString("enemy_strength",  enemy_strength);
				databundle.putString("enemy_critical",  enemy_critical);
				databundle.putString("enemy_rightHand",  enemy_rightHand);
				databundle.putString("enemy_leftHand",  enemy_leftHand);
				databundle.putString("enemy_head",  enemy_head);
				databundle.putString("enemy_body",  enemy_body);
				databundle.putString("enemy_leg",  enemy_leg);
				databundle.putString("enemy_gold",  enemy_gold);
				databundle.putString("enemy_xp",  enemy_xp);
				myMessage.setData(databundle);
				// Sends the message to the handler
				handlerWarriorEnemy.sendMessage(myMessage);
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
			return params[0].ItemInformation(enemy_rightHand, enemy_leftHand, enemy_head, enemy_body, enemy_leg);
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayItem) {
			try { 
				for(int i=0; i<jsonArrayItem.length(); i++) {
					JSONObject dataArrayItem = jsonArrayItem.getJSONObject(i);
					item_type = dataArrayItem.getString("item_type");
					if(item_type.equals("1")) {
						if(first == 0) {
							enemyRightHand_id = dataArrayItem.getString("item_id");
							enemyRightHand_name = dataArrayItem.getString("item_name");
							enemyRightHand_type = dataArrayItem.getString("item_type");
							enemyRightHand_armor = dataArrayItem.getString("item_armor");
							enemyRightHand_dps = dataArrayItem.getString("item_dps");
							enemyRightHand_strength = dataArrayItem.getString("item_strength");
							enemyRightHand_critical = dataArrayItem.getString("item_critical");
							first = 1;
						}
						else {
							enemyLeftHand_id = dataArrayItem.getString("item_id");
							enemyLeftHand_name = dataArrayItem.getString("item_name");
							enemyLeftHand_type = dataArrayItem.getString("item_type");
							enemyLeftHand_armor = dataArrayItem.getString("item_armor");
							enemyLeftHand_dps = dataArrayItem.getString("item_dps");
							enemyLeftHand_strength = dataArrayItem.getString("item_strength");
							enemyLeftHand_critical = dataArrayItem.getString("item_critical");
						}
					}
					if(item_type.equals("2")) {
						if(first == 0) {
							enemyRightHand_id = dataArrayItem.getString("item_id");
							enemyRightHand_name = dataArrayItem.getString("item_name");
							enemyRightHand_type = dataArrayItem.getString("item_type");
							enemyRightHand_armor = dataArrayItem.getString("item_armor");
							enemyRightHand_dps = dataArrayItem.getString("item_dps");
							enemyRightHand_strength = dataArrayItem.getString("item_strength");
							enemyRightHand_critical = dataArrayItem.getString("item_critical");
							first = 1;
						}
					}
					if(item_type.equals("3")) {
						enemyHead_id = dataArrayItem.getString("item_id");
						enemyHead_name = dataArrayItem.getString("item_name");
						enemyHead_life = dataArrayItem.getString("item_life");
						enemyHead_armor = dataArrayItem.getString("item_armor");
					}
					if(item_type.equals("4")) {
						enemyBody_id = dataArrayItem.getString("item_id");
						enemyBody_name = dataArrayItem.getString("item_name");
						enemyBody_life = dataArrayItem.getString("item_life");
						enemyBody_armor = dataArrayItem.getString("item_armor");
					}
					if(item_type.equals("5")) {
						enemyLeg_id = dataArrayItem.getString("item_id");
						enemyLeg_name = dataArrayItem.getString("item_name");
						enemyLeg_life = dataArrayItem.getString("item_life");
						enemyLeg_armor = dataArrayItem.getString("item_armor");
					}
				}
				// Creates a message to send to our UI thread
				Message myMessage = new Message();
				// Creates the data for the message
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle
				databundle.putString("enemyRightHand_id", enemyRightHand_id);
				databundle.putString("enemyRightHand_name", enemyRightHand_name);
				databundle.putString("enemyRightHand_type", enemyRightHand_type);
				databundle.putString("enemyRightHand_armor", enemyRightHand_armor);
				databundle.putString("enemyRightHand_dps", enemyRightHand_dps);
				databundle.putString("enemyRightHand_strength", enemyRightHand_strength);
				databundle.putString("enemyRightHand_critical", enemyRightHand_critical);
				databundle.putString("enemyLeftHand_id", enemyLeftHand_id);
				databundle.putString("enemyLeftHand_name", enemyLeftHand_name);
				databundle.putString("enemyLeftHand_type", enemyLeftHand_type);
				databundle.putString("enemyLeftHand_armor", enemyLeftHand_armor);
				databundle.putString("enemyLeftHand_dps", enemyLeftHand_dps);
				databundle.putString("enemyLeftHand_strength", enemyLeftHand_strength);
				databundle.putString("enemyLeftHand_critical", enemyLeftHand_critical);
				databundle.putString("enemyHead_id", enemyHead_id);
				databundle.putString("enemyHead_name", enemyHead_name);
				databundle.putString("enemyHead_life", enemyHead_life);
				databundle.putString("enemyHead_armor", enemyHead_armor);
				databundle.putString("enemyBody_id", enemyBody_id);
				databundle.putString("enemyBody_name", enemyBody_name);
				databundle.putString("enemyBody_life", enemyBody_life);
				databundle.putString("enemyBody_armor", enemyBody_armor);
				databundle.putString("enemyLeg_id", enemyLeg_id);
				databundle.putString("enemyLeg_name", enemyLeg_name);
				databundle.putString("enemyLeg_life", enemyLeg_life);
				databundle.putString("enemyLeg_armor", enemyLeg_armor);
				myMessage.setData(databundle);
				// Sends the message to the handler
				handlerItem.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * THREAD ADD GOLD AND XP
	 */
	
	public class Reward extends AsyncTask<DatabaseConnection, Long, JSONObject> {
		@Override
		protected JSONObject doInBackground(DatabaseConnection... params) {
			// It's executed on background thread.
			return params[0].AddReward(victorious_id, victorious_gold, victorious_xp, victorious_level);
		}
		@Override
		protected void onPostExecute(JSONObject joReward) {
			try {
				result = (joReward.getString("result"));
				
				// Creates a message to send to our UI thread.
				Message myMessage = new Message();
				// Creates the data for the message.
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle.
				databundle.putString("result", result);
				myMessage.setData(databundle);
				// Sends the message to the handler.
				handlerReward.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
}
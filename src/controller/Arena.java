package controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.warriorbattle.R;

public class Arena extends Activity {
	private int lifeTotal, armorTotal, dpsTotal, strengthTotal, criticalTotal;
	private double latitude, longitude;
	private String warrior_user, warrior_name, warrior_level, warrior_life, warrior_armor, warrior_dps, warrior_strength, warrior_critical, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg, warrior_gold, warrior_xp;
	private String possession_item1, possession_item2, possession_item3, possession_item4, possession_item5, possession_item6, possession_item7, possession_item8, possession_item9, possession_item10, possession_item11, possession_item12;
	private String rightHand_id, rightHand_name, rightHand_type, rightHand_armor, rightHand_dps, rightHand_strength, rightHand_critical;
	private String leftHand_id, leftHand_name, leftHand_type, leftHand_armor, leftHand_dps, leftHand_strength, leftHand_critical;
	private String head_id, head_name, head_life, head_armor;
	private String body_id, body_name, body_life, body_armor;
	private String leg_id, leg_name, leg_life, leg_armor;
	private String provider;
	private TextView textLocation;
	private LocationManager locationManager;
	private Location location;
	private ListView GetAllWarriorListView;
	private JSONArray jsonArrayEnemy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.arena);
		// Gets the previously created intent
		Intent warrior = getIntent();		
		// Will return Extra values
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
		possession_item1 = warrior.getStringExtra("possession_item1");
		possession_item2 = warrior.getStringExtra("possession_item2");
		possession_item3 = warrior.getStringExtra("possession_item3");
		possession_item4 = warrior.getStringExtra("possession_item4");
		possession_item5 = warrior.getStringExtra("possession_item5");
		possession_item6 = warrior.getStringExtra("possession_item6");
		possession_item7 = warrior.getStringExtra("possession_item7");
		possession_item8 = warrior.getStringExtra("possession_item8");
		possession_item9 = warrior.getStringExtra("possession_item9");
		possession_item10 = warrior.getStringExtra("possession_item10");
		possession_item11 = warrior.getStringExtra("possession_item11");
		possession_item12 = warrior.getStringExtra("possession_item12");
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
				
		// Calcul Warrior Info
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
		 * TEXTVIEW 
		 */
				
		// TextView textWarrior
		//textLocation = (TextView)findViewById(R.id.textLocation);
				
		/*
		 * GET USER POSITION
		 */
		/*		
		//get location service
		locationManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		*//*
		criteria.setAccuracy(Criteria.ACCURACY_COARSE); // COARSE ??
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setSpeedRequired(false);
		criteria.setCostAllowed(true); // TRUE ?
		String bestProvider = locationManager.getBestProvider(criteria, true);
				
		*//*
		provider = locationManager.getBestProvider(criteria, false);
		//now you have best provider
		//get location
		location =locationManager.getLastKnownLocation(provider);
		if(location != null) {
			//get latitude and longitude of the location
			longitude = location.getLongitude();
			latitude = location.getLatitude();
			//display on text view
			textLocation.setText("Latitude: "+ latitude + "\nlongitude :" + longitude);
		}
		else {
			textLocation.setText("No Provider");
		}
		*/
		// GET ALL THE ENEMI (NAME - LEVEL)
		this.GetAllWarriorListView = (ListView) this.findViewById(R.id.GetAllWarriorListView);
		new GetAllWarriorTask().execute(new DatabaseConnection());
		this.GetAllWarriorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				try {
					// Get the user which was clicked
					JSONObject userClicked = jsonArrayEnemy.getJSONObject(position);
					// Send Customer ID
					// FIGHT INTENT
					Intent warrior = new Intent(Arena.this, Fight.class);
					warrior.putExtra("enemy_id", userClicked.getString("warrior_user"));
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
				catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// GET ENEMI NEAR ME (NAME - LEVEL)
			// TODO

	public void setListAdapter(JSONArray jsonArrayEnemy) {
		this.jsonArrayEnemy = jsonArrayEnemy;
		this.GetAllWarriorListView.setAdapter(new GetAllWarriorListViewAdapter(warrior_user, jsonArrayEnemy, this));
	}
		
	private class GetAllWarriorTask extends AsyncTask<DatabaseConnection, Long, JSONArray> {
		@Override
		protected JSONArray doInBackground(DatabaseConnection... params) {
			// it is executed on Background thread
			return params[0].GetAllWarrior();
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayEnemy) {
			//setTextToTextView(jsonArray);
			setListAdapter(jsonArrayEnemy);
		}
	}
	// GET ENNEMI WARRIOR INFO
	// GET ENNEMI ITEM INFO
	// CALCUL ENNEMI INFO
				
	// FIGHTING ALGORITHME
					
	// IF WIN (XP, GOLD)
		// IF LEVEL UP - XP + 0 AND LEVEL ++
	// IF LOSE (FEW GOLD)
	
	/*
	//If you want location on changing place also than use below method
	//otherwise remove all below methods and don't implement location listener
	public void onLocationChanged(Location arg0) {
		latitude = location.getLatitude();
		longitude = location.getLongitude();
		textLocation.setText("Latitude: "+ latitude + "\nlongitude :" + longitude);
	}
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub
	}
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub
	}
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
	}
*/
}
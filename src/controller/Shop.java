package controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.warriorbattle.R;


public class Shop extends Activity {
	private String warrior_gold;
	private String warrior_user, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg;
	private String rightHand_id, rightHand_name, rightHand_type, rightHand_armor, rightHand_dps, rightHand_strength, rightHand_critical;
	private String leftHand_id, leftHand_name, leftHand_type, leftHand_armor, leftHand_dps, leftHand_strength, leftHand_critical;
	private String head_id, head_name, head_life, head_armor;
	private String body_id, body_name, body_life, body_armor;
	private String leg_id, leg_name, leg_life, leg_armor;
	private String possession_item1, possession_item2, possession_item3, possession_item4, possession_item5, possession_item6, possession_item7, possession_item8, possession_item9, possession_item10, possession_item11, possession_item12;
	private ListView GetAllItemListView;
	private JSONArray jsonArrayItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shop);
		// Gets the previously created intent
		Intent warrior = getIntent();		
		// Will return Extra values
		warrior_user = warrior.getStringExtra("warrior_user");
		warrior_rightHand = warrior.getStringExtra("warrior_rightHand");
		warrior_leftHand = warrior.getStringExtra("warrior_leftHand");
		warrior_head = warrior.getStringExtra("warrior_body");
		warrior_body = warrior.getStringExtra("warrior_body");
		warrior_leg = warrior.getStringExtra("warrior_leg");
		warrior_gold = warrior.getStringExtra("warrior_gold");
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
		
		// GET ALL THE ENEMI (NAME - LEVEL)
		this.GetAllItemListView = (ListView) this.findViewById(R.id.GetAllItemListView);
		new GetAllItemTask().execute(new DatabaseConnection());
		this.GetAllItemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				try {
					// Get the user which was clicked
					JSONObject itemClicked = jsonArrayItem.getJSONObject(position);
					// Send Item ID
					// BUY INTENT
					Intent item = new Intent(Shop.this, Item.class);
					item.putExtra("warrior_user", warrior_user);
					item.putExtra("warrior_rightHand", warrior_rightHand);
					item.putExtra("warrior_leftHand", warrior_leftHand);
					item.putExtra("warrior_head", warrior_head);
					item.putExtra("warrior_body", warrior_body);
					item.putExtra("warrior_leg", warrior_leg);
					item.putExtra("warrior_gold", warrior_gold);
					item.putExtra("possession_item1", possession_item1);
					item.putExtra("possession_item2", possession_item2);
					item.putExtra("possession_item3", possession_item3);
					item.putExtra("possession_item4", possession_item4);
					item.putExtra("possession_item5", possession_item5);
					item.putExtra("possession_item6", possession_item6);
					item.putExtra("possession_item7", possession_item7);
					item.putExtra("possession_item8", possession_item8);
					item.putExtra("possession_item9", possession_item9);
					item.putExtra("possession_item10", possession_item10);
					item.putExtra("possession_item11", possession_item11);
					item.putExtra("possession_item12", possession_item12);
					item.putExtra("item_id", itemClicked.getString("item_id"));
					item.putExtra("item_type", itemClicked.getString("item_type"));
					item.putExtra("item_price", itemClicked.getString("item_price"));
					item.putExtra("rightHand_id", rightHand_id);
					item.putExtra("rightHand_name", rightHand_name);
					item.putExtra("rightHand_type", rightHand_type);
					item.putExtra("rightHand_armor", rightHand_armor);
					item.putExtra("rightHand_dps", rightHand_dps);
					item.putExtra("rightHand_strength", rightHand_strength);
					item.putExtra("rightHand_critical", rightHand_critical);
					item.putExtra("leftHand_id", leftHand_id);
					item.putExtra("leftHand_name", leftHand_name);
					item.putExtra("leftHand_type", leftHand_type);
					item.putExtra("leftHand_armor", leftHand_armor);
					item.putExtra("leftHand_dps", leftHand_dps);
					item.putExtra("leftHand_strength", leftHand_strength);
					item.putExtra("leftHand_critical", leftHand_critical);
					item.putExtra("head_id", head_id);
					item.putExtra("head_name", head_name);
					item.putExtra("head_life", head_life);
					item.putExtra("head_armor", head_armor);
					item.putExtra("body_id", body_id);
					item.putExtra("body_name", body_name);
					item.putExtra("body_life", body_life);
					item.putExtra("body_armor", body_armor);
					item.putExtra("leg_id", leg_id);
					item.putExtra("leg_name", leg_name);
					item.putExtra("leg_life", leg_life);
					item.putExtra("leg_armor", leg_armor);
					startActivity(item);
				}	
				catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setListAdapter(JSONArray jsonArrayItem) {
		this.jsonArrayItem = jsonArrayItem;
		this.GetAllItemListView.setAdapter(new GetAllItemListViewAdapter(jsonArrayItem, this));
	}
		
	private class GetAllItemTask extends AsyncTask<DatabaseConnection, Long, JSONArray> {
		@Override
		protected JSONArray doInBackground(DatabaseConnection... params) {
			// it is executed on Background thread
			return params[0].GetAllItem();
		}
		@Override
		protected void onPostExecute(JSONArray jsonArrayItem) {
			//setTextToTextView(jsonArray);
			setListAdapter(jsonArrayItem);
		}
	}
}
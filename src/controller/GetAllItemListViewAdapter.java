package controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.warriorbattle.R;

public class GetAllItemListViewAdapter extends BaseAdapter {
	private JSONArray dataArray;
	private Activity activity;
	private static LayoutInflater inflater = null;
	public GetAllItemListViewAdapter(JSONArray jsonArray, Activity a) {
		this.dataArray = jsonArray;
		this.activity = a;
		inflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return this.dataArray.length();
	} 
	
	@Override
	public Object getItem(int position) {
		return position;
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Set up convert view if it is null
		ListCell cell;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.get_all_item_list_view_cell, null);
			cell = new ListCell();
			cell.item_name = (TextView) convertView.findViewById(R.id.item_name);
			cell.item_type = (TextView) convertView.findViewById(R.id.item_type);
			cell.item_life = (TextView) convertView.findViewById(R.id.item_life);
			cell.item_armor = (TextView) convertView.findViewById(R.id.item_armor);
			cell.item_dps = (TextView) convertView.findViewById(R.id.item_dps);
			cell.item_strength = (TextView) convertView.findViewById(R.id.item_strength);
			cell.item_critical = (TextView) convertView.findViewById(R.id.item_critical);
			cell.item_price = (TextView) convertView.findViewById(R.id.item_price);
			convertView.setTag(cell);
		}
		else {
			cell = (ListCell) convertView.getTag();
		}
		// change the data of cell
		try {
			JSONObject jsonObject = this.dataArray.getJSONObject(position);
			cell.item_name.setText("Name: " + jsonObject.getString("item_name"));
			cell.item_type.setText("Type: " + jsonObject.getString("item_type"));
			cell.item_life.setText("Life: " + jsonObject.getString("item_life"));
			cell.item_armor.setText("Armor: " + jsonObject.getString("item_armor"));
			cell.item_dps.setText("DPS: " + jsonObject.getString("item_dps"));
			cell.item_strength.setText("Strength: " + jsonObject.getString("item_strength"));
			cell.item_critical.setText("Critical: " + jsonObject.getString("item_critical"));
			cell.item_price.setText("Price: " + jsonObject.getString("item_price"));
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return convertView;
	}
	
	private class ListCell {
		private TextView item_name;
		private TextView item_type;
		private TextView item_life;
		private TextView item_armor;
		private TextView item_dps;
		private TextView item_strength;
		private TextView item_critical;
		private TextView item_price;
	}
}

package controller;

import com.example.warriorbattle.R;

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

public class GetAllWarriorListViewAdapter extends BaseAdapter {
	private JSONArray dataArray;
	private Activity activity;
	private String id_user;
	private static LayoutInflater inflater = null;
	public GetAllWarriorListViewAdapter(String warrior_user, JSONArray jsonArray, Activity a) {
		this.id_user = warrior_user;
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
			convertView = inflater.inflate(R.layout.get_all_warrior_list_view_cell, null);
			cell = new ListCell();
			cell.enemy_name = (TextView) convertView.findViewById(R.id.enemy_name);
			cell.enemy_level = (TextView) convertView.findViewById(R.id.enemy_level);
			convertView.setTag(cell);
		}
		else {
			cell = (ListCell) convertView.getTag();
		}
		// change the data of cell
		try {
			JSONObject jsonObject = this.dataArray.getJSONObject(position);
			if((jsonObject.getString("warrior_user")).equals(id_user)) {
				// It's ME
				//position ++;
			}
			cell.enemy_name.setText("Name: " + jsonObject.getString("warrior_name"));
			cell.enemy_level.setText("Level: " + jsonObject.getString("warrior_level"));
		}
		catch(JSONException e) {
			e.printStackTrace();
		}
		return convertView;
	}
	
	private class ListCell {
		private TextView enemy_name;
		private TextView enemy_level;
	}
}
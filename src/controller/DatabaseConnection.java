package controller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class DatabaseConnection {

	/*
	 * LOGIN
	 */

	public JSONObject Login(String login, String password) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/login.php?login=" + login + "&password=" + password;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Object
		JSONObject jo = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jo = new JSONObject(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jo;
	}

	/*
	 * WARRIOR INFORMATION
	 */

	public JSONArray WarriorInformation(int userId) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/getWarriorData.php?userId=" + userId;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here.
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Array.
		JSONArray jsonArrayWarrior = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jsonArrayWarrior = new JSONArray(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jsonArrayWarrior;
	}

	/*
	 * POSSESSION INFORMATION
	 */

	public JSONArray PossessionInformation(int userId) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/getPossessionData.php?userId=" + userId;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here.
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Array.
		JSONArray jsonArrayPossession = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jsonArrayPossession = new JSONArray(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jsonArrayPossession;
	}

	/*
	 * ITEM INFORMATION
	 */

	public JSONArray ItemInformation(String rightHand, String leftHand, String head, String body, String leg) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/getItemData.php?rightHand=" + rightHand + "&leftHand=" + leftHand + "&head=" + head + "&body=" + body + "&leg=" + leg;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here.
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Array.
		JSONArray jsonArrayItem = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jsonArrayItem = new JSONArray(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jsonArrayItem;
	}

	/*
	 * GET ALL WARRIOR - ENEMY LIST
	 */

	public JSONArray GetAllWarrior() {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/getAllWarrior.php";
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			DefaultHttpClient httpClient = new DefaultHttpClient(); // Default HttpClient.
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Array
		JSONArray jsonArrayEnemy = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jsonArrayEnemy = new JSONArray(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jsonArrayEnemy;
	}

	/*
	 * ENEMY WARRIOR INFORMATION
	 */

	public JSONArray EnemyWarriorInformation(int enemyId) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/getWarriorData.php?userId=" + enemyId;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here.
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Array.
		JSONArray jsonArrayEnemyWarrior = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jsonArrayEnemyWarrior = new JSONArray(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jsonArrayEnemyWarrior;
	}

	/*
	 * GET ALL ITEM - ITEM LIST
	 */

	public JSONArray GetAllItem() {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/getAllItem.php";
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			DefaultHttpClient httpClient = new DefaultHttpClient(); // Default HttpClient.
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Array
		JSONArray jsonArrayItem = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				jsonArrayItem = new JSONArray(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return jsonArrayItem;
	}

	/*
	 * BUY ITEM
	 */

	public JSONObject BuyItem(String warrior_user, String item_id, String warrior_gold) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/buyItem?user_id=" + warrior_user + "&item_id=" + item_id + "&warrior_gold=" + warrior_gold;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Object
		JSONObject joBuyItem = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				joBuyItem = new JSONObject(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return joBuyItem;
	}

	/*
	 * EQUIP ITEM
	 */

	public JSONObject EquipItem(String warrior_user, String warrior_rightHand, String warrior_leftHand, String warrior_head, String warrior_body, String warrior_leg) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/equipItem?warrior_user=" + warrior_user + "&warrior_rightHand=" + warrior_rightHand + "&warrior_leftHand=" + warrior_leftHand + "&warrior_head=" + warrior_head + "&warrior_body=" + warrior_body + "&warrior_leg=" + warrior_leg;

		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Object
		JSONObject joEquipItem = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				joEquipItem = new JSONObject(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return joEquipItem;
	}

	/*
	 * SIGN UP
	 */

	public JSONObject SignUp(String user_login, String user_password, String user_password2, String user_mail) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/register.php?login=" + user_login + "&password=" + user_password + "&password2=" + user_password2 + "&mail=" + user_mail;

		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Object
		JSONObject joSignUp = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				joSignUp = new JSONObject(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return joSignUp;
	}

	/*
	 * CREATE WARRIOR
	 */

	public JSONObject CreateWarrior(String user_login, String warrior_name) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/addWarrior.php?login=" + user_login + "&name=" + warrior_name;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Object
		JSONObject joCreateWarrior = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				joCreateWarrior = new JSONObject(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return joCreateWarrior;
	}

	/*
	 * ADD REWARD
	 */

	public JSONObject AddReward(String warrior_user, String warrior_gold, String warrior_xp, String warrior_level) {
		// URL for getting all customers.
		String url = "http://********/WarriorBattle/addReward.php?warrior_user=" + warrior_user + "&warrior_gold=" + warrior_gold + "&warrior_xp=" + warrior_xp + "&warrior_level=" + warrior_level;
		// Get HttpResponce Object from url.
		// Get HttpEntity from Http Response Object.
		HttpEntity httpEntity = null;

		try {
			// Default HttpClient.
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httResponse = httpClient.execute(httpGet);
			httpEntity = httResponse.getEntity();
		}
		catch(ClientProtocolException e) {
			// Signals error in http protocol.
			e.printStackTrace();
			// Log errors here
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		// Convert HttpEntity into JSON Object
		JSONObject joReward = null;
		if(httpEntity != null) {
			try {
				String entityResponse = EntityUtils.toString(httpEntity);
				Log.e("Entity Response :", entityResponse);
				joReward = new JSONObject(entityResponse);
			}
			catch(JSONException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		return joReward;
	}
}

package controller;

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
import android.widget.EditText;
import android.widget.TextView;

import com.example.warriorbattle.R;

public class MainActivity extends Activity {
	private Button buttonLogin, buttonSignUp;
	private EditText textLogin, textPassword;
	private String result = "NULL", login, password;
	private TextView textError;
	private static Handler handler;
	private boolean valid;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Link to layout activity_main.xml
		setContentView(R.layout.activity_main);
		
		/*
		 * EDITTEXT 
		 */
		
		// EditText textLogin
		textLogin=(EditText)findViewById(R.id.textLogin);
		// EditText textPassword
		textPassword=(EditText)findViewById(R.id.textPassword);
		
		/*
		 * TEXTVIEW 
		 */
		
		// TextView textError
		textError=(TextView)findViewById(R.id.textError);
		
		/*
		 * BUTTON 
		 */
		
		// Button Login
		buttonLogin=(Button)findViewById(R.id.buttonLogin);
		buttonLogin.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				login = textLogin.getText().toString();
				password = textPassword.getText().toString();
				new Login().execute(new DatabaseConnection());				
					handler = new Handler() {
						public void handleMessage(Message myMessage) {
							textError.setText(myMessage.getData().getString("result"));
							result = textError.getText().toString();
							if (result.equals("false")) {
								valid = false;
							}
							else {
								valid = true;
			            	}
			            	if (valid == true) {
			            		Intent startMenu = new Intent(MainActivity.this, Menu.class);
			            		startMenu.putExtra("userId", result);
								startActivity(startMenu);
							}
						}
					};		
			}
		});
		
		// Button Sign Up
		buttonSignUp=(Button)findViewById(R.id.buttonSignUp);
		buttonSignUp.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				Intent sign = new Intent(MainActivity.this, SignUp.class);
				startActivity(sign);
			}
		});
	}
	
	/*
	 * THREAD LOGIN 
	 */
	
	public class Login extends AsyncTask<DatabaseConnection, Long, JSONObject> {
		@Override
		protected JSONObject doInBackground(DatabaseConnection... params) {
			// It's executed on background thread.
			return params[0].Login(login, password);
		}
		@Override
		protected void onPostExecute(JSONObject jo) {
			try {
				result = (jo.getString("result"));
				
				// Creates a message to send to our UI thread.
				Message myMessage = new Message();
				// Creates the data for the message.
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle.
				databundle.putString("result", result);
				myMessage.setData(databundle);
				// Sends the message to the handler.
				handler.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
}
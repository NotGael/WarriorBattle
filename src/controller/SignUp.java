package controller;

import org.json.JSONObject;

import com.example.warriorbattle.R;

import controller.MainActivity.Login;

import android.annotation.SuppressLint;
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
import android.widget.EditText;

public class SignUp extends Activity {
	private String user_login, user_password, user_password2, user_mail, warrior_name, result;
	private Handler handlerSignUp, handlerCreateWarrior;
	private EditText textLogin, textPassword, textPassword2, textMail, textName;
	private Button buttonRegister;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.signup);
		
		/*
		 * EDITTEXT 
		 */
		
		// EditText textLogin
		textLogin=(EditText)findViewById(R.id.textLogin);
		// EditText textPassword
		textPassword=(EditText)findViewById(R.id.textPassword);
		// EditText textPassword2
		textPassword2=(EditText)findViewById(R.id.textPassword2);
		// EditText textPassword
		textMail=(EditText)findViewById(R.id.textMail);
		// EditText textPassword
		textName=(EditText)findViewById(R.id.textName);
		
		/*
		 * BUTTON
		 */
		
		// Button Register
		buttonRegister=(Button)findViewById(R.id.buttonRegister);
		buttonRegister.setOnClickListener(new OnClickListener () {
			@Override
			public void onClick(View v) {
				user_login = textLogin.getText().toString();
				user_password = textPassword.getText().toString();
				user_password2 = textPassword2.getText().toString();
				user_mail = textMail.getText().toString();
				warrior_name = textName.getText().toString();
				new SignUpThread().execute(new DatabaseConnection());				
				handlerSignUp = new Handler() {
					public void handleMessage(Message myMessage) {
						// NOTHING
					}
				};
				new CreateWarriorThread().execute(new DatabaseConnection());				
				handlerCreateWarrior = new Handler() {
					public void handleMessage(Message myMessage) {
						// NOTHING
					}
				};
				Intent main = new Intent(SignUp.this, MainActivity.class);
				startActivity(main);
			}
		});
	}
	
	/*
	 * THREAD SIGN UP 
	 */
	
	public class SignUpThread extends AsyncTask<DatabaseConnection, Long, JSONObject> {
		@Override
		protected JSONObject doInBackground(DatabaseConnection... params) {
			// It's executed on background thread.
			return params[0].SignUp(user_login, user_password, user_password2, user_mail);
		}
		@Override
		protected void onPostExecute(JSONObject joSignUp) {
			try {
				result = (joSignUp.getString("result"));
				
				// Creates a message to send to our UI thread.
				Message myMessage = new Message();
				// Creates the data for the message.
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle.
				databundle.putString("result", result);
				myMessage.setData(databundle);
				// Sends the message to the handler.
				handlerSignUp.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
	
	/*
	 * THREAD CREATE WARRIOR 
	 */
	
	public class CreateWarriorThread extends AsyncTask<DatabaseConnection, Long, JSONObject> {
		@Override
		protected JSONObject doInBackground(DatabaseConnection... params) {
			// It's executed on background thread.
			return params[0].CreateWarrior(user_login, warrior_name);
		}
		@Override
		protected void onPostExecute(JSONObject joCreateWarrior) {
			try {
				result = (joCreateWarrior.getString("result"));
				
				// Creates a message to send to our UI thread.
				Message myMessage = new Message();
				// Creates the data for the message.
				Bundle databundle = new Bundle();
				// Adds a string to the data bundle.
				databundle.putString("result", result);
				myMessage.setData(databundle);
				// Sends the message to the handler.
				handlerCreateWarrior.sendMessage(myMessage);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}	
	}
}

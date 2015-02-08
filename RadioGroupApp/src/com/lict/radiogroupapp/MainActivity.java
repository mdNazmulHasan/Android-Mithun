package com.lict.radiogroupapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	RadioGroup rgRadioGroup;
	RadioButton rdSound;
	RadioButton rdVibrate;
	RadioButton rdSilent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeAll();
		rgRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int id) {
				switch (id) {
					case R.id.soundRadioButton:
						Toast.makeText(getApplicationContext(), "Sound", Toast.LENGTH_SHORT).show();
						break;
					case R.id.vibrateRadioButton:
						Toast.makeText(getApplicationContext(), "Vibrate", Toast.LENGTH_SHORT).show();
						break;
					case R.id.silentRadioButton:
						Toast.makeText(getApplicationContext(), "Silent", Toast.LENGTH_SHORT).show();
						break;
					default:
						Toast.makeText(getApplicationContext(), "Default", Toast.LENGTH_SHORT).show();
						break;
				}
			}
		});
	}

	private void initializeAll() {
		rgRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		rdSound = (RadioButton) findViewById(R.id.soundRadioButton);
		rdVibrate = (RadioButton) findViewById(R.id.vibrateRadioButton);
		rdSilent = (RadioButton) findViewById(R.id.silentRadioButton);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
package com.lict.cameraimagewallpaper;



import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnSetWallpaper;
	ImageView ivCaptureImage;
	Bitmap imageBitmap;
	WallpaperManager wallpaperManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeAllViewComponents();
		ivCaptureImage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				openCameraToGetImage();
			}
		});
		btnSetWallpaper.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(imageBitmap != null){
					try{
						wallpaperManager.setBitmap(imageBitmap);
						Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
					}catch(Exception e){
						Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
					}
				}
			}
		});
	}

	protected void openCameraToGetImage() {
		Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, 0);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		super.onActivityResult(requestCode, resultCode, data);
		imageBitmap = (Bitmap) data.getExtras().get("data");
		ivCaptureImage.setImageBitmap(imageBitmap);
		btnSetWallpaper.setEnabled(true);
	}

	private void initializeAllViewComponents() {
		btnSetWallpaper = (Button) findViewById(R.id.setWallpaperButton);
		ivCaptureImage = (ImageView) findViewById(R.id.captureImageView1);
		btnSetWallpaper.setEnabled(false);
		wallpaperManager = WallpaperManager.getInstance(this);
		imageBitmap = null;
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

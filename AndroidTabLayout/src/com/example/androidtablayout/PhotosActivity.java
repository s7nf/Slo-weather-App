package com.example.androidtablayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.example.androidtablayout.LoaderImageView;

public class PhotosActivity extends Activity {
	
	private ImageButton kraji, smucisca, vode, slike;
	
	public void onCreate(Bundle savedInstanceState) 
	 {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.photos_layout);
		 
		 kraji = (ImageButton) findViewById(R.id.ImageButton1);
		 vode = (ImageButton) findViewById(R.id.ImageButton2);
		 smucisca = (ImageButton) findViewById(R.id.ImageButton3);
		 slike = (ImageButton) findViewById(R.id.ImageButton4);
		 
		 kraji.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(PhotosActivity.this, VremenskaNapovedActivity.class);
		        
		        startActivity(intent);
		      }
		    });
		 
		 vode.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(PhotosActivity.this, VodeActivity.class);
		        startActivity(intent);
		      }
		    });
		 
		 smucisca.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(PhotosActivity.this, SmuciscaActivity.class);
		        startActivity(intent);
		      }
		    });
		 
		 slike.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(PhotosActivity.this, RadarskeSlikeActivity.class);
		        startActivity(intent);
		      }
		    });
	 }
}

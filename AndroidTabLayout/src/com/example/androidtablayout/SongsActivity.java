package com.example.androidtablayout;

import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SongsActivity extends Activity {
	private ImageButton cro,tujina;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tujina);
        
        cro = (ImageButton) findViewById(R.id.ImageButtonCro);
        tujina = (ImageButton) findViewById(R.id.ImageButtonEu);
        
        cro.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(SongsActivity.this, CroActivity.class);
		        
		        startActivity(intent);
		      }
		    });
        
        tujina.setOnClickListener(new View.OnClickListener() {
		      @Override
		      public void onClick(View view) {
		        Intent intent = new Intent(SongsActivity.this, TujinaActivity.class);
		        
		        startActivity(intent);
		      }
		    });
    }
}
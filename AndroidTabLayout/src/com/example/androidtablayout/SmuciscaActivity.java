package com.example.androidtablayout;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SmuciscaActivity extends ListActivity
{
	String[] kraji ={
			"ČRNA NA KOROŠKEM",
			"ŠC RUDNO V SELŠKI D.",
			"ŽIČNICE VOGEL",
			"GTC KOPE",
			"JAVORNIK",
			"MARIBORSKO POHORJE",
			"RIBNIŠKO POHORJE",
			"ROGLA",
			"RTC GOLTE",
			"RTC KRANJSKA G.",
			"RTC KRVAVEC",
			"SC CERKNO",
			"SORIŠKA PLANINA",
			"STC STARI VRH",
			"SVIŠČAKI",
			"TRIJE KRALJI"
	    };
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.vremenskanapoved);
	    setListAdapter(new ArrayAdapter<String>(this,
	            android.R.layout.simple_list_item_1, kraji));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		 Intent intent = new Intent(SmuciscaActivity.this, SmuciscaPodrobnoActivity.class);
		 Bundle bundle = new Bundle();
		 bundle.putString("kraj", kraji[position]);
		 intent.putExtras(bundle);
		 SmuciscaActivity.this.startActivity(intent);
	 }
}

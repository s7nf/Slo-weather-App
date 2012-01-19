package com.example.androidtablayout;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TujinaActivity extends ListActivity
{
	private String[] kraji= {
			"Alžir", 
			"Amsterdam",
			"Ankara",   
			"Atene",    
			"Barcelona",
			"Bejrut",   
			"Benetke",  
			"Beograd",  
			"Berlin",   
			"Bratislava",
			"Bruselj",   
			"Budimpešta",   
			"Bukarešta",    
			"Casablanca",   
			"Celovec",      
			"Dublin",       
			"Dubrovnik",    
			"Dunaj",
			"Edinburgh",
			"Frankfurt",
			"Genova",
			"Gibraltar",
			"Gradec",
			"Helsinki",
			"Hvar",
			"Istanbul",
			"Kairo",
			"Kijev",
			"Koebenhavn",
			"Larnaka",
			"Las Palmas",
			"Lizbona",
			"Ljubljana",
			"London",
			"Luksemburg",
			"Madrid",
			"Malorca",
			"Malta",
			"Milano",
			"Minsk",
			"Monošter",
			"Moskva",
			"Muenchen",
			"Oslo",
			"Palermo",
			"Pariz",
			"Podgorica",
			"Praga",
			"Pulj",
			"Reka",
			"Reykjavik",
			"Rim",
			"Sarajevo",
			"Skopje",
			"Sofija",
			"Split",
			"Stockholm",
			"Tel Aviv",
			"Toulouse",
			"Tripolis",
			"Trst",
			"Tunis",
			"Varšava",
			"Zadar Puntamika",
			"Zagreb",
			"Ženeva",
			"Zuerich"	
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
		 Intent intent = new Intent(TujinaActivity.this, TujinaPodrobnoActivity.class);
		 Bundle bundle = new Bundle();
		 bundle.putString("kraj", kraji[position]);
		 intent.putExtras(bundle);
		 TujinaActivity.this.startActivity(intent);
	 }
}

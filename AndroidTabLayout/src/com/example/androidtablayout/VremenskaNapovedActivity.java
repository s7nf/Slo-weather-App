package com.example.androidtablayout;

import java.util.Arrays;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VremenskaNapovedActivity extends ListActivity
{

	String[] kraji = {

"Babno Polje (756 m)",
"Bilje Nova Gorica",
"Bohinjska Češnjica",
"Boršt Gorenja vas",
"Bovec",
"Celje",
"Dobliče Črnomelj",
"Dolenje Ajdovščina",
"Hrastnik",
"Idrija",
"Ilirska Bistrica",
"Koper Kapitanija",
"Krško",
"Kraj. park Goričko",
"Kredarica (2515 m)",
"Krvavec (1740 m)",
"Lendava",
"Let. E. Rusjana Maribor",
"Let. J. Pučnika Lj.",
"Letališče Cerklje ob Krki",
"Letališče Lesce",
"Letališče Portorož",
"Lisca (943 m)",
"Litija",
"Ljubljana",
"Luka Koper",
"Malkovec",
"Maribor",
"Murska Sobota",
"Nova Gorica",
"Novo mesto",
"Otlica (965 m)",
"Park Škocj. jame",
"Piran-ocean. boja",
"Podčetrtek",
"Postojna",
"Ptuj",
"Radenci",
"Rateče (864 m)",
"Ravne na Koroškem",
"Rogla (1492 m)",
"Rudno polje (1347 m)",
"Slovenj Gradec",
"Velenje"

	};
	
	
	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.vremenskanapoved);
	    Arrays.sort(kraji);
	    setListAdapter(new ArrayAdapter<String>(this,
	            android.R.layout.simple_list_item_1, kraji));
	}

	 public void onListItemClick(ListView parent, View v, int position, long id) {
		 Intent intent = new Intent(VremenskaNapovedActivity.this, VremePodrobnoActivity.class);
		 Bundle bundle = new Bundle();
		 bundle.putString("kraj", kraji[position]);
		 intent.putExtras(bundle);
		 VremenskaNapovedActivity.this.startActivity(intent);
	 }
}

package com.example.androidtablayout;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VodeActivity extends ListActivity
{
	String[] kraji = {
			"Bistrica - Muta",
			"Reka - Škocjan",
			"Cerknica - Cerkno",
			"Rogatnica - Podlehnik",
			"Drava - Borl",
			"Roja - Log pod Mangartom",
			"Drava - Črneče",
			"Sava Bohinjka - Bodešče",
			"Drava - Ptuj",
			"Sava Bohinjka - Sv.Janez",
			"Dravinja - Loče",
			"Sava Dolinka - Blejski most",
			"Gradaščica - Dvor",
			"Sava - Hrastnik",
			"Idrijca - Podroteja",
			"Sava - Jesenice na Dolenjskem",
			"Iška - Iška vas",
			"Sava - Medno",
			"Jadransko morje - boja Piran (NIB)",
			"Sava - Radovljica",
			"Jadransko morje - Koper",
			"Sava - Šentjakob",
			"Kamniška B.-Kamnik",
			"Savinja - Laško",
			"Koritnica - Kal-Koritnica",
			"Savinja - Letuš",
			"Krka - Podbočje",
			"Savinja - Medlog",
			"Ledava - Čentiba",
			"Savinja - Nazarje",
			"Lijak - Volčja Draga",
			"Savinja - Veliko Širje",
			"Lipnica - Ovsiše",
			"Ščavnica - Pristava",
			"Ljubija - Verd",
			"Selška Sora - Železniki",
			"Ljubljanica - Moste",
			"Soča - Log Čezsoški",
			"Medija - Zagorje",
			"Soča - Solkan",
			"Mestinjščica - Sodna vas",
			"Sora - Suha",
			"Mura - Gornja Radgona",
			"Tržiška Bistrica - Preska",
			"Mura - Petanjci",
			"Učja - Žaga",
			"Nadiža - Potoki",
			"Velika Krka - Hodoš",
			"Paka - Šoštanj",
			"Vipava - Dolenje",
			"Pesnica - Ranca",
			"Vipava Dornberk",
			"Pšata - Topole",
			"Vipava - Miren",
			"Radoljna - Ruta",
			"Voglajna - Črnolica"
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
		 Intent intent = new Intent(VodeActivity.this, VodePodrobnoActivity.class);
		 Bundle bundle = new Bundle();
		 bundle.putString("kraj", kraji[position]);
		 intent.putExtras(bundle);
		 VodeActivity.this.startActivity(intent);
	 }
}

package com.example.androidtablayout;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AndroidTabLayoutActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TabHost tabHost = getTabHost();
        
        // Tab for splosna napoved
        TabSpec photospec = tabHost.newTabSpec("Slovenija");
        photospec.setIndicator("Slovenija");
        Intent photosIntent = new Intent(this, PhotosActivity.class);
        photospec.setContent(photosIntent);
        
        // Tab for regionalni podatki
        TabSpec songspec = tabHost.newTabSpec("Tujina");
        // setting Title and Icon for the Tab
        songspec.setIndicator("Tujina");
        Intent songsIntent = new Intent(this, SongsActivity.class);
        songspec.setContent(songsIntent);
        
       
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); // Adding photos tab
        tabHost.addTab(songspec); // Adding songs tab
    }
}
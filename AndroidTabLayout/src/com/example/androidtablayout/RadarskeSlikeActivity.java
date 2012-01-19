package com.example.androidtablayout;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;


public class RadarskeSlikeActivity extends Activity
{
    boolean radar;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        InputStream source = retrieveStream("http://repinc.eu:8082/blaz/radSat.json");
	    Gson gson = new Gson();
	    Reader reader = new InputStreamReader(source);
	    final Radar response = gson.fromJson(reader, Radar.class);
        final ImageView iv = (ImageView) findViewById(R.id.ImageViewRadarSlike);        
        iv.setImageDrawable(LoadImageFromWebOperations(response.radar));
        radar = true;
        Button b = (Button) findViewById(R.id.buttonZamenjajSliko);
        b.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				if(radar){
					iv.setImageDrawable(LoadImageFromWebOperations(response.satelit));
					radar = false;
				} else {
					iv.setImageDrawable(LoadImageFromWebOperations(response.radar));
					radar = true;
				}
			}
		});
        
    }
    private InputStream retrieveStream(String url) {
        
        DefaultHttpClient client = new DefaultHttpClient(); 
        
        HttpGet getRequest = new HttpGet(url);
          
        try {
           
           HttpResponse getResponse = client.execute(getRequest);
           final int statusCode = getResponse.getStatusLine().getStatusCode();
           
           if (statusCode != HttpStatus.SC_OK) { 
              Log.w(getClass().getSimpleName(), 
                  "Error " + statusCode + " for URL " + url); 
              return null;
           }

           HttpEntity getResponseEntity = getResponse.getEntity();
           return getResponseEntity.getContent();
           
        } 
        catch (IOException e) {
           getRequest.abort();
           Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        
        return null;
        
     }
    
    private Drawable LoadImageFromWebOperations(String url) {

	      try {
	          InputStream is = (InputStream) new URL(url).getContent();
	          Drawable d = Drawable.createFromStream(is, "src name");
	          return d;
	      } catch (Exception e) {
	    	  Toast.makeText(this, e.toString(), Toast.LENGTH_LONG);
	          //System.out.println("Exc=" + e);
	          return null;
	      }

	  }
    
}
	

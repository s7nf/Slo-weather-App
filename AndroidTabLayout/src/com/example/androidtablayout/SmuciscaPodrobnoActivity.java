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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SmuciscaPodrobnoActivity extends Activity
{
	
	private String mesto;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    
	    
	    setContentView(R.layout.smuciscapodrobno);
	    mesto = getIntent().getExtras().getString("kraj");
	    InputStream source = retrieveStream("http://repinc.eu:8082/blaz/ski/"+mesto.toUpperCase().replaceAll(" ", "%20")+".json");
	    Gson gson = new Gson();
	    Reader reader = new InputStreamReader(source);
	    SkiSlope response = gson.fromJson(reader, SkiSlope.class);
	    TextView tv = (TextView) findViewById(R.id.imesmucisca);
	    tv.setText(response.name);
	    
	    tv = (TextView) findViewById(R.id.smuciscestanje);
	    tv.setText(response.vreme);
	    
	    tv = (TextView) findViewById(R.id.smuciscetemperatura);
	    tv.setText(response.temp);
	    
	    tv = (TextView) findViewById(R.id.smuciscatelefon);
	    tv.setText(response.tel);
	    final String num = "tel:"+response.tel.replaceAll("/", "").trim();
	    tv.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(num)); 
		        startActivity(callIntent);
			}
			
			
		});
	    
	    
	    
	    tv = (TextView) findViewById(R.id.smuciscevisinasnega);
	    tv.setText(response.sneg);
	    
	    tv = (TextView) findViewById(R.id.smucisceveter);
	    tv.setText(response.wind);
	    
	    ImageView iv = (ImageView) findViewById(R.id.slikasmucisca);
	    if(response.picture.length() != 0){
	    	Drawable da = LoadImageFromWebOperations(response.picture.replace(" ", "%20"));
	    	Toast.makeText(this, response.picture, Toast.LENGTH_LONG).show();
		    iv.setImageDrawable(da);
		    
	    } else {
	    	Toast.makeText(this, "Ni slike!", Toast.LENGTH_LONG).show();
	    }
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

}



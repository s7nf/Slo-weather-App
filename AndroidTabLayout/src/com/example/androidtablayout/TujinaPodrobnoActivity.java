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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TujinaPodrobnoActivity extends Activity
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.tujinapodrobno);
	    
	    String mesto = getIntent().getExtras().getString("kraj");
	    
	    InputStream source = retrieveStream("http://repinc.eu:8082/blaz/cities/"+mesto.replaceAll(" ", "%20")+".json");
	    Gson gson = new Gson();
	    Reader reader = new InputStreamReader(source);
	    Tujina response = gson.fromJson(reader, Tujina.class);
	    
	    TextView tv = (TextView) findViewById(R.id.tujinaime);
	    tv.setText(response.name.toUpperCase());
	    
	    tv = (TextView) findViewById(R.id.tujinasmervetra);
	    tv.setText(response.smer);
	    
	    tv = (TextView) findViewById(R.id.tujinatemeratura);
	    tv.setText(response.temperatura);
	    
	    tv = (TextView) findViewById(R.id.tujinaveter);
	    tv.setText(response.hitrost);
	    
	    tv = (TextView) findViewById(R.id.tujinavreme);
	    tv.setText(response.vreme);
	    
	    /*LinearLayout myLayout = (LinearLayout) findViewById(R.layout.tujinapodrobno);

	    Button myButton = new Button(this);
	    myButton.setLayoutParams(new LinearLayout.LayoutParams(
	                                         LinearLayout.LayoutParams.FILL_PARENT,
	                                         LinearLayout.LayoutParams.FILL_PARENT));

	    myLayout.addView(myButton);
	    */
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

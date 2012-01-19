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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VodePodrobnoActivity extends Activity
{

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.vodepodrobno);
	    Bundle bundle = getIntent().getExtras();
	    String mesto = bundle.getString("kraj");
	    InputStream source = retrieveStream("http://repinc.eu:8082/blaz/water/"+mesto.replaceAll(" ", "%20")+".json");
	    Gson gson = new Gson();
	    Reader reader = new InputStreamReader(source);
	    WaterData response = gson.fromJson(reader, WaterData.class);
	    
	    
	    TextView tv = (TextView) findViewById(R.id.VodaIime);
	    tv.setText(mesto);
	    
	    tv = (TextView) findViewById(R.id.StanjeVoda);
	    tv.setText(response.stanje);
	    
	    tv = (TextView) findViewById(R.id.VodaTemeratura);
	    tv.setText(response.temperatura);
	    
	    tv = (TextView) findViewById(R.id.VodostajVoda);
	    tv.setText(response.vodostaj);
	    
	    tv = (TextView) findViewById(R.id.PretokVoda);
	    tv.setText(response.pretok);
	    
	   // ImageView iv = (ImageView) findViewById(R.id.slikavodegraf);
	   // Drawable da = LoadImageFromWebOperations(response.link);
	   // iv.setImageDrawable(da);
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

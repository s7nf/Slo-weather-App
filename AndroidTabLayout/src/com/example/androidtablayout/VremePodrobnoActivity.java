package com.example.androidtablayout;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class VremePodrobnoActivity extends Activity
{
	TextView tv;
	Button b;
	String mesto;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.test);
	    
	    //setContentView(R.layout.vremepodrobno);
	    mesto = getIntent().getExtras().getString("kraj");
	    InputStream source = retrieveStream("http://repinc.eu:8082/blaz/samodejnePostaje/"+mesto.replaceAll(" ", "%20")+".json");
	    Gson gson = new Gson();
	    Reader reader = new InputStreamReader(source);
	    
	    
	    SamodejnaPostaja response = gson.fromJson(reader, SamodejnaPostaja.class);
	   
	    
	    
	    tv = (TextView) findViewById(R.id.postajaIime);
	    tv.setText(mesto.toUpperCase());
	    
	    tv = (TextView) findViewById(R.id.postajaTemeratura);
	    tv.setText(response.temperatura);
	    
	    tv = (TextView) findViewById(R.id.postajaVeterHitrost);
	    tv.setText(response.hitrost);
	    
	    tv = (TextView) findViewById(R.id.postajaPadavine);
	    tv.setText(response.padavine);
	    
	    tv = (TextView) findViewById(R.id.PostajaVlažnost);
	    tv.setText(response.vlaznost);
	    
	    tv = (TextView) findViewById(R.id.PostajaSunki);
	    tv.setText(response.sunki);
	    
	    tv = (TextView) findViewById(R.id.PostajaTlak);
	    tv.setText(response.tlak);
	    
	    tv = (TextView) findViewById(R.id.PostajaSmer);
	    tv.setText(response.smer);
	    
	    tv = (TextView) findViewById(R.id.PostajaSevanje);
	    tv.setText(response.sevanje);
	    

	    b = (Button) findViewById(R.id.PostajaSlikaButton);
	    final SamodejnaPostaja sp = response;
	    
	    b.setOnClickListener(new OnClickListener(){
	    	
	    	
	    	ImageView img;
	    	Dialog dialog;
	    	
	    	public void onClick(View v) {
	    		dialog = new Dialog(VremePodrobnoActivity.this);
	    		dialog.setContentView(R.layout.slikakraja);
	    		
	    		if(sp.picture.length() != 0){
	    			Drawable drawable = LoadImageFromWebOperations(sp.picture);
		    		dialog.setTitle("Slika mesta: "+mesto);
		    		img = (ImageView) dialog.findViewById(R.id.slikakraja1);
		    		img.setImageDrawable(drawable);
		    		dialog.show();
	    			
	    		} else {
	    			//dialog.setTitle("Žal slika "+mesto+" ni na voljo");
	    		}
	    		
	    		
	    		img.setOnClickListener(new OnClickListener(){
	    			public void onClick(View v) {
	    				dialog.dismiss();
	    			}
	    		
	    		});
	    		
	    		
	    		
	    		
	    	}
	    });
	
	    
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

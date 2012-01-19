package com.example.androidtablayout;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CroActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.hrobala);
	    TextView tv;
	    
	    InputStream source = retrieveStream("http://repinc.eu:8082/blaz/sea/seaData.json");
	    Gson gson = new Gson();
	    Reader reader = new InputStreamReader(source);
	    
	    Cro response = gson.fromJson(reader, Cro.class);
	    ArrayList al = response.l;
	    
	    
	    
	    
	    
	    
	    
	    ArrayList tmp = (ArrayList) al.get(0);
	    	tv = (TextView) findViewById(R.id.obsedmih1);
		    tv.setText(tmp.get(1).toString());
	    
	    	tv = (TextView) findViewById(R.id.obtrinastih1);
		    tv.setText(tmp.get(2).toString());	    	
	    
		    
	    tmp = (ArrayList) al.get(1);
	    	tv = (TextView) findViewById(R.id.obsedmih2);
		    tv.setText(tmp.get(1).toString());
	    
	    	tv = (TextView) findViewById(R.id.obtrinastih2);
		    tv.setText(tmp.get(2).toString());
	    
		    
	    tmp = (ArrayList) al.get(2);
	    	tv = (TextView) findViewById(R.id.obsedmih3);
		    tv.setText(tmp.get(1).toString());
	    
	    	tv = (TextView) findViewById(R.id.obtrinastih3);
		    tv.setText(tmp.get(2).toString());
	    
	    
	    
	    
	    tmp = (ArrayList) al.get(3);
	    	tv = (TextView) findViewById(R.id.obsedmih4);
		    tv.setText(tmp.get(1).toString());
	    	tv = (TextView) findViewById(R.id.obtrinastih4);
		    tv.setText(tmp.get(2).toString());
	    
	    
	    
	    tmp = (ArrayList) al.get(4);
	    	tv = (TextView) findViewById(R.id.obsedmih5);
		    tv.setText(tmp.get(1).toString());
	    
	    
	    	tv = (TextView) findViewById(R.id.obtrinastih5);
		    tv.setText(tmp.get(2).toString());
	    
	    
	    
	    
	    tmp = (ArrayList) al.get(5);
	    
	    	tv = (TextView) findViewById(R.id.obsedmih6);
		    tv.setText(tmp.get(1).toString());
	    
	    	tv = (TextView) findViewById(R.id.obtrinastih6);
		    tv.setText(tmp.get(2).toString());
	    
	    
	    
	    tmp = (ArrayList) al.get(6);
	    tv = (TextView) findViewById(R.id.obsedmih7);
	    tv.setText(tmp.get(1).toString());
	    
	    tv = (TextView) findViewById(R.id.obtrinastih7);
	    tv.setText(tmp.get(2).toString());
	    
	    
	    tmp = (ArrayList) al.get(7);
	    tv = (TextView) findViewById(R.id.obsedmih8);
	    tv.setText(tmp.get(1).toString());
	    
	    tv = (TextView) findViewById(R.id.obtrinastih8);
	    tv.setText(tmp.get(2).toString());
	    
	    
	    
	    tmp = (ArrayList) al.get(8);
	    tv = (TextView) findViewById(R.id.obsedmih10);
	    tv.setText(tmp.get(1).toString());
	    
	    tv = (TextView) findViewById(R.id.obtrinastih10);
	    tv.setText(tmp.get(2).toString());
	    
	    
	    tmp = (ArrayList) al.get(9);
	    tv = (TextView) findViewById(R.id.obsedmih11);
	    tv.setText(tmp.get(1).toString());
	    
	    tv = (TextView) findViewById(R.id.obtrinastih11);
	    tv.setText(tmp.get(2).toString());
	    
	    
	    tmp = (ArrayList) al.get(10);
	    tv = (TextView) findViewById(R.id.obsedmih12);
	    tv.setText(tmp.get(1).toString());
	    
	    tv = (TextView) findViewById(R.id.obtrinastih12);
	    tv.setText(tmp.get(2).toString());
	    
	    
	    tmp = (ArrayList) al.get(11);
	    tv = (TextView) findViewById(R.id.obsedmih13);
	    tv.setText(tmp.get(1).toString());
	       
	    tv = (TextView) findViewById(R.id.obtrinastih13);
	    tv.setText(tmp.get(2).toString());
	   
	   
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
	


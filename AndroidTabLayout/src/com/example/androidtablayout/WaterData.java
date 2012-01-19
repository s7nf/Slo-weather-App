package com.example.androidtablayout;

import com.google.gson.annotations.SerializedName;


public class WaterData
{
	@SerializedName("name")
    public String name;
	
	@SerializedName("stanje")
    public String stanje;
	
	@SerializedName("temperatura")
    public String temperatura;
	
	@SerializedName("vodostaj")
    public String vodostaj;
	
	@SerializedName("pretok")
    public String pretok;
}

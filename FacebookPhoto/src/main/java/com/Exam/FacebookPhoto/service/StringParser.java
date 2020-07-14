package com.Exam.FacebookPhoto.service;

import com.google.gson.Gson;

import com.Exam.FacebookPhoto.Model.Metadata;
import com.Exam.FacebookPhoto.util.Stats.*;
import com.Exam.FacebookPhoto.Model.PhotoData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.Exam.FacebookPhoto.Model.Data;

//classe  utile per adattare la Stringa ottenuta dal JSON all'oggetto photos 

public class StringParser {

	private static Metadata metadata = new Metadata();
	private static ArrayList<PhotoData> photodata = new ArrayList<PhotoData>();
	
	
	
	

	public static Metadata StringToPhotos(String data) {

		Gson gson = new Gson();
		metadata = gson.fromJson(data, Metadata.class);
		return metadata;

	}

	public static ArrayList<PhotoData> DataConverter() {
		photodata.clear();
		
		for (int i = 0; i < metadata.photos.data.size(); i++) {

			metadata.photos.data.get(i).getCreated_time();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
			Date resultDate = null;
			{
				try {
					resultDate = df.parse(metadata.photos.data.get(i).getCreated_time()); // created_time
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			Calendar c = Calendar.getInstance();
			c.setTime(resultDate);
			PhotoData pd = new PhotoData(c.get(Calendar.DATE), new SimpleDateFormat("MMM").format(c.getTime()),
					c.get(Calendar.YEAR), new SimpleDateFormat("MMM").format(c.getTime()),
					metadata.photos.data.get(i).getId());

			photodata.add(pd);

		

		}
		return photodata;
	}
	
	public static ArrayList<String> getPhotoDataString(ArrayList<PhotoData> s) {
		ArrayList<String> photodatastring1 =new ArrayList<String>();
		photodatastring1.clear();
		
		for (int i = 0; i < s.size(); i++) { 
		photodatastring1.add("foto con id  " + s.get(i).getId() +" caricata il " + s.get(i).getDay() + " " +s.get(i).getMonth() + " "+   s.get(i).getYear());
		
		}
		int n= photodatastring1.size()-1 ;
		photodatastring1.add("hai caricato un totale di " +(n+1)+ " foto dal " + s.get(n).getDay() + " " +s.get(n).getMonth() + " "+ s.get(n).getYear()+ " ad oggi ");
		return photodatastring1;
	}
	
	

	public static ArrayList<Data> getArrayData() {

		return metadata.photos.data;
	}
	
	
	public static ArrayList<String> getStats(ArrayList<PhotoData> pd){
		ArrayList<String> results = new ArrayList<String>();
		
		try {
			results.add("Totale foto caricate  : " + Stats.TotPhoto(pd) );
			results.add("Media foto per GIORNO : " + Stats.MediaPhotoDays(pd));
			results.add("Media foto per MESE   : " + Stats.MediaPhotoMonth(pd));
			results.add("Media foto per ANNO   : " + Stats.MediaPhotoYear(pd));
			results.add("Il mese in cui hai caricato più foto è   : " + Stats.FavoriteMonth(pd));
			results.add("L'anno in cui hai caricato più foto è   : " + Stats.FavoriteYear(pd));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return results;
	}
	
	

}

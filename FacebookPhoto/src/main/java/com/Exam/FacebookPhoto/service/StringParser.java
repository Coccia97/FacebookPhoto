package com.Exam.FacebookPhoto.service;

import com.google.gson.Gson;

import com.Exam.FacebookPhoto.Model.Metadata;
import com.Exam.FacebookPhoto.util.Stats.*;
import com.Exam.FacebookPhoto.Model.PhotoData;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.Exam.FacebookPhoto.Model.Data;

/**
 * 
 * classe che svolge piu funzioni :
 * -trasforma la stringa ottenuta tramite DownloadURL in un tipo Metadata
 * - ottento un ArrayList<PhotoData> a partire dal Metadata 
 * - genera le uscite per le richieste GET/ e POST 
 * 
 * @author Andrea Marcheggiani
 * @author Francesco columbaro
 * @param metadata inizializzo la variabile metadata 
 * @param photodata inizializzo la variabile ArrayList<Photodata>
 * 
 */

public class StringParser {

	private static Metadata metadata = new Metadata();
	private static ArrayList<PhotoData> photodata = new ArrayList<PhotoData>();
	
	/**
	 * 
	 * @param data stringa ottenuta tramite DownloadURL
	 * @return metadata contenente i dati del JSON ordinati in classi 
	 */

	public static Metadata StringToPhotos(String data) {

		Gson gson = new Gson();
		metadata = gson.fromJson(data, Metadata.class);
		return metadata;

	}
	/**
	 *converte metadata in un  ArrayList<PhotoData> che, a differenza di metadata ha i parametri giorno mese e anno ordinati 
	 *quindi più facili da elaborare e trattare 
	 *
	 * @return ArrayList<PhotoData> 
	 */
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
			String dayNames[] = new DateFormatSymbols().getWeekdays();
			PhotoData pd = new PhotoData(c.get(Calendar.DATE), new SimpleDateFormat("MMM").format(c.getTime()),
					c.get(Calendar.YEAR), dayNames[c.get(Calendar.DAY_OF_WEEK)],
					metadata.photos.data.get(i).getId());

			photodata.add(pd);

		

		}
		return photodata;
	}
	
	/**
	 * trasforma ogni elemento ArrayList<PhotoData> in una stringa 
	 * serve per la richiesta GET/allphoto
	 * 
	 * @param s ArrayList<PhotoData> ottenito tramite DataConverter 
	 * @return ArrayList<String>
	 */
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
	
	/**
	 * estrae dal metadata il solo ArrayList<Data>
	 * @return ArrayList<Data> 
	 */

	public static ArrayList<Data> getArrayData() {

		return metadata.photos.data;
	}
	
	/**
	 * prende in input ArrayList<PhotoData> e mi rida una serie di stringhe contenenti le statisticeh ottenute tramite Stats
	 * serve per la richiesta GET/photodata
	 * 
	 * @param pd ArrayList<PhotoData> ottenito tramite DataConverter 
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> getStats(ArrayList<PhotoData> pd){
		ArrayList<String> results = new ArrayList<String>();
		
		try {
			results.add("Totale foto caricate  : " + Stats.TotPhoto(pd) );
			results.add("Media foto per GIORNO : " + Stats.MediaPhotoDays(pd));
			results.add("Media foto per MESE   : " + Stats.MediaPhotoMonth(pd));
			results.add("Media foto per ANNO   : " + Stats.MediaPhotoYear(pd));
			results.add("Il mese in cui hai caricato più foto è   : " + Stats.FavoriteMonth(pd));
			results.add("L'anno in cui hai caricato più foto è   : " + Stats.FavoriteYear(pd));
			results.add("il giorno in cui hai caricato più foto è   : " + Stats.FavoriteDay(pd));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return results;
	}
	
	

}

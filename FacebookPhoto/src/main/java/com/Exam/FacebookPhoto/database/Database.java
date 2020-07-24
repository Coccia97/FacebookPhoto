package com.Exam.FacebookPhoto.database;

import com.Exam.FacebookPhoto.model.Metadata;
import com.Exam.FacebookPhoto.util.stats.*;
import com.Exam.FacebookPhoto.model.PhotoData;
import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.Exam.FacebookPhoto.model.Data;

/**
 * 
 * classe che svolge piu funzioni : 
 * - ottento un ArrayList di PhotoData a partire
 * dal Metadata - genera le uscite per le richieste GET/ e POST
 * 
 * @author Andrea Marcheggiani
 * @author Francesco columbaro
 * 
 */

public class Database {

	private static Metadata metadata = new Metadata();

	private static ArrayList<PhotoData> photodata = new ArrayList<PhotoData>();
	
	/**
	 * classe chiamata direttamente dal main, prima prende l'URL e lo manda a DownloadFromURL,
	 * riceve una stringa che poi manda a StringParser per ottenere l'ogetto Metadata
	 * @param url link per ottenere il JSON tramite api Facebook
	 */

	public static void JsonToMetadata(String url) {
		metadata = StringParser.StringToPhotos(DownloadFromURL.JsonToString(url));

	}

	/**
	 * converte metadata in un ArrayList di PhotoData che, a differenza di metadata ha
	 * i parametri giorno mese e anno ordinati quindi più facili da elaborare e
	 * trattare
	 *
	 * @return ArrayList di PhotoData
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
					c.get(Calendar.YEAR), dayNames[c.get(Calendar.DAY_OF_WEEK)], metadata.photos.data.get(i).getId());

			photodata.add(pd);

		}
		return photodata;
	}

	/**
	 * trasforma ogni elemento ArrayList di PhotoData in una stringa serve per la
	 * richiesta GET/allphoto
	 * 
	 * @param s ArrayList di PhotoData ottenito tramite DataConverter
	 * @return ArrayList di String
	 */
	public static ArrayList<String> getPhotoDataString(ArrayList<PhotoData> s) {
		ArrayList<String> photodatastring1 = new ArrayList<String>();
		photodatastring1.clear();

		for (int i = 0; i < s.size(); i++) {
			photodatastring1.add("foto con id  " + s.get(i).getId() + " caricata il " + s.get(i).getDay() + " "
					+ s.get(i).getMonth() + " " + s.get(i).getYear());

		}
		int n = photodatastring1.size() - 1;
		photodatastring1.add("hai caricato un totale di " + (n + 1) + " foto dal " + s.get(n).getDay() + " "
				+ s.get(n).getMonth() + " " + s.get(n).getYear() + " ad oggi ");
		return photodatastring1;
	}

	/**
	 * estrae dal metadata il solo ArrayList di Data
	 * 
	 * @return ArrayList di Data
	 */

	public static ArrayList<Data> getArrayData() {

		return metadata.photos.data;
	}

	/**
	 * prende in input ArrayList di PhotoData e mi rida una serie di stringhe
	 * contenenti le statisticeh ottenute tramite Stats serve per la richiesta
	 * GET/photodata
	 * 
	 * @param pd ArrayList di PhotoData ottenito tramite DataConverter
	 * @return ArrayList di String
	 */
	public static ArrayList<String> getStats(ArrayList<PhotoData> pd) {
		ArrayList<String> results = new ArrayList<String>();

		try {
			results.add("Totale foto caricate  : " + Stats.TotPhoto(pd));
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

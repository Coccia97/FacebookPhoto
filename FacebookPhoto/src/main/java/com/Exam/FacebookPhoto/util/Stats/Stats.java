package com.Exam.FacebookPhoto.util.Stats;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.Exam.FacebookPhoto.Model.Counter;
import com.Exam.FacebookPhoto.Model.PhotoData;
/**
 * 
 * classe che implementa i metodi per ottenere le statistiche riguardo a partire da un Arraylist di PhotoData
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class Stats {

	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return numero di giorni tra il primo e l'ultimo caricamento 
	 * @throws ParseException
	 */
	private static long TotDays(ArrayList<PhotoData> pd) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
		Date firstdate = sdf.parse(pd.get(0).getYear() + "-" + pd.get(0).getMonth() + "-" + pd.get(0).getDay());
		int n = pd.size() - 1;
		Date lastdate = sdf.parse(pd.get(n).getYear() + "-" + pd.get(n).getMonth() + "-" + pd.get(n).getDay());
		long diffmillies = Math.abs(lastdate.getTime() - firstdate.getTime());
		long diff = TimeUnit.DAYS.convert(diffmillies, TimeUnit.MILLISECONDS);

		return diff;
	}
	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return numero di elementi contenuti in pd 
	 */

	public static int TotPhoto(ArrayList<PhotoData> pd) {
		System.out.println(pd.size());
		return pd.size();
	}
	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return media foto caricate ogni giorno 
	 * @throws ParseException errore di parsing 
	 */

	public static double MediaPhotoDays(ArrayList<PhotoData> pd) throws ParseException {

		int n = pd.size() - 1;
		double avg = (double) n / (double) TotDays(pd);

		return avg;
	}
	/**
	 *
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return media foto caricate ogni giorno 
	 * @throws ParseException errore di parsing 
	 */

	public static double MediaPhotoMonth(ArrayList<PhotoData> pd) throws ParseException {

		int n = pd.size() - 1;
		double avg = (double) n / ((double) TotDays(pd) / 30.4);

		return avg;
	}
	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return media foto caricate ogni anno 
	 * @throws ParseException errore di parsing 
	 */

	public static double MediaPhotoYear(ArrayList<PhotoData> pd) throws ParseException {

		int n = pd.size() - 1;
		double avg = (double) n / ((double) TotDays(pd) / 365);

		return avg;
	}
	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return mese in cui hai caricato più foto
	 */

	public static String FavoriteMonth(ArrayList<PhotoData> pd) {
		ArrayList<Counter> mc = new ArrayList<Counter>();

		int gen = 0;
		int feb = 0;
		int mar = 0;
		int apr = 0;
		int mag = 0;
		int giu = 0;
		int lug = 0;
		int ago = 0;
		int set = 0;
		int ott = 0;
		int nov = 0;
		int dic = 0;

		for (int i = 0; i < pd.size(); i++) {
			if (pd.get(i).getMonth().compareTo("gen") == 0)
				gen += 1;
			else if (pd.get(i).getMonth().compareTo("feb") == 0)
				feb += 1;
			else if (pd.get(i).getMonth().compareTo("mar") == 0)
				mar += 1;
			else if (pd.get(i).getMonth().compareTo("apr") == 0)
				apr += 1;
			else if (pd.get(i).getMonth().compareTo("mag") == 0)
				mag += 1;
			else if (pd.get(i).getMonth().compareTo("giu") == 0)
				giu += 1;
			else if (pd.get(i).getMonth().compareTo("lug") == 0)
				lug += 1;
			else if (pd.get(i).getMonth().compareTo("ago") == 0)
				ago += 1;
			else if (pd.get(i).getMonth().compareTo("set") == 0)
				set += 1;
			else if (pd.get(i).getMonth().compareTo("ott") == 0)
				ott += 1;
			else if (pd.get(i).getMonth().compareTo("nov") == 0)
				nov += 1;
			else
				dic += 1;

		}
		mc.add(new Counter("Gennaio", gen));
		mc.add(new Counter("Febbraio", feb));
		mc.add(new Counter("Marzo", mar));
		mc.add(new Counter("Aprile", apr));
		mc.add(new Counter("Maggio", mag));
		mc.add(new Counter("Giugno", giu));
		mc.add(new Counter("Luglio", lug));
		mc.add(new Counter("Agosto", ago));
		mc.add(new Counter("Settembre", set));
		mc.add(new Counter("Ottobre", ott));
		mc.add(new Counter("Novembre", nov));
		mc.add(new Counter("Dicembre", dic));
		Counter temp = mc.get(0);
		for (int i = 0; i < mc.size() - 1; i++) {
			if (mc.get(i).getCounter() > temp.getCounter())
				temp = mc.get(i);

		}
		return temp.getString();
	}
	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return anno in cui hai caricato più foto
	 */

	public static int FavoriteYear(ArrayList<PhotoData> pd) {
		ArrayList<Counter> yc = new ArrayList<Counter>();

		int dieci = 0;
		int undici = 0;
		int dodici = 0;
		int tredici = 0;
		int quattordici = 0;
		int quindici = 0;
		int sedici = 0;
		int diciassette = 0;
		int diciotto = 0;
		int diciannove = 0;
		int venti = 0;

		for (int i = 0; i < pd.size(); i++) {
			if (pd.get(i).getYear() == 2010)
				dieci += 1;
			else if (pd.get(i).getYear() == 2011)
				undici += 1;
			else if (pd.get(i).getYear() == 2012)
				dodici += 1;
			else if (pd.get(i).getYear() == 2013)
				tredici += 1;
			else if (pd.get(i).getYear() == 2014)
				quattordici += 1;
			else if (pd.get(i).getYear() == 2015)
				quindici += 1;
			else if (pd.get(i).getYear() == 2016)
				sedici += 1;
			else if (pd.get(i).getYear() == 2017)
				diciassette += 1;
			else if (pd.get(i).getYear() == 2018)
				diciotto += 1;
			else if (pd.get(i).getYear() == 2019)
				diciannove += 1;
			else
				venti += 1;

		}
		yc.add(new Counter(2010, dieci));
		yc.add(new Counter(2011, undici));
		yc.add(new Counter(2012, dodici));
		yc.add(new Counter(2013, tredici));
		yc.add(new Counter(2014, quattordici));
		yc.add(new Counter(2015, quindici));
		yc.add(new Counter(2016, sedici));
		yc.add(new Counter(2017, diciassette));
		yc.add(new Counter(2018, diciotto));
		yc.add(new Counter(2019, diciannove));
		yc.add(new Counter(2020, venti));

		Counter temp1 = yc.get(0);
		for (int i = 0; i < yc.size(); i++) {
			if (yc.get(i).getCounter() > temp1.getCounter()) {
				temp1 = yc.get(i);
			}
		}
		return temp1.getNum();
	}
	/**
	 * 
	 * @param pd Arraylist di PhotoData contenente tutti i dati sulle foto caricate
	 * @return giorno in cui hai caricato più foto
	 */

	public static String FavoriteDay(ArrayList<PhotoData> pd) {
		ArrayList<Counter> yc = new ArrayList<Counter>();

		int lun = 0;
		int mar = 0;
		int mer = 0;
		int gio = 0;
		int ven = 0;
		int sab = 0;
		int dom = 0;

		for (int i = 0; i < pd.size(); i++) {
			if (pd.get(i).getDayName().compareTo("lunedì") == 0)
				lun += 1;
			else if (pd.get(i).getDayName().compareTo("martedì") == 0)
				mar += 1;
			else if (pd.get(i).getDayName().compareTo("mercoledì") == 0)
				mer += 1;
			else if (pd.get(i).getDayName().compareTo("giovedì") == 0)
				gio += 1;
			else if (pd.get(i).getDayName().compareTo("venerdì") == 0)
				ven += 1;
			else if (pd.get(i).getDayName().compareTo("sabato") == 0)
				sab += 1;
			else
				dom += 1;

		}
		yc.add(new Counter("Lunedì", lun));
		yc.add(new Counter("Martedì", mar));
		yc.add(new Counter("Mercoledì", mer));
		yc.add(new Counter("Giovedì", gio));
		yc.add(new Counter("Venerdì", ven));
		yc.add(new Counter("Sabato", sab));
		yc.add(new Counter("Domenica", dom));

		Counter temp2 = yc.get(0);
		for (int i = 0; i < yc.size(); i++) {
			if (yc.get(i).getCounter() > temp2.getCounter()) {
				temp2 = yc.get(i);
			}
		}
		return temp2.getString();
	}

}

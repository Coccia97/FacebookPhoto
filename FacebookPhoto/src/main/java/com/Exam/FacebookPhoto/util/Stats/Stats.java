package com.Exam.FacebookPhoto.util.Stats;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.Model.StringCounter;
import com.Exam.FacebookPhoto.Model.YearCounter;

public class Stats {

	private static long TotDays(ArrayList<PhotoData> pd) throws ParseException {
		DateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
		Date firstdate = sdf.parse(pd.get(0).getYear() + "-" + pd.get(0).getMonth() + "-" + pd.get(0).getDay());
		int n = pd.size() - 1;
		Date lastdate = sdf.parse(pd.get(n).getYear() + "-" + pd.get(n).getMonth() + "-" + pd.get(n).getDay());
		long diffmillies = Math.abs(lastdate.getTime() - firstdate.getTime());
		long diff = TimeUnit.DAYS.convert(diffmillies, TimeUnit.MILLISECONDS);

		return diff;
	}

	public static int TotPhoto(ArrayList<PhotoData> pd) {
		System.out.println(pd.size());
		return pd.size();
	}

	public static double MediaPhotoDays(ArrayList<PhotoData> pd) throws ParseException {

		int n = pd.size() - 1;
		double avg = (double) n / (double) TotDays(pd);

		return avg;
	}

	public static double MediaPhotoMonth(ArrayList<PhotoData> pd) throws ParseException {

		int n = pd.size() - 1;
		double avg = (double) n / ((double) TotDays(pd) / 30.4);

		return avg;
	}

	public static double MediaPhotoYear(ArrayList<PhotoData> pd) throws ParseException {

		int n = pd.size() - 1;
		double avg = (double) n / ((double) TotDays(pd) / 365);

		return avg;
	}

	public static String FavoriteMonth(ArrayList<PhotoData> pd) {
		ArrayList<StringCounter> mc = new ArrayList<StringCounter>();

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
		mc.add(new StringCounter("Gennaio", gen));
		mc.add(new StringCounter("Febbraio", feb));
		mc.add(new StringCounter("Marzo", mar));
		mc.add(new StringCounter("Aprile", apr));
		mc.add(new StringCounter("Maggio", mag));
		mc.add(new StringCounter("Giugno", giu));
		mc.add(new StringCounter("Luglio", lug));
		mc.add(new StringCounter("Agosto", ago));
		mc.add(new StringCounter("Settembre", set));
		mc.add(new StringCounter("Ottobre", ott));
		mc.add(new StringCounter("Novembre", nov));
		mc.add(new StringCounter("Dicembre", dic));
		StringCounter temp = mc.get(0);
		for (int i = 0; i < mc.size() - 1; i++) {
			if (mc.get(i).getCounter() > temp.getCounter())
				temp = mc.get(i);

		}
		return temp.getString();
	}

	public static int FavoriteYear(ArrayList<PhotoData> pd) {
		ArrayList<YearCounter> yc = new ArrayList<YearCounter>();

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
		yc.add(new YearCounter(2010, dieci));
		yc.add(new YearCounter(2011, undici));
		yc.add(new YearCounter(2012, dodici));
		yc.add(new YearCounter(2013, tredici));
		yc.add(new YearCounter(2014, quattordici));
		yc.add(new YearCounter(2015, quindici));
		yc.add(new YearCounter(2016, sedici));
		yc.add(new YearCounter(2017, diciassette));
		yc.add(new YearCounter(2018, diciotto));
		yc.add(new YearCounter(2019, diciannove));
		yc.add(new YearCounter(2020, venti));

		YearCounter temp1 = yc.get(0);
		for (int i = 0; i < yc.size(); i++) {
			if (yc.get(i).getCounter() > temp1.getCounter()) {
				temp1 = yc.get(i);
			}
		}
		return temp1.getYear();
	}

	public static String FavoriteDay(ArrayList<PhotoData> pd) {
		ArrayList<StringCounter> yc = new ArrayList<StringCounter>();

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
		yc.add(new StringCounter("Lunedì", lun));
		yc.add(new StringCounter("Martedì", mar));
		yc.add(new StringCounter("Mercoledì", mer));
		yc.add(new StringCounter("Giovedì", gio));
		yc.add(new StringCounter("Venerdì", ven));
		yc.add(new StringCounter("Sabato", sab));
		yc.add(new StringCounter("Domenica", dom));

		StringCounter temp2 = yc.get(0);
		for (int i = 0; i < yc.size(); i++) {
			if (yc.get(i).getCounter() > temp2.getCounter()) {
				temp2 = yc.get(i);
			}
		}
		return temp2.getString();
	}

}

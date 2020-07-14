package com.Exam.FacebookPhoto.util.Stats;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.Exam.FacebookPhoto.Model.MonthCounter;
import com.Exam.FacebookPhoto.Model.PhotoData;
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
		ArrayList<MonthCounter> mc = new ArrayList<MonthCounter>();

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
		mc.add(new MonthCounter("Gennaio", gen));
		mc.add(new MonthCounter("Febbraio", feb));
		mc.add(new MonthCounter("Marzo", mar));
		mc.add(new MonthCounter("Aprile", apr));
		mc.add(new MonthCounter("Maggio", mag));
		mc.add(new MonthCounter("Giugno", giu));
		mc.add(new MonthCounter("Luglio", lug));
		mc.add(new MonthCounter("Agosto", ago));
		mc.add(new MonthCounter("Settembre", set));
		mc.add(new MonthCounter("Ottobre", ott));
		mc.add(new MonthCounter("Novembre", nov));
		mc.add(new MonthCounter("Dicembre", dic));
		MonthCounter temp = mc.get(0);
		for (int i = 0; i < mc.size() - 1; i++) {
			if (mc.get(i).getCounter() >temp.getCounter())
				temp = mc.get(i);

		}
		return temp.getMese();
	}

public static int  FavoriteYear(ArrayList<PhotoData> pd) {
	ArrayList<YearCounter> yc = new ArrayList<YearCounter>();

	int dieci=0;
	int undici=0;
	int dodici=0;
	int tredici=0;
	int quattordici=0;
	int quindici=0;
	int sedici=0;
	int diciassette=0;
	int diciotto=0;
	int diciannove=0;
	int venti=0;

	for (int i = 0; i < pd.size(); i++) {
		if (pd.get(i).getYear() == 2010)
			dieci +=1;
		else if (pd.get(i).getYear() == 2011)
			undici +=1;
		else if (pd.get(i).getYear() == 2012)
			dodici +=1;
		else if (pd.get(i).getYear() == 2013)
			tredici +=1;
		else if (pd.get(i).getYear() == 2014)
			quattordici +=1;
		else if (pd.get(i).getYear() == 2015)
			quindici +=1;
		else if (pd.get(i).getYear() == 2016)
			sedici +=1;
		else if (pd.get(i).getYear() == 2017)
			diciassette +=1;
		else if (pd.get(i).getYear() == 2018)
			diciotto +=1;
		else if (pd.get(i).getYear() == 2019)
			diciannove +=1;
		else  
		venti +=1;
		

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
	
	YearCounter temp1=yc.get(0);
	for(int i=0; i<yc.size(); i++) {
		if(yc.get(i).getCounter()>temp1.getCounter()) {
			temp1=yc.get(i);
	}
	}
return temp1.getYear();
}

}

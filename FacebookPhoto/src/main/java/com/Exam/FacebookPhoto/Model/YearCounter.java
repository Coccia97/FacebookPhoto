package com.Exam.FacebookPhoto.Model;
/**
 * 
 * classe con lo scopo di contare quante volte ricorre un certo anno(Year) tramite counter a fini statistici 
 * (in conteggio è fatto tramite un metodo presente in Stats)
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param Year Anno da considerare  
 * @param counter   numero di iterazioni di quell'anno 
 * 
 */
public class YearCounter {
	int Year;
	int Counter;

	public YearCounter(int year, int counter) {
		super();
		this.Year = year;
		this.Counter = counter;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		this.Year = year;
	}

	public int getCounter() {
		return Counter;
	}

	public void setCounter(int counter) {
		this.Counter = counter;
	}

}

package com.Exam.FacebookPhoto.Model;

/**
 * 
 * classe con lo scopo di contare il numero di iterazioni di una certa string tramite counter a fini statistici
 * (in conteggio è fatto tramite un metodo presente in Stats)
 * in particolare la stinga da considerare corrisponde ad un cero mese o giorno della settimana 
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param string Stringa da considerare  
 * @param counter   numero di iterazioni della stringa 
 * 
 */
public class StringCounter {
	private String string;
	private int counter;

	public StringCounter(String string, int counter) {
		super();
		this.string = string;
		this.counter = counter;
	}

	public String getString() {
		return string;
	}

	public void setMese(String string) {
		this.string = string;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}

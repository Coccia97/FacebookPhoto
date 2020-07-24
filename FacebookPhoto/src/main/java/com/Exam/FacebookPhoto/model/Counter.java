package com.Exam.FacebookPhoto.model;

import java.util.ArrayList;

/**
 * 
 * classe con lo scopo di contare il numero di iterazioni di una certa string  o di un intero num tramite counter a fini statistici
 * (in conteggio è fatto tramite un metodo presente in Stats)
 * in particolare la stinga da considerare corrisponde ad un cero mese o giorno della settimana 
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 */
public class Counter {
	private String string;
	private int counter;
	private int num;
	
	
	public Counter(String string, int counter) {
		super();
		this.string = string;
		this.counter = counter;
	}
	public Counter(int num, int counter) {
		super();
		this.num  = num;
		this.counter = counter;
	}
	
	/**
	 * 
	 * @param alc ArrayList di Counter contenente il giorno/mese/anno è il numero delle volte in cui è presente 
	 * @return l'elemento con il parametro counter maggiore
	 */
	public static Counter ReturnMax(ArrayList<Counter> alc) {
	
		Counter temp = alc.get(0);
		for (int i = 0; i < alc.size(); i++) {
			if (alc.get(i).getCounter() > temp.getCounter())
				temp = alc.get(i);
		
		

	}
		return temp;
		}
	

	public String getString() {
		return string;
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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

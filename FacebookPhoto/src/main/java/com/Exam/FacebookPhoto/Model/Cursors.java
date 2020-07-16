package com.Exam.FacebookPhoto.Model;
/**
 * 
 * una serie di classi che ha lo scopo di modellare il JSON per rendere
 * i dati maneggiabili
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param before   dati non utili per i nostri fini 
 * @param after   dati non utili per i nostri fini
 * 
 */
public class Cursors {
	private String before;
	private String after;

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

}

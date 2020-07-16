package com.Exam.FacebookPhoto.Model;

/**
 * 
 * una serie di classi che ha lo scopo di modellare il JSON per rendere
 * i dati maneggiabili
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param created_time   data di creazione della foto 
 * @param id rappresenta l'identificativo della nostra foto
 * 
 */

public class Data {
	String created_time;
	String id;

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

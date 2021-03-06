package com.Exam.FacebookPhoto.model;

/**
 * 
 * prima di una serie di classi che ha lo scopo di modellare il JSON per rendere
 * i dati maneggiabili
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 */

public class Metadata {
	public Photos photos;
	public String id;

	public Photos getPhotosObject() {
		return photos;
	}

	public void setPhotosObject(Photos photosObject) {
		photos = photosObject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

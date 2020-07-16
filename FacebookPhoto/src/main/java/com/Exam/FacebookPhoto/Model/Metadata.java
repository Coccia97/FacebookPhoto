package com.Exam.FacebookPhoto.Model;

/**
 * 
 * prima di una serie di classi che ha lo scopo di modellare il JSON per rendere
 * i dati maneggiabili
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param photos indica una sottoparte del JSON contenete l'array con le foto
 * @param id     indica l'id del nostro account facebook
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

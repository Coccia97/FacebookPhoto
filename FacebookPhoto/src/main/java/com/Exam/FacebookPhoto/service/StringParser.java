package com.Exam.FacebookPhoto.service;

import com.Exam.FacebookPhoto.model.Metadata;
import com.google.gson.Gson;

/**
 * 
 * Classe con lo scompo di prendere la stringa ottenuto da DownloadFromURL e modellarla attaverso le classi presenti nel model
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class StringParser {
	/**
	 * 
	 * @param data JSON convertito in formato String da DownloadFromURL
	 * @return metadata che modella la stringa JSON
	 */

	public static Metadata StringToPhotos(String data) {

		Gson gson = new Gson();
		Metadata metadata = gson.fromJson(data, Metadata.class);
		return metadata;

	}
}

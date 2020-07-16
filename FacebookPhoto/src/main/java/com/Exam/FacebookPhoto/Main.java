package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Il programma inizia con il download del JSONJ tramite url e l'avvio dell'applicazione Spring 
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * @param url richiesta fatta a facebook per ottenere dati sulle foto
 *
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAKufcD2W9iU6eDrIPGMTdvg20uIcSBossA8ZBgKGnACWbD0ShE1ZBQIPN5iJrgJRQLxJMRApAPwM5NBR6SpPEmIZCiXEszd4ZBd9PUjYDdfzOs7AoU8cBudMC8yaW9vFKdcr0Oj2waTsgky5JbcQ7fgZBZBxqckBUfSqQukNvlkB1IR2Wnfw6pDJWdLNHMel4s2J2sHEKOUX0DjkAkIHZAhzubwxuvILwZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}
}

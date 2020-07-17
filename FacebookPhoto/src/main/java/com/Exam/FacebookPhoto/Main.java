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
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAAIbSf8Y2EhAr7x9csWq5k4OXwsu2E5X2b010vZCXrrgvZAinBPEKDdcD8qsf06LHuYBXHAkPBI6Uo5EQqAAM6iVwevrRDClZBEWPYTZA2P6GEuXz9o2bHzAzvZCsqv8ZB00PFLL6r5oVZCGU7hveuy8i3iWCKUhhZB5NYhaZAXBJ4mfMbYBPnhwXQHe0HVXws8CwcWHETAUJtJZCzYrTBZBHOIi8kBf19zhgZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}
}

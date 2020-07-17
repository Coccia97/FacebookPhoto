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
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAGTx5xwoSBiMfUopUAfwm57PSKyqBX8SISfHYH1a9lShu3jZBk4qdRQW5AuthcGRUtPVFGWq3gvBZAm6tMbLgmyUcwc3Jq857NYLxRUMIxDmzVmOtpPtY4l1F64rtdfwZCmA0HU94bXehDXZCvpPSDMCZAsD6g3f16VouE2HVZAnxUf0cwbXSJJ9tqqMviGZCIX5wFKJ74Wr1D4sHInVLLzZBKLf7pxpjQZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}
}

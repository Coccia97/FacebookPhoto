package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAC1VzgtIY7woxTzFNleTiU4hYirkX6qlDu5ZBFZCfuUFRC83xTh8Js0npBIFSqIPZCW4ccGmrlcNMgzxPaqhObsZCTZBIqJ6GEAagHurTZCLyJJ7ZBJ0qca4jjHjL24EXLPfacuMwdHSnqXLeIvHRBSAQU9pJQbZCzffll1746LTdKrqOjs5Clp0yly6fFtZAXNeixrX2oObCotlrtvd5YaGFPSDxykKYDwZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);
		System.out.println(" ");
	}

}

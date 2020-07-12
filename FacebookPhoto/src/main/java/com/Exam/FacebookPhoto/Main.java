package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/3120253634680310?fields=photos&access_token=EAAH51tUzLoUBAPfYMWFniR6JXjXZAd0ljtVbe78AtJJFhn1hFrLcm5R33q8pMwbH8OVo3qR3ORlNsz0t0nlA84ZAjBbvfOL0U6ZBGqrBQxx1sf3BZA3BMd4r77pc3Auy9eTfCvLAmoZAX3X021K9qG8Qbq4QlMJaYlerek9misXZBgNQ87aZAzb7n1oOrlYWXYkIdIdd1ijOWDXqOE0yVEtWTvvvlZBRz4Voj23O5UEtPgZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}

}

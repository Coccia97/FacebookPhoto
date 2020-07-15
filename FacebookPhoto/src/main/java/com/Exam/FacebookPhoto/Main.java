package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/2531425577076284?fields=photos&access_token=EAAIlMonHq4wBAMfWXHeyHjz4TSZCZBg9KVUgbZArmETSipkxkQttOG6Nev5gxQBZAJGh20TcLUUvLQFLMZBU4eZAzWkuWu7jsQlgWPoCtkwvNjEAeIDhZAIPJSx27TFgs4SACoUpZBek5LuCH8YZBhvzHEzEXv1Miv4TEsjbkemXGmUW3IbOLX3f7RZA8fQRYSQUoIxsBWdFzD5ecqApGecBVKEqnJdmVOrUkDLamnJy0KKAZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}
}

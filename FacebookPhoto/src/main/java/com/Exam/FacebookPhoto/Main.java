package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/2531425577076284?fields=photos&access_token=EAAIlMonHq4wBADGi5O0qoKKZAIS7GEqNOUAZCg5hWeXwHoBlykDO0mIB8O1neCiZClExtFFMurfTroWXN6oPdeLd1zdpVV5DPDRJGdeF7TZB8LovX3SjzgTDxUDlFXHlAoA12Vxzej0sDgOpmYDHBPH49nhZCLy4Ak3bGQ9K1TGhcy4ZBoviPTnDE651r0wJxbrrJo2meZBTqRfeZCm1hZBMJ5UkSlEFTGgZB1nSkFmciI3QZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}
}

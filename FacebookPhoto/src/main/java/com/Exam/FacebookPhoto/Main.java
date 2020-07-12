package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.Model.Metadata;
import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAIlMonHq4wBAJgmPVtOeEt3qvxTyulDNHqWAxOaFcLjaUomDZA442w0BGZBFjMb3EYelpTjEy1HD3djYKe4La1ag6RjvYfcgsI2ZBGEzXFBmLnWiD9mVSiMjTUbOlZBleOVpv0j5BIXnZAXug74xihQ3XxZAaNQZA6eZAZCpvCLreY20NN06zqydWNvTGZAwIjhAIwlamDbGxFyWW6TvSHnpBnfFPcjx2NMIIZAsybxQJfNgZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);
		ArrayList<PhotoData> s = StringParser.DataConverter();
		System.out.println(" ");
		

		//SpringApplication.run(Main.class, args);

	}

}

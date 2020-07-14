package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.service.DownloadFromURL;
import com.Exam.FacebookPhoto.service.StringParser;
import com.Exam.FacebookPhoto.util.Stats.Stats;
import com.Exam.FacebookPhoto.Model.PhotoData;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAC5vZBSAcBmNW4cApSm7JSlewYfZCBr4gQR4BbqSTgeWmYZCuoNNNZCZCndZADQstqdZCZBxr4nljxbCwW7wAeflnLQ6nuJOPTLLddrwCP4SV6M1MsBhj5wfnFBNW3ea2jsZBp9YfnvLRW4rEMhjQnGXQdSrI6ahCpzNGm4LXpvGKPUaZCfZAt3JLqBmCHDdZBH4zc3otL3LKsTZCUH4ggTQZCtQuvzET7hnkW6AZDZD";
		DownloadFromURL json = new DownloadFromURL();
		String test1 = json.JsonToString(url);
		StringParser.StringToPhotos(test1);

		SpringApplication.run(Main.class, args);

	}
}

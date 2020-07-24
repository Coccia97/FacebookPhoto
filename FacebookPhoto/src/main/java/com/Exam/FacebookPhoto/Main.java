package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.database.Database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * Il programma inizia con il download del JSONJ tramite url e l'avvio dell'applicazione Spring 
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAAe0nATma9gI0evkhPZAI9sFe1jgm36MKphBqz0ktOBp1wWbXfURg8DXI2YZBSPHC3q8IaHNcaD5z1KHW8EWq5nWRWZBNzvlVSyrQGcZCoKjLwZAmLmF4GshzoZBoxFJrz1ShZACmuqLS3uhcAZCF9yJA28IBykj4rwA97Go3ZAYEwmJus8aorXFCEfZC3kGegdBoB3Y3fownBDxWiOZAeG8b4lZBmCEMIFIogZDZD";
		Database.JsonToMetadata(url);
		SpringApplication.run(Main.class, args);

	}
}

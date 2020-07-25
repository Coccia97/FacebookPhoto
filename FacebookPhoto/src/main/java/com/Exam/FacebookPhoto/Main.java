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
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBAMQpwOPla8JAuSJOUFfZB8LrraBcIvRKCnPW1nbn5AiPInfHVSTZBRbVVKVben5f2WK64IZANlBWysY9UMOkyz9d6mgkN4w87hvonA6jty4ZBqiu3a6q2uu5ZBogFb0PZAHSoT8obnrolBssShR6kwerqZBMD5gSBMC0YVyrtF2DRvNKZCFJku3IRG5hGvKSUNHgNZAJY6uPTaXINIr4XvebriQlGnq1BngZDZD";
		Database.JsonToMetadata(url);
		SpringApplication.run(Main.class, args);

	}
}

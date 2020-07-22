package com.Exam.FacebookPhoto;

import com.Exam.FacebookPhoto.Database.Database;

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
		String url = "https://graph.facebook.com/v7.0/me?fields=photos&access_token=EAAH51tUzLoUBABW4cGLPckuxok3Ui7DrpiDyrg7awnUmsWEZAR3jFbq5JBGPLwPsWQVz567T1Dx8x9aLvucq7m4ubuurHsWkSyYuI0wHHUlClqYd9KhFwVYh0Avy3RPvu4jF1r98T05dJB5WS9U3peZAL2Kr4ny0BlCl56o3W4ZAN3o45PT5HeJnoID9XMUZBJOJR6rTSMZA2T9FKmFAjt8xHOatq6yVYtfs6nayK3dUCL7eQOMmQ";
		Database.JsonToMetadata(url);
		SpringApplication.run(Main.class, args);

	}
}

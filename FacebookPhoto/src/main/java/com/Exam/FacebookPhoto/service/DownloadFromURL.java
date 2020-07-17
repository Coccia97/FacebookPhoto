package com.Exam.FacebookPhoto.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
/**
 * classe con lo scopo di prendere in input l'url da cui prendere i dati e scrivere il suo contenuto su si una stringa 
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param data stringa su cui scrivo il file JSON
 * 
 */
public class DownloadFromURL {
	public String data = "";
	/**
	 * 
	 * @param url link per scaricare i dati
	 * @return stringa contenente il JSON in forma di stringa 
	 */

	public String JsonToString(String url) {

		try {

			URLConnection openConnection = new URL(url).openConnection();
			InputStream in = openConnection.getInputStream();

			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line;
				}
			} finally {
				in.close();
			}
			// System.out.println(data);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(data);
		return data;
	}
}

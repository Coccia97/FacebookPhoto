package com.Exam.FacebookPhoto.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFromURL {
	public String data = "";

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

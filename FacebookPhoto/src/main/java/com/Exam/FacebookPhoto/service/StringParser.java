package com.Exam.FacebookPhoto.service;

import com.google.gson.Gson;

import com.Exam.FacebookPhoto.Model.Metadata;

//classe  utile per adattare la Stringa ottenuta dal JSON all'oggetto photos 

public class StringParser {

public static Metadata StringToPhotos(String data) {
	
	Gson gson = new Gson();
	Metadata metadata = gson.fromJson(data, Metadata.class);
	
	return metadata;
}
	
	
	
	
}

package com.Exam.FacebookPhoto.service;

import com.google.gson.Gson;

import com.Exam.FacebookPhoto.Model.Metadata;

import java.util.ArrayList;

import com.Exam.FacebookPhoto.Model.Data;

//classe  utile per adattare la Stringa ottenuta dal JSON all'oggetto photos 

public class StringParser {

	private static Metadata metadata = new Metadata();

	public static Metadata StringToPhotos(String data) {

		Gson gson = new Gson();
		metadata = gson.fromJson(data, Metadata.class);
		return metadata;

	}

	public static ArrayList<Data> getArrayData() {

		return metadata.photos.data;
	}

}

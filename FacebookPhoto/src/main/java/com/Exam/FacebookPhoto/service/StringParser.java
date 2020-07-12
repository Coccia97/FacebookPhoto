package com.Exam.FacebookPhoto.service;

import com.google.gson.Gson;

import com.Exam.FacebookPhoto.Model.Metadata;
import com.Exam.FacebookPhoto.Model.PhotoData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.Exam.FacebookPhoto.Model.Data;

//classe  utile per adattare la Stringa ottenuta dal JSON all'oggetto photos 

public class StringParser {

	private static Metadata metadata = new Metadata();
	private static ArrayList<PhotoData> photodata = new ArrayList<PhotoData>();

	public static Metadata StringToPhotos(String data) {

		Gson gson = new Gson();
		metadata = gson.fromJson(data, Metadata.class);
		return metadata;

	}

	public static ArrayList<PhotoData> DataConverter() {

		for (int i = 0; i < metadata.photos.data.size(); i++) {

			metadata.photos.data.get(i).getCreated_time();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
			Date resultDate = null;
			{
				try {
					resultDate = df.parse(metadata.photos.data.get(i).getCreated_time()); // created_time
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			Calendar c = Calendar.getInstance();
			c.setTime(resultDate);
			PhotoData pd = new PhotoData(c.get(Calendar.DATE), new SimpleDateFormat("MMM").format(c.getTime()),
					c.get(Calendar.YEAR), new SimpleDateFormat("MMM").format(c.getTime()),
					metadata.photos.data.get(i).getId());

			photodata.add(pd);

			// photodata.get(i).setMonth(new SimpleDateFormat("MMM").format(c.getTime()));
			// photodata.get(i).setYear(c.get(Calendar.YEAR));
			// photodata.get(i).setId(metadata.photos.data.get(i).getId());
			// System.out.println(new SimpleDateFormat("MMM").format(c.getTime()));

		}
		return photodata;
	}

	public static ArrayList<Data> getArrayData() {

		return metadata.photos.data;
	}

}

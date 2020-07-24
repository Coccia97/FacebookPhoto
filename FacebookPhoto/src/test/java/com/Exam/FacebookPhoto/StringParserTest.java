package com.Exam.FacebookPhoto;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.Exam.FacebookPhoto.model.Metadata;
import com.Exam.FacebookPhoto.model.PhotoData;
import com.Exam.FacebookPhoto.service.StringParser;

import org.junit.jupiter.api.Assertions;

public class StringParserTest {
	Metadata metadata= new Metadata();

	private String data= "{\r\n" + 
			"   \"photos\": {\r\n" + 
			"      \"data\": [\r\n" + 
			"         {\r\n" + 
			"            \"created_time\": \"2018-11-28T23:00:16+0000\",\r\n" + 
			"            \"id\": \"2091266917588916\"\r\n" + 
			"         },\r\n" + 
			"         {\r\n" + 
			"            \"created_time\": \"2014-09-30T14:30:06+0000\",\r\n" + 
			"            \"id\": \"667067780074805\"\r\n" + 
			"         },\r\n" + 
			"         {\r\n" + 
			"            \"created_time\": \"2014-09-30T14:30:04+0000\",\r\n" + 
			"            \"id\": \"667067743408142\"\r\n" + 
			"         }\r\n" + 
			"      ],\r\n" + 
			"      \"paging\": {\r\n" + 
			"         \"cursors\": {\r\n" + 
			"            \"before\": \"QVFIUjFzdGZAtZAlpaYnFvbDl3aGJuMGJKU2RZAQVNIMzNPRWp4RGFrLWUxS0g2Um1FSlhKSm4tQUdManRWejBMVGlCVkxEUm9sQW1jYUprQ1hUY1BvRTY0SkZAB\",\r\n" + 
			"            \"after\": \"QVFIUlE2elFvVXcxTFlMWHRjSjd6MDN5YmF4UU44cVJzME05eTlhVHFuMG9sRDVSV2c1cXB1ak12Q3J3WWliS096V1BNY2dlVFNvSFpBTUN4R1VkR1dmWXl3\"\r\n" + 
			"         }\r\n" + 
			"      }\r\n" + 
			"   },\r\n" + 
			"   \"id\": \"3120253634680310\"\r\n" + 
			"}";

	@Before
	public void setUp() throws Exception {
		metadata =  StringParser.StringToPhotos(data);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals("3120253634680310", metadata.getId());
		assertEquals("2018-11-28T23:00:16+0000", metadata.getPhotosObject().data.get(0).getCreated_time());
		assertEquals("2091266917588916", metadata.getPhotosObject().data.get(0).getId());
		assertEquals("QVFIUlE2elFvVXcxTFlMWHRjSjd6MDN5YmF4UU44cVJzME05eTlhVHFuMG9sRDVSV2c1cXB1ak12Q3J3WWliS096V1BNY2dlVFNvSFpBTUN4R1VkR1dmWXl3", metadata.getPhotosObject().getpaging().getCursorsObject().getAfter());
	
		
	}

}

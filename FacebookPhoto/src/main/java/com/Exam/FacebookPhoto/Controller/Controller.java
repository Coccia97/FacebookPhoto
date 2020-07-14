package com.Exam.FacebookPhoto.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Exam.FacebookPhoto.service.StringParser;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Controller {
	/*
	 * Risponde alla richiesta GET /allphoto
	 * 
	 * 
	 */
	@RequestMapping(value = "allphoto", method = RequestMethod.GET)
	public ArrayList<String> getallphoto() {

		return StringParser.getPhotoDataString(StringParser.DataConverter());
	}
	/*
	 * Risponde alla richiesta GET /photostats
	 * 
	 * 
	 */

	@RequestMapping(value = "photostats", method = RequestMethod.GET)
	public ArrayList<String> getphotostats() {

		return StringParser.getStats(StringParser.DataConverter());
	}

}

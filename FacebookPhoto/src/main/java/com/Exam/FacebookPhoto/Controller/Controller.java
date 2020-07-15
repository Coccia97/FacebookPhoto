package com.Exam.FacebookPhoto.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.service.JSONParser;
import com.Exam.FacebookPhoto.service.StringParser;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "allphoto", method=RequestMethod.POST)

	public ArrayList<String> getDataWithPost(@RequestBody Object filter)
	throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

				
				return StringParser.getPhotoDataString(JSONParser.jsonParserColumn(filter));
	}
	@RequestMapping(value = "photostats", method=RequestMethod.POST)

	public ArrayList<String> getStatsWithPost(@RequestBody Object filter)
	throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

				
				return StringParser.getStats(JSONParser.jsonParserColumn(filter));
	}
}

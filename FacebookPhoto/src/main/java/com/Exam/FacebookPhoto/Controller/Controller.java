package com.Exam.FacebookPhoto.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Exam.FacebookPhoto.Model.Data;
import com.Exam.FacebookPhoto.service.StringParser;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Controller {
	  /*
	   * Risponde alla richiesta GET /allphoto
	   * 
	   * 
			*/
	@RequestMapping(value = "allphoto", method=RequestMethod.GET)
	public ArrayList<String> getallphoto(){
		
		return StringParser.getPhotoDataString(StringParser.DataConverter());
	}
			
	
	}
	




package com.Exam.FacebookPhoto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	public static ArrayList<PhotoData> jsonParserColumn(Object filter) 
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException{
				
				ArrayList<PhotoData> previousArray = new ArrayList<PhotoData>();
				ArrayList<PhotoData> filteredArray = new ArrayList<PhotoData>();
				HashMap<String, Object> result = new ObjectMapper().convertValue(filter, HashMap.class);
				
				for(Map.Entry<String, Object> entry : result.entrySet()) {
					
					
					previousArray = new ArrayList<PhotoData>();
				    String column = entry.getKey();
				    Object filterParam = entry.getValue();
				    try {
						filteredArray = jsonParserOperator(column, filterParam, previousArray);
					} catch (  SecurityException e) {

						throw new InternalGeneralException("Error in parsing I/O operation");
						
					} 
				    
				    previousArray = new ArrayList<PhotoData>();
				    previousArray.addAll(filteredArray);
				}
				return filteredArray;		
			}
	
	
	public static ArrayList<PhotoData> jsonParserOperator(String column, 
			   										   Object filterParam, 
			   										   ArrayList<PhotoData> previousArray) 
		   throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

					String type="";
					Filter filter;
					ArrayList<PhotoData> photoData = new ArrayList<PhotoData>();
					HashMap<String, Object> result = new ObjectMapper().convertValue(filterParam, HashMap.class);

					for(Map.Entry<String, Object> entry : result.entrySet()) {

						String operator = entry.getKey();
						Object value = entry.getValue();
					
						if(operator.equals("type") || operator.equals("Type")) {
							type = (String) value;
							if(!(value.equals("and")) && !(value.equals("or"))) {
								throw new FilterIllegalArgumentException("'and' o 'or' expected after 'type'");
							}
							continue;
						}

						filter = FilterService.instanceFilter(column, operator, value);
						switch(type) {

						case "and":
							photoData = FilterService.runFilterAND(filter, previousArray);
							System.out.println("and");
							break;
						case "or":
							photoData = FilterService.runFilterOR(filter, previousArray);
							System.out.println("or");
							break;
						default:
							photoData = FilterService.runFilterOR(filter, previousArray);	
							System.out.println("default");
						}
					}
					return photoData;	
	}

}

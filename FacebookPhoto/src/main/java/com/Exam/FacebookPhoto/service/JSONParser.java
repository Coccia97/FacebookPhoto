package com.Exam.FacebookPhoto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.Exam.FacebookPhoto.exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	/**
	 * Effettua il parsing relativo all'elemento "name" e al filtro da applicare
	 * @param filter JSON con le relative informazioni riguardo il filtro
	 * @return ArrayList PhotoData filtrato
	 * @throws InternalGeneralException errori generali interni
	 * @throws FilterNotFoundException il filtro non è stato trovato
	 * @throws FilterIllegalArgumentException parametro del filtro non valido
	 */
	
	public static ArrayList<PhotoData> jsonParserName(Object filter) 
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException{
				
				ArrayList<PhotoData> prevArray = new ArrayList<PhotoData>();
				ArrayList<PhotoData> filterArray = new ArrayList<PhotoData>();
				
				HashMap<String, Object> result = new ObjectMapper().convertValue(filter, HashMap.class);
				
				for(Map.Entry<String, Object> entry : result.entrySet()) {
					
					
					prevArray = new ArrayList<PhotoData>();
				    String name = entry.getKey();
				    Object filterParam = entry.getValue();
				    try {
						
				    	filterArray = jsonParserOperator(name, filterParam, prevArray);
					} catch (  SecurityException e) {

						throw new InternalGeneralException("Invalid I/O operation");
						
					} 
				    
				    prevArray = new ArrayList<PhotoData>();
				    prevArray.addAll(filterArray);
				}
				return filterArray;		
			}
	
		/**
		 * Effettua il parsing relativo all'elemento "operator" e al filtro da applicare
		 * @param name campo su cui si effettua il filtraggio
		 * @param filterParam parametro relativo al filtraggio
		 * @param filteredArray ArrayList PhotoData relativo ai filtraggi già eseguiti
		 * @return ArrayList PhotoData filtrato
		 * @throws InternalGeneralException  errori generali interni
		 * @throws FilterNotFoundException il filtro non è stato trovato
		 * @throws FilterIllegalArgumentException parametro del filtro non valido
		 */
	public static ArrayList<PhotoData> jsonParserOperator(String name, Object filterParam, ArrayList<PhotoData> filteredArray) 
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

					String type="";
					Filter filter;
					ArrayList<PhotoData> photoData = new ArrayList<PhotoData>();
					HashMap<String, Object> result = new ObjectMapper().convertValue(filterParam, HashMap.class);

					for(Map.Entry<String, Object> entry : result.entrySet()) {

						String operator = entry.getKey();
						Object value = entry.getValue();
						
						if(operator.equals("type")) {
							
							type = (String) value;
							
							if(!(value.equals("and")) && !(value.equals("or"))) {
								throw new FilterIllegalArgumentException("insert 'and' or 'or' after 'type'");
							}
							continue;
						}

						filter = FilterService.instanceFilter(name, operator, value);
						
						switch(type) {

						case "and":
							photoData = FilterService.runMultipleFilterAnd(filter, filteredArray);
							break;
						case "or":
							photoData = FilterService.runMultipleFilterOr(filter, filteredArray);
							break;
						default:
							photoData = FilterService.runSingleFilter(filter, filteredArray);	

						}
					}
					
					return photoData;	
	}

}

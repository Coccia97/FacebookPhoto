package com.Exam.FacebookPhoto.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class FilterService {
	
	private final static String path = "com.Exam.FacebookPhoto.util.filter.";
	
	private static ArrayList<PhotoData> photos = StringParser.DataConverter();
	
	
	//istanzia un oggetto Filter con i parametri di filtraggio inseriti da Postman
	
	public static Filter instanceFilter(String column,String operator,Object param) 
			   throws FilterNotFoundException, FilterIllegalArgumentException,InternalGeneralException{
			
			Filter filtro;
			String filterName = new String("Filter"+column+operator);
			String ClassFilterName = path.concat(filterName);
		    
			try {
				
				Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
			
				Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
		    
				filtro =(Filter)ct.newInstance(param);  //istanzo oggetto filtro
				
			}
			
		    //entra qui se il nome filtro non è corretto 
		    catch(ClassNotFoundException e){
		    	throw new FilterNotFoundException("The filter in field: '"+column+"' with operator: '"+
		                                          operator +"' does not exist");
		    }
			
			//entra qui se sbagliate maiuscole e minuscole
		    catch(NoClassDefFoundError e){
		    	throw new FilterNotFoundException(
		    			"Error typing: '"+filterName+"' uppercase and lowercase error");
		    }

		    //entra qui se il costruttore chiamato da newInstance lancia un eccezione 
		   	catch (InvocationTargetException e) {  
		   		//genero una nuova eccezione 
		   		throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
		   				+ " Expected in '"+column+"'");
		   	}

		    catch(LinkageError | NoSuchMethodException | SecurityException 
			    	   | InstantiationException | IllegalAccessException e ) {
			    	
			    	e.printStackTrace();
			    	throw new InternalGeneralException("try later");
			    }

			
		    return filtro;
		    
		}
	
	
	//inizializza array filtrato
	public static ArrayList<PhotoData> runFilterAND(Filter filtro, ArrayList<PhotoData> previousArray){

		ArrayList<PhotoData> filterArray = new ArrayList<PhotoData>();
		
		for(PhotoData photodata : previousArray) {

			if(filtro.filter(photodata))
				filterArray.add(photodata);
		}				
		
		return filterArray;
	}
	
	
	public static ArrayList<PhotoData> runFilterOR(Filter filtro, ArrayList<PhotoData> previousArray){

		ArrayList<PhotoData> filterArray = new ArrayList<PhotoData>();
		
		for(PhotoData photodata : photos) {

			if(filtro.filter(photodata))
				filterArray.add(photodata);
		}	
		
		//previousArray.removeAll(filterArray);
		previousArray.addAll(filterArray);
		return previousArray;
	}
	
}
	


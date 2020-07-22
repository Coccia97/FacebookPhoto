package com.Exam.FacebookPhoto.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.Exam.FacebookPhoto.Database.Database;
import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;

/**
 * Classe che gestisce i filtraggi dei dati a disposizione
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class FilterService {
		
		private static ArrayList<PhotoData> photos = Database.DataConverter();
		
		private final static String path = "com.Exam.FacebookPhoto.util.filter.";  //package dei filtri
		
		/**
		 * Istanzia un oggetto Filter prendendo come modello uno dei filtri presenti
		 * nel package com.Exam.FacebookPhoto.util.filter. e utilizzando i parametri
		 * inseriti tramite Postman
		 * @param name campo corrispondente al nome del valore da filtrare (ex: Day o Month)
		 * @param oper campo corrispondente a uno dei quattro operatori disponibili (ex: Follow)
		 * @param parameter campo corrispondente al valore del parametro inserito in ingresso
		 * @return l'oggetto Filter
		 * @throws InternalGeneralException errore generico
		 * @throws FilterIllegalArgumentException il parametro inserito non è compatibile col filtro
		 * @throws FilterNotFoundException il filtro non è presente nel package Filter
		 */
		
		
		public static Filter instanceFilter(String name, String oper, Object parameter)
			throws InternalGeneralException, FilterIllegalArgumentException, FilterNotFoundException {
			
			Filter filtro = null;
			String NameFilter = new String("Filter"+name+oper);
			String ClassNameFilter = path.concat(NameFilter);
			
			
			Class<?> clss = null;
			
			try {
				clss = Class.forName(ClassNameFilter);  //selezione della classe
			} 
			catch (ClassNotFoundException e) {  //il nome del filtro non è valido
				
				throw new FilterNotFoundException("The filter in field: "+name+" with operator: "+
                        oper +" doesn't exist");
			}
			
			Constructor<?> cstr = null;
			
			try {
				cstr = clss.getDeclaredConstructor(Object.class);  //selezione del costruttore
			} 
			catch (NoSuchMethodException | SecurityException e) {  //
				e.printStackTrace();
		    	
				throw new InternalGeneralException("common error");
			}
			
			try {
				filtro =(Filter)cstr.newInstance(parameter);  //oggetto filtro
			} 
			catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
				
				throw new InternalGeneralException("common error");
			} 
			catch (InvocationTargetException e) {
				
				throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
		   				+ " Expected in "+name);
			}
			
			return filtro;
		}	
			
			/**
			 * Metodo che scorre l'ArrayList PhotoData e restituisce un ArrayLIst formato da
			 * elementi risultati positivi ad un singolo filtraggio
			 * @param filtro selezionato
			 * @param filteredArray ArrayList PhotoData su cui eseguire il filtraggio
			 * @return ArrayList con i soli elementi filtrati
			 */
		
		public static ArrayList<PhotoData> runSingleFilter(Filter filtro, ArrayList<PhotoData> filteredArray) {
			
			ArrayList<PhotoData> ArrayFilter = new ArrayList<PhotoData>();
			
			for (PhotoData photodata : photos) {  //filtra l'ArrayList PhotoData, non filtrato
				
				if (filtro.filter(photodata))
				ArrayFilter.add(photodata);
			}
			
			filteredArray.addAll(ArrayFilter);
			return filteredArray;  //ArrayList che eventualmente verrà utilizzato dall'operatore AND
		}
		
		/**
		 * Metodo che scorre l'ArrayList PhotoData e restituisce un ArrayList formato da 
		 * elementi risultati positivi ad almeno uno dei filtraggi, seguendo l'operatore OR
		 * @param filtro selezionato
		 * @param filteredArray ArrayList PhotoData su cui eseguire il filtraggio
		 * @return ArrayList con i soli elementi filtrati
		 */
		public static ArrayList<PhotoData> runMultipleFilterOr(Filter filtro, ArrayList<PhotoData> filteredArray) {
			
			ArrayList<PhotoData> ArrayFilter = new ArrayList<PhotoData>();
			
			for (PhotoData photodata : photos) {  //filtra l'ArrayList PhotoData, non filtrato
				
				if (filtro.filter(photodata))
				ArrayFilter.add(photodata);
			}
			
			filteredArray.addAll(ArrayFilter);
			return filteredArray;  //ArrayList che eventualmente verrà utilizzato dall'operatore AND
				
		}
		
		/**
		 * Metodo che scorre l'ArrayList PhotoData e restituisce un ArrayList formato da
		 * elementi risultati positivi a tutti i filtraggi inseriti, seguendo l'operatore AND
		 * @param filtro selezionato
		 * @param filteredArray ArrayList PhotoData su cui eseguire il filtraggio
		 * @return ArrayList con i soli elementi filtrati
		 */
		public static ArrayList<PhotoData> runMultipleFilterAnd(Filter filtro, ArrayList<PhotoData> filteredArray) {
			
			ArrayList<PhotoData> ArrayFilter = new ArrayList<PhotoData>();
			
			for (PhotoData photodata : filteredArray) {  //filtra l'ArrayList già filtrato in precedenza
				
				if (filtro.filter(photodata))
				ArrayFilter.add(photodata);
			}
			return ArrayFilter;
		}
		
}
package com.Exam.FacebookPhoto.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.Exam.FacebookPhoto.database.Database;
import com.Exam.FacebookPhoto.exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;

/**
 * Classe che gestisce i filtraggi dei dati a disposizione
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class FilterService {
		
		private static ArrayList<PhotoData> photos = Database.DataConverter();
		
		/**
		 * Istanzia un oggetto Filter prendendo come modello uno dei filtri presenti
		 * nel package com.Exam.FacebookPhoto.util.filter. e utilizzando i parametri
		 * inseriti tramite Postman
		 * @param T tipo classe generico
		 * @param name campo corrispondente al nome del valore da filtrare (ex: Day o Month)
		 * @param oper campo corrispondente a uno dei quattro operatori disponibili (ex: Follow)
		 * @param parameter campo corrispondente al valore del parametro inserito in ingresso
		 * @return l'oggetto Filter
		 * @throws InternalGeneralException errore generico
		 * @throws FilterIllegalArgumentException il parametro inserito non è compatibile col filtro
		 * @throws FilterNotFoundException il filtro non è presente nel package Filter
		 */
		
		
		public static <T> Filter instanceFilter(String name, String oper, Object parameter)
			throws InternalGeneralException, FilterIllegalArgumentException, FilterNotFoundException {
			
			Filter filter = null;
			Class<T> clss = null;
			
			try {
				clss = (Class<T>) Class.forName("com.Exam.FacebookPhoto.util.filter.Filter" + name + oper);  //selezione della classe
			} 
			catch (ClassNotFoundException e) {  //il nome del filtro non è valido
				
				throw new FilterNotFoundException("The filter in field: "+name+" with operator: "+
                        oper +" doesn't exist");
			}
			
			Constructor<T> cstr = null;
			
			try {
				cstr = clss.getDeclaredConstructor(Object.class);  //selezione del costruttore
			} 
			catch (NoSuchMethodException | SecurityException e) {  
				e.printStackTrace();
		    	
				throw new InternalGeneralException("Common error");
			}
			
			try {
				filter =(Filter)cstr.newInstance(parameter);  //oggetto filtro
			} 
			catch (IllegalArgumentException | IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
				
				throw new InternalGeneralException("Common error");
			} 
			catch (InvocationTargetException e) {
				
				throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
		   				+ " Expected in " + name);
			}
			
			return filter;
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
			
			for (PhotoData photodata : photos) {  //filtra l'ArrayList PhotoData
				
					if (filtro.filter(photodata))
						ArrayFilter.add(photodata);
			}
			
			return ArrayFilter;  //ArrayList che eventualmente verrà utilizzato dall'operatore AND
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
			
			for (PhotoData photodata : photos) {  //filtra l'ArrayList PhotoData
				
					if (filtro.filter(photodata))
						ArrayFilter.add(photodata);
			}
			
			return ArrayFilter;  //ArrayList che eventualmente verrà utilizzato dall'operatore AND
}
		
		/**
		 * Metodo che scorre l'ArrayList ArrayFIlter e restituisce un ArrayList formato da
		 * elementi risultati positivi a tutti i filtraggi inseriti, seguendo l'operatore AND
		 * @param filtro selezionato
		 * @param filteredArray ArrayList PhotoData su cui eseguire il filtraggio
		 * @return ArrayList con i soli elementi filtrati
		 */
		public static ArrayList<PhotoData> runMultipleFilterAnd(Filter filtro, ArrayList<PhotoData> ArrayFilter) {
			
			ArrayList<PhotoData> ArrayAnd = new ArrayList<PhotoData>();
			
			for (PhotoData photodata : ArrayFilter) {  /*A differenza degli altri due filtri, 
				                                              filtra l'ArrayList già filtrato in precedenza*/
					if (filtro.filter(photodata))
						ArrayAnd.add(photodata);
			}
			return ArrayAnd;
		}
}
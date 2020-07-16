package com.Exam.FacebookPhoto.util.varius;

import java.util.ArrayList;

/**
 * Rappresenta la superclasse dei filtri che lavorano con una stringa
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 */

public class FilterString {
		
		protected ArrayList<String> param = new ArrayList<String>();
		
		/**
		 * Costruttore
		 * @param parametroString deve essere un ArrayList String
		 * @throws IllegalArgumentException parametroString non è del tipo richiesto
		 */
		
		
		public FilterString(Object parametroString) {
			
			if(parametroString instanceof ArrayList<?>) {
				
				for(Object ele : (ArrayList<?>)parametroString) {
					
					if(ele instanceof String) {
						param.add((String)ele);
						//System.out.println(parametri.getClass());
					}else {
						throw new IllegalArgumentException("Type: String ");
					}
				}

			}else {			
				throw new IllegalArgumentException("Type: Array ");
			}
		}
		
		/**
		 * Set
		 * @param parametroString deve essere un ArrayList String
		 * @throws IllegalArgumentException parametroString non è del tipo richiesto
		 */

		public void SetParametroStringFiltro(Object parametroString) {
			
			
			if(parametroString instanceof ArrayList<?>) {
				
				for(Object ele : (ArrayList<?>)parametroString) {
					
					if(ele instanceof String) {
						param.add((String)ele);
					}else {
						throw new IllegalArgumentException("Type: String ");
					}
				}

			}else {			
				throw new IllegalArgumentException("Type: Array ");
			}
		}
		
		
	}


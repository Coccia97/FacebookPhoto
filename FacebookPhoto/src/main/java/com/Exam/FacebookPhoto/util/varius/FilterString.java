package com.Exam.FacebookPhoto.util.varius;

import java.util.ArrayList;

public class FilterString {

		protected ArrayList<String> param = new ArrayList<String>();

		
		// Costruttore 
		
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
		
		
		// Set 

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


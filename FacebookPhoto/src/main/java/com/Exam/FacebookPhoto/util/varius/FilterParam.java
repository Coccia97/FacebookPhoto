package com.Exam.FacebookPhoto.util.varius;

/**
 * Rappresenta la superclasse dei filtri che lavorano con un parametro intero
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 */


public class FilterParam {
	
	protected int parametroInt;
	
	/**
	 * Costruttore
	 * @param parametroInt deve essere un intero
	 * @throws IllegalArgumentException il parametro inserito non è del tipo richiesto
	 */
	
	
	public FilterParam(Object parametroInt){  

			
			if(parametroInt instanceof Integer ) { 
				this.parametroInt =(Integer)parametroInt;
			}else {
				throw new IllegalArgumentException("Type: Interger ");
			}
			
		}
	/**
	 * Set
	 * @param parametroInt deve essere un intero
	 * @throws IllegalArgumentException il parametro inserito non è del tipo richiesto
	 */
	public void setParametroInt(Object parametroInt) {   
	
	if(parametroInt instanceof Integer ) { 
		this.parametroInt =(Integer)parametroInt;
	}else {
		throw new IllegalArgumentException("Type: Interger ");
	}
}
	//Set Overloading
	public void setParametroInt(int parametroInt) {   
		this.parametroInt = parametroInt;
	}

	public int getParametroInt() {
		return parametroInt;
	}
	
}


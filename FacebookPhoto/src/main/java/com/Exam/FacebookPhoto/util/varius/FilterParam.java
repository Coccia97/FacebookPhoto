package com.Exam.FacebookPhoto.util.varius;


public class FilterParam {
	
	protected int parametroInt;
	
	
	public FilterParam(Object parametroInt){  //costruttore (controllo numero intero)

			
			if(parametroInt instanceof Integer ) { 
				this.parametroInt =(Integer)parametroInt;
			}else {
				throw new IllegalArgumentException("Type: Interger ");
			}
			
		}

	public void setParametroInt(Object parametroInt) {   //set
	
	if(parametroInt instanceof Integer ) { 
		this.parametroInt =(Integer)parametroInt;
	}else {
		throw new IllegalArgumentException("Type: Interger ");
	}
}
	public void setParametroInt(int parametroInt) {   //set Overloading
		this.parametroInt = parametroInt;
	}

	public int getParametroInt() {
		return parametroInt;
	}
	
}


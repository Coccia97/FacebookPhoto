package com.Exam.FacebookPhoto.util.filter;

import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.Exam.FacebookPhoto.util.varius.FilterParam;

/**
 * Rappresenta la classe che implementa il filtro per il campo Year
 * con l'operatore "corrisponde a..."
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class FilterYearNequal extends FilterParam implements Filter {
	
	public FilterYearNequal(Object parametroInt) {
		super(parametroInt);
	}
	
	public boolean filter(PhotoData photodata) {
		
		if (photodata.getYear() == parametroInt)	{
			return false;
		}
		return true;
			
			
	}
	
	

}
package com.Exam.FacebookPhoto.util.filter;

import com.Exam.FacebookPhoto.model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.Exam.FacebookPhoto.util.varius.FilterParam;

/**
 * Rappresenta la classe che implementa il filtro per il campo Day
 * con l'operatore "corrisponde a..."
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public class FilterDayNequal extends FilterParam implements Filter {
	
	public FilterDayNequal(Object parametroInt) {
		super(parametroInt);
	}
	
	public boolean filter(PhotoData photodata) {
		
		if (photodata.getDay() == parametroInt)	{
			return false;
		}
		return true;
			
			
	}
	
	

}

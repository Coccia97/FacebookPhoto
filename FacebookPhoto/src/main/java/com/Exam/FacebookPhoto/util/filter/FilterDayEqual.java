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

public class FilterDayEqual extends FilterParam implements Filter {
	
	public FilterDayEqual(Object parametroInt) {
		super(parametroInt);
	}
	
	public boolean filter(PhotoData photodata) {
		
		if (photodata.getDay() == parametroInt)	{
			return true;
		}
		return false;
			
			
	}
	
	

}

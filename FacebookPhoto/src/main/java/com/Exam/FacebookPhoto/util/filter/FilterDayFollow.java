package com.Exam.FacebookPhoto.util.filter;

import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.Exam.FacebookPhoto.util.varius.FilterParam;

/**
 * Rappresenta la classe che implementa il filtro per il campo Day
 * con l'operatore "successivi a..."
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class FilterDayFollow extends FilterParam implements Filter {
	
	public FilterDayFollow(Object parametroInt) {
		super(parametroInt);
	}
	
	public boolean filter(PhotoData photodata) {
		
		if (photodata.getDay() >= parametroInt)	{
			return true;
		}
		return false;
			
			
	}
	
	

}
package com.Exam.FacebookPhoto.util.filter;

import com.Exam.FacebookPhoto.model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.Exam.FacebookPhoto.util.varius.FilterString;

/**
 * Rappresenta la classe che implementa il filtro per il campo Dayname
 * con l'operatore "non corrisponde a..."
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class FilterDaynameNequal extends FilterString implements Filter {

	
	public FilterDaynameNequal(Object parametroString) {
		super(parametroString);
		
	}

	public boolean filter(PhotoData photodata) {
		
		for(String p : param) {
			if(photodata.getDayName().equals(p))
				return false;
			}
		return true;
	}
	
	
}

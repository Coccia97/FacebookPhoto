package com.Exam.FacebookPhoto.util.filter;

import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.Exam.FacebookPhoto.util.varius.FilterString;

public class FilterDaynameIn extends FilterString implements Filter {

	
	public FilterDaynameIn(Object parametroString) {
		super(parametroString);
		
	}

	public boolean filter(PhotoData photodata) {
		
		for(String p : param) {
			if(photodata.getDayName().equals(p))
				return true;
			}
		return false;
	}
	
	
}

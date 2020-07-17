package com.Exam.FacebookPhoto.util.filter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.Exam.FacebookPhoto.Model.PhotoData;
import com.Exam.FacebookPhoto.util.varius.Filter;
import com.Exam.FacebookPhoto.util.varius.FilterString;

/**
 * Rappresenta la classe che implementa il filtro per il campo Month
 * con l'operatore "corrisponde a..."
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
public class FilterMonthNequal extends FilterString implements Filter {

	
	public FilterMonthNequal(Object parametroString) {
		super(parametroString);
		
	}

	public boolean filter(PhotoData photodata) {
		
		Date data = null;  //conversione da String a int mediante l'utilizzo della classe Calendar
		Date data2 = null;
		try {
			data = new SimpleDateFormat("MMM", Locale.ITALIAN).parse(photodata.getMonth());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar cal = Calendar.getInstance(); //utilizzo della classe Calendar
	    cal.setTime(data);
	    int month = cal.get(Calendar.MONTH)+1;
	    for(String p : param) {
	    	
	    	try {
				data2 = new SimpleDateFormat("MMM", Locale.ITALIAN).parse(p);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Calendar cal2 = Calendar.getInstance();
		    cal2.setTime(data2);
		    
		    int month2 = cal2.get(Calendar.MONTH)+1;
		    
	    	if ( month == month2) {
	    			return false;
	    	}
	 }
		return true;
}
}
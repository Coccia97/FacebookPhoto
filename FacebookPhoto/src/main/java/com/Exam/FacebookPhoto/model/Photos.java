package com.Exam.FacebookPhoto.model;

import java.util.ArrayList;

/**
 * 
 * una serie di classi che ha lo scopo di modellare il JSON per rendere
 * i dati maneggiabili
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 */

public class Photos {
	public ArrayList<Data> data;
	public Paging paging;
	
	public ArrayList<Data> getData() {
		return data;
	}

	public void setdata(ArrayList<Data> data) {
		this.data = data;
	}

	public Paging getpaging() {
		return paging;
	}

	public void setpaging(Paging paging) {
		this.paging = paging;
	}

}

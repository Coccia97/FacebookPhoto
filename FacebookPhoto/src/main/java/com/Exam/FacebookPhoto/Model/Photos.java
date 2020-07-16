package com.Exam.FacebookPhoto.Model;

import java.util.ArrayList;

/**
 * 
 * una serie di classi che ha lo scopo di modellare il JSON per rendere
 * i dati maneggiabili
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 * 
 * @param data l'array con le foto
 * @param id   sottosezione paging con vari dati contenuti nel json che a noi non serviranno
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

package com.Exam.FacebookPhoto.Model;

import java.util.ArrayList;

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

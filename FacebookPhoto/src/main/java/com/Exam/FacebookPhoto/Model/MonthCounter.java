package com.Exam.FacebookPhoto.Model;

public class MonthCounter {
	private String mese;
	private int counter;

	public MonthCounter(String mese, int counter) {
		super();
		this.mese = mese;
		this.counter = counter;
	}

	public String getMese() {
		return mese;
	}

	public void setMese(String mese) {
		this.mese = mese;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}

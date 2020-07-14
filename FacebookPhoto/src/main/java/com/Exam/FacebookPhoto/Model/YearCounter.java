package com.Exam.FacebookPhoto.Model;

public class YearCounter {
	int Year;
	int Counter;

	public YearCounter(int year, int counter) {
		super();
		this.Year = year;
		this.Counter = counter;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		this.Year = year;
	}

	public int getCounter() {
		return Counter;
	}

	public void setCounter(int counter) {
		this.Counter = counter;
	}

}

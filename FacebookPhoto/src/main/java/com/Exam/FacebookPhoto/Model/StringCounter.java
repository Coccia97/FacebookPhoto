package com.Exam.FacebookPhoto.Model;

public class StringCounter {
	private String string;
	private int counter;

	public StringCounter(String string, int counter) {
		super();
		this.string = string;
		this.counter = counter;
	}

	public String getString() {
		return string;
	}

	public void setMese(String string) {
		this.string = string;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}

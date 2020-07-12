package com.Exam.FacebookPhoto.Model;

public class PhotoData {
	
	private int day;
	private String month;
	private int year;
	private String dayName;
	private String id;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	public PhotoData(int day, String month, int year, String dayName, String id) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		this.dayName = dayName;
		this.id = id;
	}
	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the dayName
	 */
	public String getDayName() {
		return dayName;
	}
	/**
	 * @param dayName the dayName to set
	 */
	public void setDayName(String dayName) {
		this.dayName = dayName;
	}
	
}
	
	
	
	
	
	

package com.Exam.FacebookPhoto.Exceptions;

import org.springframework.http.HttpStatus;

/**
 * Rappresenta la classe degli errori da
 * restituire al client
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public class ErrorFormat {
	
	private final String error;
	private final String details;
	private final HttpStatus http;
	
	public ErrorFormat(String error, String details, HttpStatus http) {
		super();
		
		this.error = error;
		this.details = details;
		this.http = http;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

	/**
	 * @return the errorMessage
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @return the http
	 */
	public HttpStatus getHttp() {
		return http;
	}


	
	


}

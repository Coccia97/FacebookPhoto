package com.Exam.FacebookPhoto.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Rappresenta la classe degli errori da
 * restituire al client
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public class ErrorFormat {
	
	private final String Error;
	private final String Details;
	private final HttpStatus Http;
	
	public ErrorFormat(String Error, String Details, HttpStatus Http) {
		super();
		
		this.Error = Error;
		this.Details = Details;
		this.Http = Http;
	}

	/**
	 * @return the error
	 */
	public String getError() {
		return Error;
	}

	/**
	 * @return the errorMessage
	 */
	public String getDetails() {
		return Details;
	}

	/**
	 * @return the http
	 */
	public HttpStatus getHttp() {
		return Http;
	}


	
	


}

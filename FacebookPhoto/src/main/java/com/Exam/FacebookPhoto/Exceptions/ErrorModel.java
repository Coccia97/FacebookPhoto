package com.Exam.FacebookPhoto.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;

/**
 * Rappresenta la classe i cui oggetti sono gli errori da
 * restituire al client
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public class ErrorModel {
	
	private final HttpStatus httpStatus;
	private final Instant instant;
	private final String errorName;
	private final String message;
	
	public ErrorModel(HttpStatus httpStatus, Instant instant, String errorName, String message) {
		super();
		this.httpStatus = httpStatus;
		this.instant = instant;
		this.errorName = errorName;
		this.message = message;
	}

	/**
	 * @return httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @return instant
	 */
	public Instant getInstant() {
		return instant;
	}

	/**
	 * @return errorName
	 */
	public String getErrorName() {
		return errorName;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
		
	
	
	


}

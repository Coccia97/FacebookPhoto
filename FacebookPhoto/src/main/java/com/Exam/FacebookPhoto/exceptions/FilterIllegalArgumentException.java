package com.Exam.FacebookPhoto.exceptions;

/**
 * Rappresenta un'eccezione personalizzata del tipo IllegalArgumentException
 * @author Andrea Marcheggiani 
 * @author Francesco Columbaro
 *
 */

public class FilterIllegalArgumentException extends IllegalArgumentException{


	private static final long serialVersionUID = 1L;

	public FilterIllegalArgumentException(String message) {
		super(message);
	}
}
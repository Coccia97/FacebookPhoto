package com.Exam.FacebookPhoto.Exceptions;

/**
 * Rappresenta un'eccezione personalizzata del tipo IllegalArgumentException
 * @see <a/ href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/IllegalArgumentException.html">IllegalArgumentException /a>
 * @author Andrea Marcheggiani 
 * @author Francesco Columbaro
 *
 */

public class FilterIllegalArgumentException extends IllegalArgumentException{


	private static final long serialVersionUID = 1L;

	public FilterIllegalArgumentException() {
		super();
	}

	public FilterIllegalArgumentException(String message) {
		super(message);
	}
}
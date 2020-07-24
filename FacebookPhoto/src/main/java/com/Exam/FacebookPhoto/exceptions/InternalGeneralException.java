package com.Exam.FacebookPhoto.exceptions;

/**
 * Rappresenta un'eccezione personalizzata del tipo Exception
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/Exception.html">Exception</a>
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public class InternalGeneralException extends Exception {


	private static final long serialVersionUID = 3L;

	public InternalGeneralException() {
		super();
	}

	public InternalGeneralException(String message) {
		super(message);
	}
}
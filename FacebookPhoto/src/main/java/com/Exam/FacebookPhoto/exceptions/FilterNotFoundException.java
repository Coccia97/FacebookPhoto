package com.Exam.FacebookPhoto.exceptions;

/**
 * Rappresenta un'eccezione personalizzata del tipo ClassNotFoundException
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/ClassNotFoundException.html">ClassNotFoundException</a>
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public class FilterNotFoundException extends ClassNotFoundException{


	private static final long serialVersionUID = 2L;

	public FilterNotFoundException(String message) {
		super(message);
	}

}
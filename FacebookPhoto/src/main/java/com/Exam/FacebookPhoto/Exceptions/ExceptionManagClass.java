package com.Exam.FacebookPhoto.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.Exceptions.ErrorFormat;

/**
 * Rappresenta la classe in cui vengono gestiti gli errori generati da eventuali
 * chiamate errate da parte del client
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */
@ControllerAdvice
public class ExceptionManagClass {
	
	/**
	 * Classe che risponde quando viene lanciato l'errore InternalGeneralException
	 * @param e InternalGeneralException
	 * @return ResponseEntity di Object errorModel
	 */
	
	@ExceptionHandler(value = {InternalGeneralException.class})
 	public ResponseEntity<Object> handleInternalGeneralException(InternalGeneralException e){
		
		ErrorFormat errorFormat = new ErrorFormat(
				
				e.getClass().getCanonicalName(),
				e.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR
				);
		
		return new ResponseEntity<>(errorFormat, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * Classe che risponde quando viene lanciato l'errore FilterIllegalArgumentException
	 * @param e FilterIllegalArgumentException
	 * @return ResponseEntity di Object errorModel
	 */
	
	@ExceptionHandler(value = {FilterIllegalArgumentException.class})
 	public ResponseEntity<Object> handleFilterIllegalArgumentException(FilterIllegalArgumentException e){
		
		ErrorFormat errorFormat = new ErrorFormat(
				
				e.getClass().getCanonicalName(),
				e.getMessage(),
				HttpStatus.BAD_REQUEST
				);
		
		return new ResponseEntity<>(errorFormat, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Classe che risponde quando viene lanciato l'errore FilterNotFoundException
	 * @param e FilterNotFoundException
	 * @return ResponseEntity di Object errorModel
	 */
	
	@ExceptionHandler(value = {FilterNotFoundException.class})
 	public ResponseEntity<Object> handleFilterNotFoundException(FilterNotFoundException e){
		
		ErrorFormat errorFormat = new ErrorFormat(
				
				e.getClass().getCanonicalName(),
				e.getMessage(),
				HttpStatus.BAD_REQUEST
				);
		
		return new ResponseEntity<>(errorFormat, HttpStatus.BAD_REQUEST);
		
	}
	
}

package com.Exam.FacebookPhoto.Exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.Exceptions.ErrorModel;

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
	 * Classe che risponde quando viene lanciato l'errore FilterIllegalArgumentException
	 * @return ResponseEntity di Object errorModel
	 */
	
	@ExceptionHandler( value = {FilterIllegalArgumentException.class})
 	public ResponseEntity<Object> handleFilterIllegalArgumentException(FilterIllegalArgumentException e){
		
		ErrorModel errorModel = new ErrorModel(
					HttpStatus.BAD_REQUEST,
					Instant.now(),
					e.getClass().getCanonicalName(),
					e.getMessage()
					);
		
		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
	}
	/**
	 * Classe che risponde quando viene lanciato l'errore FilterNotFoundException
	 * @return ResponseEntity di Object errorModel
	 */
	
	@ExceptionHandler( value = {FilterNotFoundException.class})
 	public ResponseEntity<Object> handleFilterNotFoundException(FilterNotFoundException e){
		
		ErrorModel errorModel = new ErrorModel(
					HttpStatus.BAD_REQUEST,
					Instant.now(),
					e.getClass().getCanonicalName(),
					e.getMessage()
					);
		return new ResponseEntity<>(errorModel, HttpStatus.BAD_REQUEST);
		
	}
	/**
	 * Classe che risponde quando viene lanciato l'errore InternalGeneralException
	 * @return ResponseEntity di Object errorModel
	 */
	@ExceptionHandler( value = {InternalGeneralException.class})
 	public ResponseEntity<Object> handleInternalGeneralException(InternalGeneralException e){
		
		ErrorModel errorModel = new ErrorModel(
					HttpStatus.INTERNAL_SERVER_ERROR,
					Instant.now(),
					e.getClass().getCanonicalName(),
					e.getMessage()
					);
		return new ResponseEntity<>(errorModel, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

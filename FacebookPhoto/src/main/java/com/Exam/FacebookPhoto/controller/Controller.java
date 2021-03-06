package com.Exam.FacebookPhoto.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Exam.FacebookPhoto.exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.service.JSONParser;
import com.Exam.FacebookPhoto.database.*;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Il programma inizia con il download del JSONJ tramite url e l'avvio
 * dell'applicazione Spring
 * 
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 */


@RestController
public class Controller {
	/**
	 * Risponde alla richiesta GET /allphoto
	 * 
	 * @return un ArrayList di String con tutti i dati relativi alle foto
	 * 
	 */
	@RequestMapping(value = "allphoto", method = RequestMethod.GET)
	public ArrayList<String> getallphoto() {

		return Database.getPhotoDataString(Database.DataConverter());
	}

	/**
	 * Risponde alla richiesta GET /photostats
	 * 
	 * @return un ArrayList di String con tutti i dati relativi alle statistiche delle foto
	 */

	@RequestMapping(value = "photostats", method = RequestMethod.GET)
	public ArrayList<String> getphotostats() {

		return Database.getStats(Database.DataConverter());
	}

	/**
	 * Risponde alla richiesta POST /allphoto
	 * @param filter contenente un JSON con i filtri da applicare 
	 * @return un ArrayList di String con tutti i dati relativi alle foto opportunamente filtrati
	 * @throws InternalGeneralException       se vengono generati errori generali interni al server
	 * @throws FilterNotFoundException        se vengono generati errori di Filtro non trovato.
	 * @throws FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
	 */

	@RequestMapping(value = "allphoto", method = RequestMethod.POST)

	public ArrayList<String> getDataWithPost(@RequestBody Object filter)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

		return Database.getPhotoDataString(JSONParser.jsonParserName(filter));
	}

	/**
	 * Risponde alla richiesta POST /photostats
	 * 
	 * @param filter contenente un JSON con i filtri da applicare 
	 * @return un ArrayList di String con tutti i dati relativi alle foto opportunamente filtrati
	 * @throws InternalGeneralException       se vengono generati errori generali interni al server
	 * @throws FilterNotFoundException        se vengono generati errori di Filtro non trovato.
	 * @throws FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
	 */
	@RequestMapping(value = "photostats", method = RequestMethod.POST)

	public ArrayList<String> getStatsWithPost(@RequestBody Object filter)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

		return Database.getStats(JSONParser.jsonParserName(filter));
	}
}

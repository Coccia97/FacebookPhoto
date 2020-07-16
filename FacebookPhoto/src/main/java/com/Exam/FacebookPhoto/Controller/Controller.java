package com.Exam.FacebookPhoto.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Exam.FacebookPhoto.Exceptions.FilterIllegalArgumentException;
import com.Exam.FacebookPhoto.Exceptions.FilterNotFoundException;
import com.Exam.FacebookPhoto.Exceptions.InternalGeneralException;
import com.Exam.FacebookPhoto.service.JSONParser;
import com.Exam.FacebookPhoto.service.StringParser;

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
	 * @return un ArrayList<String> con tutti i dati relativi alle foto
	 * 
	 */
	@RequestMapping(value = "allphoto", method = RequestMethod.GET)
	public ArrayList<String> getallphoto() {

		return StringParser.getPhotoDataString(StringParser.DataConverter());
	}

	/**
	 * Risponde alla richiesta GET /photostats
	 * 
	 * @return un ArrayList<String> con tutti i dati relativi alle statistiche delle foto
	 */

	@RequestMapping(value = "photostats", method = RequestMethod.GET)
	public ArrayList<String> getphotostats() {

		return StringParser.getStats(StringParser.DataConverter());
	}

	/**
	 * Risponde alla richiesta POST /allphoto
	 * @param filter contenente un JSON con i filtri da applicare 
	 * @return un ArrayList<String> con tutti i dati relativi alle foto opportunamente filtrati
	 * @throws InternalGeneralException       se vengono generati errori generali interni al server
	 * @throws FilterNotFoundException        se vengono generati errori di Filtro non trovato.
	 * @throws FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
	 */

	@RequestMapping(value = "allphoto", method = RequestMethod.POST)

	public ArrayList<String> getDataWithPost(@RequestBody Object filter)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

		return StringParser.getPhotoDataString(JSONParser.jsonParserColumn(filter));
	}

	/**
	 * Risponde alla richiesta POST /photostats
	 * 
	 * @param filter contenente un JSON con i filtri da applicare 
	 * @return un ArrayList<String> con tutti i dati relativi alle foto opportunamente filtrati
	 * @throws InternalGeneralException       se vengono generati errori generali interni al server
	 * @throws FilterNotFoundException        se vengono generati errori di Filtro non trovato.
	 * @throws FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
	 */
	@RequestMapping(value = "photostats", method = RequestMethod.POST)

	public ArrayList<String> getStatsWithPost(@RequestBody Object filter)
			throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

		return StringParser.getStats(JSONParser.jsonParserColumn(filter));
	}
}

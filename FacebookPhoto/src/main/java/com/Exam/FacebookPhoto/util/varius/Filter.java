package com.Exam.FacebookPhoto.util.varius;

import com.Exam.FacebookPhoto.model.PhotoData;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Rappresenta l'interfaccia per i filtri
 * @author Andrea Marcheggiani
 * @author Francesco Columbaro
 *
 */

public interface Filter {
	
	/**
	 * Metodo che restituisce True se photodata rispetta le caratteristiche
	 * richieste dal filtro che implementa l'interfaccia
	 * @param photodata su cui si vuole eseguire la verifica
	 * @return risposta della verifica
	 */
	
	public boolean filter(PhotoData photodata);  


}

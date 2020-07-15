package com.Exam.FacebookPhoto.util.varius;

import com.Exam.FacebookPhoto.Model.PhotoData;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


 //Rappresenta l interfaccia per i filtri.
public interface Filter {
	
	public boolean filter(PhotoData photodata);  /*questo metodo restituisce True se il record rispetta le caratteristiche 
	                                        richeste del filtro che implementa l'interfaccia.*/


}

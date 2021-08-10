package fr.humanbooster.fx.facturation.service;

import java.util.List;

import fr.humanbooster.fx.facturation.business.Prestation;

public interface PrestationService {

	public List<Prestation> recupererPrestations();
	
	public Prestation recupererPrestation(Long id);
}

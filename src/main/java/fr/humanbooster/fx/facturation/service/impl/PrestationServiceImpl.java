package fr.humanbooster.fx.facturation.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.service.PrestationService;

public class PrestationServiceImpl implements PrestationService {

	private static List<Prestation> prestations = new ArrayList<>();

	public PrestationServiceImpl() {
		if (prestations.isEmpty()) {
			prestations.add(new Prestation("Prestation1", 10F));
			prestations.add(new Prestation("Prestation2", 20F));
			prestations.add(new Prestation("Prestation3", 30F));
			prestations.add(new Prestation("Prestation4", 40F));
		}
	}

	@Override
	public List<Prestation> recupererPrestations() {
		return prestations;
	}

	@Override
	public Prestation recupererPrestation(Long id) {
		for (Prestation prestation : prestations) {
			if (prestation.getId().equals(id)) {
				return prestation;
			}
		}
		return null;
	}

}

package fr.humanbooster.fx.facturation.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;
import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.service.FactureService;
import fr.humanbooster.fx.facturation.service.LigneFactureService;
import fr.humanbooster.fx.facturation.service.PrestationService;

public class LigneFactureServiceImpl implements LigneFactureService {

	private static List<LigneFacture> lignesFactures = new ArrayList<>();
	private static PrestationService ps = new PrestationServiceImpl();
	private static FactureService fs = new FactureServiceImpl();

	@Override
	public LigneFacture ajouterLigneFacture(Long idFacture, Long idPrestation, float quantite, Float remise) {
		Prestation prestation = ps.recupererPrestation(idPrestation);
		Facture facture = fs.recupererFacture(idFacture);
		LigneFacture ligneFacture = new LigneFacture(prestation, facture, quantite, remise);
		lignesFactures.add(ligneFacture);
		return ligneFacture;
	}

	@Override
	public List<LigneFacture> recupererLigneFactures() {
		return lignesFactures;
	}

	@Override
	public LigneFacture recupererLigneFacture(Long id) {
		for (LigneFacture ligneFacture : lignesFactures) {
			if (ligneFacture.getId().equals(id)) {
				return ligneFacture;
			}
		}
		return null;
	}

	@Override
	public List<LigneFacture> recupererLigneFacturesParFacture(Facture facture) {
		List<LigneFacture> ligneFacturesByClient = new ArrayList<LigneFacture>();
		for (LigneFacture ligne : lignesFactures) {
			if (ligne.getFacture().equals(facture)) {
				ligneFacturesByClient.add(ligne);
			}
		}
		return ligneFacturesByClient;
	}

}

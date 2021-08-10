package fr.humanbooster.fx.facturation.service;

import java.util.List;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;

public interface LigneFactureService {

	public LigneFacture ajouterLigneFacture(Long idFacture, Long idPrestation, float quantite, Float remise);
	
	public List<LigneFacture> recupererLigneFactures();
	
	public LigneFacture recupererLigneFacture(Long id);
	
	public List<LigneFacture> recupererLigneFacturesParFacture(Facture facture);
	
	
}

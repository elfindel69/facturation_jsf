package fr.humanbooster.fx.facturation.service;

import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;

public interface FactureService {

	public Facture ajouterFacture(Long idClient, Date dateEcheance);
	
	public List<Facture> recupererFactures();
	
	public Facture recupererFacture(Long id);
	
	public List<Facture> recupererFactureParClient(Client client);
	
	public float calculerTotal(Facture facture);
	
}

package fr.humanbooster.fx.facturation.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.business.LigneFacture;
import fr.humanbooster.fx.facturation.service.ClientService;
import fr.humanbooster.fx.facturation.service.FactureService;

public class FactureServiceImpl implements FactureService {

	private static List<Facture> factures = new ArrayList<>();
	private ClientService clientService = new ClientServiceImpl();
	
	@Override
	public Facture ajouterFacture(Long idClient, Date dateEcheance) {
		Client client = clientService.recupererClient(idClient);
		Facture facture = new Facture(client);
		facture.setDateEcheance(dateEcheance);
		factures.add(facture);
		return facture;
	}

	@Override
	public List<Facture> recupererFactures() {
		return factures;
	}

	@Override
	public Facture recupererFacture(Long id) {
		for (Facture facture : factures) {
			if (facture.getId().equals(id)) {
				return facture;
			}
		}
		return null;
	}

	@Override
	public List<Facture> recupererFactureParClient(Client client) {
		List<Facture> facturesByClient = new ArrayList<Facture>();
		for (Facture facture : factures) {
			if (facture.getClient().equals(client)) {
				facturesByClient.add(facture);
			}
		}
		return facturesByClient;
	}

	@Override
	public float calculerTotal(Facture facture) {
		float total = 0.0f;
		
		for(LigneFacture ligne : facture.getLignes()) {
			total += (ligne.getPrestation().getMontant()*ligne.getQuantite())-ligne.getRemise();
		}
		
		return total;
	}

}

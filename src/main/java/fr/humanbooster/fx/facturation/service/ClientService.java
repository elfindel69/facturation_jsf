package fr.humanbooster.fx.facturation.service;

import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;

public interface ClientService {

	public Client ajouterClient(String nom);
	
	public List<Client> recupererClients();
	
	public Client recupererClient(Long id);

	public void modifierClient(Long id, Client client);
	
	public void supprimerClient(Client client);
}

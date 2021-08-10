package fr.humanbooster.fx.facturation.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.service.ClientService;

public class ClientServiceImpl implements ClientService {

	private static List<Client> clients = new ArrayList<>();

	public ClientServiceImpl() {
		if (clients.isEmpty()) {
			clients.add(new Client("Client1"));
			clients.add(new Client("Client2"));
			clients.add(new Client("Client3"));
			clients.add(new Client("Client4"));
		}
	}

	@Override
	public Client ajouterClient(String nom) {
		Client client = new Client(nom);
		clients.add(client);
		return client;
	}

	@Override
	public List<Client> recupererClients() {
		return clients;
	}

	@Override
	public Client recupererClient(Long id) {
		for (Client client : clients) {
			if (client.getId().equals(id)) {
				return client;
			}
		}
		return null;
	}

	@Override
	public void modifierClient(Long id, Client pClient) {
		int idx = 0;
		for (Client client : clients) {
			if (client.getId().equals(id)) {
				clients.set(idx, pClient);
				break;
			}
			idx++;
		}
		
	}

	@Override
	public void supprimerClient(Client pClient) {
		int idx = 0;
		for (Client client : clients) {
			if (client.getId().equals(pClient.getId())) {
				break;
			}
			idx++;
		}
		clients.remove(idx);
	}

}

package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.service.ClientService;
import fr.humanbooster.fx.facturation.service.impl.ClientServiceImpl;

@ManagedBean(name = "clientBean")
@SessionScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClientService clientService = new ClientServiceImpl();
	private Client client;
	
	public ClientBean() {
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String init(Client client) {
		if (client!=null) {
			this.client = client;
			this.client.setId(client.getId());
		}
		else {
			this.client = new Client();
		}
		return "client";
	}
	
	public String enregistrerClient(Client client) {
		System.out.println(client);
		if (clientService.recupererClients().contains(client)) {
			clientService.modifierClient(client.getId(), client);
		}
		else {
			clientService.ajouterClient(client.getNom());
		}
		return "index";
	}
	
	public String supprimerClient(Client client) {
		this.client = client;
		System.out.println(client);
		client.setId(client.getId());
		clientService.supprimerClient(client);
		return "index";
	}


}

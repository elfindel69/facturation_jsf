package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.service.ClientService;
import fr.humanbooster.fx.facturation.service.impl.ClientServiceImpl;
@ManagedBean(name = "ajouterClientBean")
@RequestScoped
public class AjouterClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ClientService clientService = new ClientServiceImpl();
	private Client client;
	
	public AjouterClientBean() {
		client = new Client();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public static ClientService getClientservice() {
		return clientService;
	}
	
	public String add() {
		return "ajouterClient";
	}
	
	
	public String ajouterClient() {
		clientService.ajouterClient(client.getNom());
		return "index";
	}

}

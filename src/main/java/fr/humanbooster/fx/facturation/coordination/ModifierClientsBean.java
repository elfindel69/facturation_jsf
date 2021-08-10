package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.service.ClientService;
import fr.humanbooster.fx.facturation.service.impl.ClientServiceImpl;

@ManagedBean(name = "modifierClientsBean")
@SessionScoped
public class ModifierClientsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final ClientService clientService = new ClientServiceImpl();
	private Client client;
	
	public ModifierClientsBean() {
		if(client == null) {
			client = new Client();
		}
		
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
	
	public String init(Client client) {
		this.client = client;
		this.client.setId(client.getId());
		return "modifierClients";
	}
	
	public String modifierClient() {
		
		clientService.modifierClient(client.getId(),client);
		return "index?faces-redirect=true";
	}
	

}

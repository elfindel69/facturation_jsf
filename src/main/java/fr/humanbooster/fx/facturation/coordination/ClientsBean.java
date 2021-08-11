package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.service.ClientService;
import fr.humanbooster.fx.facturation.service.FactureService;
import fr.humanbooster.fx.facturation.service.impl.ClientServiceImpl;
import fr.humanbooster.fx.facturation.service.impl.FactureServiceImpl;


@ManagedBean(name = "clientsBean")
@RequestScoped
public class ClientsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final ClientService clientService = new ClientServiceImpl();
	private static final FactureService factureService = new FactureServiceImpl();
	private static Client client;
	
	public ClientsBean() {
		client = new Client();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		ClientsBean.client = client;
	}

	public static ClientService getClientservice() {
		return clientService;
	}

	public static FactureService getFactureservice() {
		return factureService;
	}
	
	public List<Client> getClients() {
		return clientService.recupererClients();
	}
	
	
}

package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.humanbooster.fx.facturation.business.Client;
import fr.humanbooster.fx.facturation.service.FactureService;
import fr.humanbooster.fx.facturation.service.impl.FactureServiceImpl;
@ManagedBean(name = "ajouterFacturesBean")
@SessionScoped
public class AjouterFactureBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final FactureService factureService = new FactureServiceImpl();
	private Client client;
	private Date dateEcheance;
	public AjouterFactureBean () {
		client = new Client();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public static FactureService getFactureservice() {
		return factureService;
	}
	
	public String init(Client client) {
		this.client = client;
		this.client.setId(client.getId());
		return "ajouterFacture?faces-redirect=true";
	}
	
	public String ajouterFacture() {

		factureService.ajouterFacture(client.getId(), dateEcheance);
		return "index?faces-redirect=true";
	}

}

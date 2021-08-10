package fr.humanbooster.fx.facturation.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Facture {

	private Long id;
	private Date dateCreation;
	private Date dateEcheance;
	private Client client;
	private static Long cptID = 0L;
	private List<LigneFacture> lignes = new ArrayList<LigneFacture>();

	public Facture() {
		id = ++cptID;
	}
	
	public Facture(Client client) {
		this();
		this.client = client;
		dateCreation = new Date();
		this.client.getFactures().add(this);
	}

	public Facture(Date dateCreation, Date dateEcheance, Client client) {
		this();
		this.dateCreation = dateCreation;
		this.dateEcheance = dateEcheance;
		this.client = client;
		this.client.getFactures().add(this);
	}

	public Facture(Long id, Date dateCreation, Date dateEcheance, Client client) {
		
		this.id = id;
		this.dateCreation = dateCreation;
		this.dateEcheance = dateEcheance;
		this.client = client;
		this.client.getFactures().add(this);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<LigneFacture> getLignes(){
		return lignes;
	}
	
	public void addLigne(LigneFacture ligne) {
		lignes.add(ligne);
	}

	@Override
	public String toString() {
		return "Facture [id=" + id + ", dateCreation=" + dateCreation + ", dateEcheance=" + dateEcheance + ", client="
				+ client.getNom() + "]";
	}
	
}

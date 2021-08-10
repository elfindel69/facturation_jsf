package fr.humanbooster.fx.facturation.business;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private static Long cptID = 0L;
	private Long id;
	private String nom;
	private List<Facture> factures = new ArrayList<Facture>();
	
	public Client() {
		id = ++cptID;
	}
	
	public Client(String nom) {
		this();
		this.nom = nom;
	}

	public Client(Long id, String nom) {
		this(nom);
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public List<Facture> getFactures(){
		return factures;
	}
	
	public void setFactures(List<Facture> factures){
		this.factures = factures;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + "]";
	}
	
}
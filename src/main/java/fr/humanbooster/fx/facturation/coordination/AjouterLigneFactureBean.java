package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.humanbooster.fx.facturation.business.Prestation;
import fr.humanbooster.fx.facturation.service.LigneFactureService;
import fr.humanbooster.fx.facturation.service.PrestationService;
import fr.humanbooster.fx.facturation.service.impl.LigneFactureServiceImpl;
import fr.humanbooster.fx.facturation.service.impl.PrestationServiceImpl;


@ManagedBean(name = "ajouterLigneFactureBean")
@SessionScoped
public class AjouterLigneFactureBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final LigneFactureService ligneFactureService = new LigneFactureServiceImpl();
	private static final PrestationService prestationService = new PrestationServiceImpl();
	private Long factureID;
	private Long prestationID;
	private String quantiteString;
	private String remiseString;
	
	
	public AjouterLigneFactureBean() {
	}

	public Long getFactureID() {
		return factureID;
	}

	public void setFacture(Long factureID) {
		this.factureID = factureID;
	}

	public Long getPrestationID() {
		return prestationID;
	}

	public void setPrestationID(Long prestationID) {
		this.prestationID = prestationID;
	}

	public String getQuantiteString() {
		return quantiteString;
	}

	public void setQuantiteString(String quantiteString) {
		this.quantiteString = quantiteString;
	}

	public String getRemiseString() {
		return remiseString;
	}

	public void setRemiseString(String remiseString) {
		this.remiseString = remiseString;
	}

	public static LigneFactureService getLignefactureservice() {
		return ligneFactureService;
	}

	public static PrestationService getPrestationservice() {
		return prestationService;
	}
	
	public List<Prestation> getPrestations(){
		return prestationService.recupererPrestations();
	}
	
	public String init(Long factureID) {
		this.factureID = factureID;
		
		return "ajouterLigneFacture";
	}
	
	
	
	public String ajouterLigne() {
		float quantite = Float.parseFloat(quantiteString);
		float remise = Float.parseFloat(remiseString);
		ligneFactureService.ajouterLigneFacture(factureID, prestationID, quantite, remise);
		return "factures";
	}

}

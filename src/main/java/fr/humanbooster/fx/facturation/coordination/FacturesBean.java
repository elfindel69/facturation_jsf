package fr.humanbooster.fx.facturation.coordination;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.humanbooster.fx.facturation.business.Facture;
import fr.humanbooster.fx.facturation.service.FactureService;
import fr.humanbooster.fx.facturation.service.PrestationService;
import fr.humanbooster.fx.facturation.service.impl.FactureServiceImpl;
import fr.humanbooster.fx.facturation.service.impl.PrestationServiceImpl;

@ManagedBean(name = "facturesBean")
@SessionScoped
public class FacturesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static final FactureService factureService = new FactureServiceImpl();
	private Facture facture;
	
	public FacturesBean() {
		facture = new Facture();
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	
	public String init(Facture facture) {
		this.facture = facture;
		this.facture.setId(facture.getId());
		
		return "factures";
	}
	
	public float getTotal() {
		
		return factureService.calculerTotal(facture);
	}
}

package fr.humanbooster.fx.facturation.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent evenement) {
		System.out.println("Connexion");
	}

	/**
	 * Patron Observateur/Observé
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent evenement) {
		System.out.println("Déconnexion");
	}

}

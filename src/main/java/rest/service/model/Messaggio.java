package rest.service.model;

import model.Utente;

public class Messaggio {

	private String messaggio;
	private Utente utene;

	public Utente getUtene() {
		return utene;
	}

	public void setUtene(Utente utene) {
		this.utene = utene;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

}

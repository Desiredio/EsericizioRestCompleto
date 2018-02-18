package model;

import java.io.Serializable;


public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idUtente;

	private String cognome;

	private String nome;

	public Utente() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
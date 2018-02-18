package model;

import java.io.Serializable;


public class Bilancio implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idBilancio;

	private String data;

	private float importo;

	private String motivospesa;

	public Bilancio() {
	}

	public int getIdBilancio() {
		return idBilancio;
	}

	public void setIdBilancio(int idBilancio) {
		this.idBilancio = idBilancio;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}

	public String getMotivospesa() {
		return motivospesa;
	}

	public void setMotivospesa(String motivospesa) {
		this.motivospesa = motivospesa;
	}

	@Override
	public String toString() {
		return "Bilancio [idBilancio=" + idBilancio + ", motivospesa=" + motivospesa + ", importo=" + importo
				+ ", data=" + data + "]";
	}

}
package br.com.rango.model;

import java.util.ArrayList;

public class Cardapio {
	private ArrayList<Prato> prato;
	public Cardapio(ArrayList<Prato> prato) {
		setPrato(prato);
	}

	public ArrayList<Prato> getPrato() {
		return prato;
	}

	public void setPrato(ArrayList<Prato> prato) {
		this.prato = prato;
	}

}

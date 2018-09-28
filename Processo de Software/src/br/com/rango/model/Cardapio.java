package br.com.rango.model;

import java.util.ArrayList;

public class Cardapio {
	private ArrayList<Prato> prato;
	public Cardapio() {
		setPrato(new ArrayList<Prato>());
	}

	public ArrayList<Prato> getPrato() {
		return prato;
	}

	public void setPrato(ArrayList<Prato> prato) {
		this.prato = prato;
	}

}

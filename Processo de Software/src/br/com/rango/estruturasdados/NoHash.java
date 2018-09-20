package br.com.rango.estruturasdados;

import br.com.rango.controler.Proprietario;

public class NoHash {
	public NoHash prox, ant;
	public Proprietario proprietario;

	public NoHash(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}

package br.com.rango.estruturasdados;

import br.com.rango.model.Proprietario;

public class NoHash {
	public NoHash prox, ant;
	public Proprietario proprietario;

	public NoHash(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

}

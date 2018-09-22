package br.com.rango.estruturasdados.usuario;

import br.com.rango.model.*;

public class NoHashU {
	public NoHashU prox, ant;
	public Usuario usuario;

	public NoHashU(Usuario usuario) {
		this.usuario = usuario;
	}

}

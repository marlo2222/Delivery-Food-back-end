package br.com.rango.estruturasdados.usuario;

import br.com.rango.model.*;

public class ListaEnHashU {
	public NoHashU inicio;
	public NoHashU fim;
	public int contador;

	public void adicionar(Usuario usuario) {
		NoHashU novo = new NoHashU(usuario);
		if (contador == 0) {
			fim = inicio = novo;
		} else {
			fim.prox = novo;
			novo.ant = fim;
			fim = novo;
		}
		contador++;
	}
}

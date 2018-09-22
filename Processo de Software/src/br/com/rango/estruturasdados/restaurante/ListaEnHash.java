package br.com.rango.estruturasdados.restaurante;

import br.com.rango.model.Proprietario;

public class ListaEnHash {
	public NoHash inicio;
	public NoHash fim;
	public int contador;

	public void adicionar(Proprietario proprietario) {
		NoHash novo = new NoHash(proprietario);
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

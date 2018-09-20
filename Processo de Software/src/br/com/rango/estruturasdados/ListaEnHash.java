package br.com.rango.estruturasdados;

import br.com.rango.controler.Proprietario;

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

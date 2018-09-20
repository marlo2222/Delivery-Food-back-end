package br.com.rango.model;

import java.util.Scanner;

import br.com.rango.controler.ControlerTelaInicial;
import br.com.rango.estruturasdados.Hash;
import br.com.rango.viens.TelaInicial;

public class MainTeste {
	public static void main(String[] args) {
		new TelaInicial(new Model(new ControlerTelaInicial()));
	}
}

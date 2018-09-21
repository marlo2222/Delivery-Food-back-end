package br.com.rango.model;

import java.util.Scanner;

import br.com.rango.controller.ControllerTelaInicial;
import br.com.rango.estruturasdados.Hash;
import br.com.rango.views.TelaInicial;

public class MainTeste {
	public static void main(String[] args) {
		new TelaInicial(new Model(new ControllerTelaInicial()));
	}
}

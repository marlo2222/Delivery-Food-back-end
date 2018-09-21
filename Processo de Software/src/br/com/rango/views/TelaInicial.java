package br.com.rango.views;

import java.util.Scanner;

import br.com.rango.controller.ControllerTelaInicial;
import br.com.rango.model.Model;

public class TelaInicial {
	public Model model;
	public ControllerTelaInicial controler;
	Scanner input = new Scanner(System.in);
	
	public TelaInicial(Model model) {
		this.model = model;
		this.controler = new ControllerTelaInicial(model,this);
		iniciar();
	}
	
	public void iniciar() {
		controler.acaoTelaInicial();
	}
	
	public char telaInicial() {
		System.out.println("1-logar");
		System.out.println("2-cadastrar");
		System.out.println("3-cadastre seu restaurante");
		System.out.println("4-sair");
		return(input.nextLine().charAt(0));
	}
}

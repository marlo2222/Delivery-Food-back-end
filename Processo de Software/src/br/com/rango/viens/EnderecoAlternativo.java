package br.com.rango.viens;

import java.util.Scanner;

import br.com.rango.controler.ControlerTelaInicial;
import br.com.rango.model.Model;

public class EnderecoAlternativo {
	
	public Model model;
	public ControlerTelaInicial controler;
	Scanner input = new Scanner(System.in);
	
	public EnderecoAlternativo(Model model) {
		this.model = model;
		this.controler = new ControlerTelaInicial(model,this);
		iniciar();
	}
	
	public void iniciar() {
		controler.acaoTelaEnderecoAlternativo();
	}
	
	public char TelaDeEntrega() {
		System.out.println("Escolha o endere�o de entrega");
		System.out.println("1- Usar endere�o de cadastro");
		System.out.println("2- Usar endere�o alternativo");
		System.out.println("3- sair");
		return input.nextLine().charAt(0);
	}

}

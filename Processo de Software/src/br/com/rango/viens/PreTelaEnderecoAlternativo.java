package br.com.rango.viens;

import java.util.Scanner;

import br.com.rango.controler.Controler;
import br.com.rango.controler.Model;

public class PreTelaEnderecoAlternativo {
	
	public Model model;
	public Controler controler;
	Scanner input = new Scanner(System.in);
	
	public PreTelaEnderecoAlternativo(Model model) {
		this.model = model;
		this.controler = new Controler(model,this);
		iniciar();
	}
	
	public void iniciar() {
		controler.acaoTelaEnderecoAlternativo();
	}
	
	public char TelaDeEntrega() {
		System.out.println("Escolha o endereço de entrega");
		System.out.println("1- Usar endereço de cadastro");
		System.out.println("2- Usar endereço alternativo");
		System.out.println("3- sair");
		return input.nextLine().charAt(0);
	}

}

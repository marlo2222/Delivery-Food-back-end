package br.com.rango.views;

import java.util.Scanner;

import br.com.rango.model.Proprietario;

public class ViewDadosCadastro {
	Scanner input = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);

	public String nome() {
		System.out.println("digite seu nome:");
		return input.nextLine();
	}

	public String email() {
		System.out.println("Digite o email:");
		return input.nextLine();
	}

	public String cpf() {
		System.out.println("Digite seu Cpf:");
		return input.nextLine();
	}

	public String telefone() {
		System.out.println("informe seu telefone:");
		return input.nextLine();
	}

	public String rg() {
		System.out.println("informe seu Rg:");
		return input.nextLine();
	}
	public int senha() {
		System.out.println("Defina sua senha:");
		return inputInt.nextInt();
	}
	
}

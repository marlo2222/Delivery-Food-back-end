package Viem;

import java.util.Scanner;

import Negocios.Proprietario;

public class ViemCadastro {
	Scanner input = new Scanner(System.in);

	public String nome() {
		System.out.println("digite seu nome:");
		return input.nextLine();
	}

	public String email() {
		System.out.println("Digite o email:");
		return input.nextLine();
	}

	public String cnpj() {
		System.out.println("Digite o cnpj da sua empresa:");
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
}
package Viem;

import java.util.Scanner;

import Negocios.Endereco;

public class ViemDadosRestaurante {
	Scanner input = new Scanner(System.in);

	public String nomeRestaurante() {
		System.out.println("Nome do restaurante:");
		return input.nextLine();
	}

	public String horarioFuncionamento() {
		System.out.println("Digite o horaario de funcionamento do restaurante:");
		return input.nextLine();
	}

	public String telefoneContato() {
		System.out.println("telefone contato:");
		return input.nextLine();
	}

	public Endereco endereco() {
		Endereco dados = new Endereco();
		System.out.println("Digite o nome da rua:");
		dados.setRua(input.nextLine());
		System.out.println("Digite o bairro");
		dados.setBairro(input.nextLine());
		System.out.println("Digite o numero do endere�o");
		dados.setNumero(input.nextLine());
		System.out.println("digite seu estado:");
		dados.setEstado(input.nextLine());
		System.out.println("digie o municipio:");
		dados.setMunicipio(input.nextLine());

		return dados;
	}

}

package Negocios;

import java.util.Scanner;

public class ViemCadastro {
	Scanner input = new Scanner(System.in);

	public Proprietario dadosProprietario() {
		Proprietario novo = new Proprietario();
		
		
		System.out.println("digite seu email");
		novo.setEmailProprietario(input.nextLine());
		System.out.println("Digite o Cnpj de sua empresa:");
		novo.setCnpj(input.nextLine());
		System.out.println("Digite o telefone para contato:");
		novo.setContatoProprietario(input.nextLine());
		System.out.println("informe seu Rg:");
		novo.setRgProprietario(input.nextLine());
		return novo;
	}
	public String nome() {
		System.out.println("digite seu nome:");
		return input.nextLine();
	}
}

package br.com.rango.views;

import java.util.Scanner;

public class ViemMenuUsuarioEdicao {
	Scanner input = new Scanner(System.in);
	public  char menuEdicao() {
		System.out.println("MENU EDI��O:");
		System.out.println("1 - editar seus dados:");
		System.out.println("2 - editar endere�o:");
		return input.nextLine().charAt(0);
	}
	public char menuEscolha() {
		System.out.println("qual campo deseja modificar:");
		System.out.println("1 - E-mail");
		System.out.println("2 - contato");
		System.out.println("3 - senha");
		System.out.println("4 - endere�o padr�o");
		return input.nextLine().charAt(0);
	}

}

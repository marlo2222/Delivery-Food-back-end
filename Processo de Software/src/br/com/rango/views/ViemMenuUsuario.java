package br.com.rango.views;

import java.util.Scanner;

public class ViemMenuUsuario {
	Scanner input = new Scanner(System.in);

	public char menuUsuario() {
		System.out.println("MENU INICIAL=>MENU USUARIO");
		System.out.println("1- Realizar um novo pedido");
		System.out.println("2- Atualizar dados");
		System.out.println("3- sair");
		return input.nextLine().charAt(0);
	}

}

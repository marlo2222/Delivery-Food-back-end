package br.com.rango.views;

import java.util.Scanner;

public class ViemAdmRestaurante {
Scanner input  = new Scanner(System.in);

public char telaAdmRestaurante() {
	System.out.println("MENU INICIAL=>MENU PROPRIETARIO=>PAINEL RESTAURANTE");
	System.out.println("1 - pedidos");
	System.out.println("2 - adicionar prato ao cardapio");
	System.out.println("3 - editar cardapio");
	System.out.println("4 - sair");
	return input.nextLine().charAt(0);
}

}

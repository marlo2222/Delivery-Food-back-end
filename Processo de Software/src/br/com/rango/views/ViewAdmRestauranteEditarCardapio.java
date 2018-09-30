package br.com.rango.views;

import java.util.Scanner;

public class ViewAdmRestauranteEditarCardapio {

Scanner input  = new Scanner(System.in);
Scanner inputInt  = new Scanner(System.in);

public char editarCardapio() {
	System.out.println("MENU INICIAL=>MENU PROPRIETARIO=>PAINEL RESTAURANTE=> EDIT CARDAPIO");
	System.out.println("1- remover prato:");
	System.out.println("2- editar prato");
	System.out.println("3 sair");
	return input.nextLine().charAt(0);
}

public int removePrato(String lista) {
	System.out.println("Escolha o prato que deseja remover");
	System.out.println(lista);
	return inputInt.nextInt();
}

public int escEditarPrato(String lista) {
		System.out.println("Escolha o prato que deseja editar:");
		System.out.println(lista);
		return inputInt.nextInt();
	
}
public int CampoEdicao() {
	System.out.println("1-> nome:");
	System.out.println("2-> ingredientes:");
	System.out.println("3-> selo:");
	System.out.println("4-> porções");
    System.out.println("5-> preço:");
    return inputInt.nextInt();
}

}

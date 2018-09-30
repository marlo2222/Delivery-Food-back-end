package br.com.rango.views;

import java.util.Scanner;

public class ViemUsuarioEdicaoEndereco {
	Scanner input = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);


	public char menuEditarEndereco() {
		System.out.println("MENU INICIAL=>MENU USUARIO=>ATUALIZAR DADOS=>EDITAR ENDEREÇO");
		System.out.println("1 - Modificar endereco padrão:");
		System.out.println("2 - Cadastra novo endereço:");
		System.out.println("3 - Remover endereco:");
		return input.nextLine().charAt(0);
	}
	
	public int listaRestaurantesUsuario(String lista) {
		System.out.println("Definir qual endereco como padrao:");
		System.out.println(lista);
		return inputInt.nextInt();
	}

}

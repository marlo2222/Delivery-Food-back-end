package br.com.rango.views;

import java.util.Scanner;

public class ViemMenuUsuarioEdicao {
	Scanner input = new Scanner(System.in);
	public  char menuEdicao() {
		System.out.println("MENU INICIAL=>MENU USUARIO=>ATUALIZAR DADOS");
		System.out.println("1 - editar seus dados:");
		System.out.println("2 - editar endereço:");
		System.out.println("3 - excluir sua conta:");
		System.out.println("4 - sair:");
		return input.nextLine().charAt(0);
	}
	public char menuEditarDados() {
		System.out.println("MENU INICIAL=>MENU USUARIO=>ATUALIZAR DADOS=>EDITAR DADOS");
		System.out.println("qual campo deseja modificar:");
		System.out.println("1 - E-mail");
		System.out.println("2 - contato");
		System.out.println("3 - senha");
		System.out.println("4 - cancelar:");
		return input.nextLine().charAt(0);
	}
	
	
}

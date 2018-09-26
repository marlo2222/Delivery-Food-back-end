package br.com.rango.views;

import java.util.Scanner;

public class ViewNotificacoes {
	Scanner input = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);

	public void ListaRestaurantes(String lista) {
		System.out.println(lista);
	}
	public int notificacaoRet() {
		System.out.println("Deseja cadastra seu endereco padrão agora?");
		System.out.println("1-> Sim");
		System.out.println("2-> Não");
		return inputInt.nextInt();
	}
	public int Lista(String lista) {
		System.out.println("Escolha o restaurante que deseja excluir:");
		System.out.println(lista);
		return inputInt.nextInt();
	}
	public void notificacao(String msg) {
		System.out.println(msg);
	}
}

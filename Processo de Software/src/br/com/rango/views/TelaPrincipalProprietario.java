package br.com.rango.views;

import java.util.Scanner;

import br.com.rango.model.Model;

public class TelaPrincipalProprietario {
	Scanner input = new Scanner(System.in);
	public char menuPropri() {
		System.out.println("1- visualizar meus restaurantes");
		System.out.println("2- cadastra novo restaurante");
		System.out.println("3 - editar restaurante:");
		System.out.println("4-sair");
		return input.nextLine().charAt(0);
	}
}

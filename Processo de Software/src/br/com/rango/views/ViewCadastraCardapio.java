package br.com.rango.views;

import java.util.Scanner;

import br.com.rango.model.*;

public class ViewCadastraCardapio {

	Scanner input = new Scanner(System.in);
	Scanner inputIN = new Scanner(System.in);
	
	public String nomePrato() {
		System.out.println("-> nome:");
		return input.nextLine();
	}
	public String Ingredientes() {
		System.out.println("-> ingredientes: \n OBS:descreva alguns ingredientes que o prato leva:");
		return input.nextLine();
	}
	public String Selo() {
		System.out.println("-> selo: \n EX: 0 lactose");
		return input.nextLine();
	}
	public String porcao() {
		System.out.println("-> porc�o: \n EX: por��o para 5 pessoas|por��o unica");
		return input.nextLine();
	}
	public float preco() {
		System.out.println("-> pre�o R$:");
		return inputIN.nextFloat();
	}

}

package br.com.rango.views;

import java.util.Scanner;

import br.com.rango.model.*;

public class ViewCadastraCardapio {

	Scanner input = new Scanner(System.in);
	Scanner inputIN = new Scanner(System.in);
	
	public Prato cadastraPrato() {
		Prato prato = new Prato();
		System.out.println("=>INFORMAÕES DO PRATO:");
		System.out.println("-> nome:");
		prato.setNome(input.nextLine());
		System.out.println("-> ingredientes: \n OBS:descreva alguns ingredientes que o prato leva:");
		prato.setIngredientes(input.nextLine());
		System.out.println("-> selo: \n EX: 0 lactose");
		prato.setSelo(input.nextLine());
		System.out.println("-> porcão: \n EX: porção para 5 pessoas|porção unica");
		prato.setPorcao(input.nextLine());
		System.out.println("-> preço R$:");
		//prato.setPreco(inputIN.nextFloat());
		return prato;
	}

}
